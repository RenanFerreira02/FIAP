package br.fiap.conexao;

import br.fiap.modelo.Categoria;
import br.fiap.modelo.CategoriaDAO;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CategoriaDAO dao = new CategoriaDAO();

        /*Categoria categoria = new Categoria(4, "Alimentação");*/

        /*dao.inserir(categoria);*/

        List<Categoria> categorias = dao.listar();

        for (Categoria categoria : categorias) {
            System.out.println(categoria.getId() + " --> " + categoria.getCategoria());
        }
    }
}
