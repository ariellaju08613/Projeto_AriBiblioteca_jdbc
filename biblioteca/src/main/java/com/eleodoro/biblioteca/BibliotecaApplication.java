package com.eleodoro.biblioteca;

import com.eleodoro.biblioteca.conexao.Conexao;
import com.eleodoro.biblioteca.dao.BibliotecaDAO;
import com.eleodoro.biblioteca.dao.BibliotecaPOJO;
import com.eleodoro.biblioteca.modelo.Biblioteca;


public class BibliotecaApplication {

	public static void main(String[] args) {
		
		Conexao conexao  = new Conexao();
		conexao.getConexao();

		//testar inserção

		Biblioteca bibliotecaInserir = new Biblioteca();
		bibliotecaInserir.setNome("Ariella");
		bibliotecaInserir.setEmail("ariella@gmail.com");
		bibliotecaInserir.setTelefone(45999);

		BibliotecaPOJO bibliotecaPOJOInserir = new BibliotecaPOJO();
		bibliotecaPOJOInserir.setNome(bibliotecaInserir.getNome());
		bibliotecaPOJOInserir.setEmail(bibliotecaInserir.getEmail());
		bibliotecaPOJOInserir.setTelefone(bibliotecaInserir.getTelefone());

		BibliotecaDAO bibliotecaDAOInserir = new BibliotecaDAO();
		bibliotecaDAOInserir.cadastrarBiblioteca(bibliotecaPOJOInserir);

		//testar consulta

		Biblioteca bibliotecaConsultar = new Biblioteca();
		bibliotecaConsultar.setId(1);

		BibliotecaPOJO bibliotecaPOJOConsultar = new BibliotecaPOJO();
		bibliotecaPOJOConsultar.setId(bibliotecaConsultar.getId());

		BibliotecaDAO bibliotecaDAOConsultar = new BibliotecaDAO();
		bibliotecaDAOConsultar.consultarBiblioteca(bibliotecaPOJOConsultar);

		System.out.println(bibliotecaPOJOConsultar.toString());

		//testar atualização 
		Biblioteca bibliotecaAtualizar = new Biblioteca();
		bibliotecaAtualizar.setId(1);
		bibliotecaAtualizar.setNome("Ariella Julia");
		bibliotecaAtualizar.setEmail("ariellajulia@gmail.com");
		bibliotecaAtualizar.setTelefone(45888);

		BibliotecaPOJO bibliotecaPOJOAtualizar = new BibliotecaPOJO();
		bibliotecaPOJOAtualizar.setId(1);
		bibliotecaPOJOAtualizar.setNome(bibliotecaAtualizar.getNome());
		bibliotecaPOJOAtualizar.setEmail(bibliotecaAtualizar.getEmail());
		bibliotecaPOJOAtualizar.setTelefone(bibliotecaAtualizar.getTelefone());

		BibliotecaDAO bibliotecaDAOAtualizar = new BibliotecaDAO();
		bibliotecaDAOAtualizar.atualizarBiblioteca(bibliotecaPOJOAtualizar);

		// testar exclusão

		Biblioteca bibliotecaDeletar = new Biblioteca();
		bibliotecaDeletar.setId(1);

		BibliotecaPOJO bibliotecaPOJODeletar = new BibliotecaPOJO();
		bibliotecaPOJODeletar.setId(1);

		BibliotecaDAO bibliotecaDAODeletar = new BibliotecaDAO();
		bibliotecaDAODeletar.excluirBiblioteca(bibliotecaPOJODeletar);
		

	}

}
