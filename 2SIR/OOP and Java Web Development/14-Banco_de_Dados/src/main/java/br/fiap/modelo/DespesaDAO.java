package br.fiap.modelo;

import br.fiap.conexao.Conexao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DespesaDAO {
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;

    public void salvar(Despesa despesa) {
        sql = "INSERT INTO java_despesa values (sequence_despesa.nextval, ?, ?, ?, ?)";

        try (Connection connection = Conexao.conectar();) {
            ps = connection.prepareStatement(sql);

            ps.setString(1, despesa.getDescricao());
            ps.setDouble(2, despesa.getValor());
            ps.setDate(3, Date.valueOf(despesa.getData()));
            ps.setLong(4, despesa.getCategoria().getId());

            ps.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir no banco de dados\n" + e);
        }

    }

    public void atualizar(Despesa despesa) {
        sql = "UPDATE java_despesa";
    }

    public List<Despesa> listar() {
        List<Despesa> lista = new ArrayList<>();

        sql = "SELECT * FROM java_despesa";

        try (Connection connection = Conexao.conectar()) {
            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Despesa despesa = new Despesa();

                despesa.setId(rs.getLong("id_despesa"));
                despesa.setDescricao(rs.getString("descricao"));
                despesa.setValor(rs.getDouble("valor"));
                despesa.setCategoria(new Categoria(rs.getLong("id_categoria"), ""));
                despesa.setData(rs.getDate("data").toLocalDate());

                lista.add(despesa);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar o banco de dados: " + e.getMessage());
        }

        return lista;
    }

    public void excluir(Long id) {
    }
}

