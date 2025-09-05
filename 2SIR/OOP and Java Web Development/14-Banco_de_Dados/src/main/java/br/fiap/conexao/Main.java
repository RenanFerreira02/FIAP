package br.fiap.conexao;

import br.fiap.modelo.Categoria;
import br.fiap.modelo.CategoriaDAO;
import br.fiap.modelo.Despesa;
import br.fiap.modelo.DespesaDAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*
        CategoriaDAO dao = new CategoriaDAO();

        Categoria categoria = new Categoria(4, "Alimentação");

        dao.inserir(categoria);



        List<Categoria> categorias = dao.listar();

        for (Categoria categoria : categorias) {
            System.out.println(categoria.getId() + " --> " + categoria.getCategoria());
        }
        */

        DespesaDAO dao = new DespesaDAO();

        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Despesa despesa = new Despesa();

        despesa.setDescricao("Compras do mês");
        despesa.setValor(400.0);
        despesa.setData(LocalDate.parse("21/08/2025", f));
        despesa.setCategoria(new Categoria(2L, ""));

        dao.salvar(despesa);

        for (Despesa d : dao.listar()) {
            System.out.println(d.getDescricao());
            System.out.println(d.getValor());
            System.out.println(d.getData());

        }



    }
}
