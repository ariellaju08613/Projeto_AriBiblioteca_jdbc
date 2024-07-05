package com.eleodoro.biblioteca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.eleodoro.biblioteca.conexao.Conexao;


public class BibliotecaDAO {
    
    /**
     * @param bibliotecaPOJO
     */
    public void cadastrarBiblioteca(BibliotecaPOJO bibliotecaPOJO) {

        Conexao conexao = new Conexao();

        String sql = "insert into biblioteca (nome, email, telefone) values (?, ?, ?)";

        PreparedStatement ps = null;


        try {
            ps = conexao.getConexao().prepareStatement(sql);

            ps.setString(1, bibliotecaPOJO.getNome());
            ps.setString(2, bibliotecaPOJO.getEmail());
            ps.setInt(3, bibliotecaPOJO.getTelefone());

            ps.execute();
            ps.close();

            System.out.println("Dados gravados com sucesso");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problema no método cadastrar biblioteca na BibliotecaDAO");
        }
    }

    public void consultarBiblioteca(BibliotecaPOJO bibliotecaPOJO) {

        Conexao conexao = new Conexao();

        String sql = "select * from biblioteca where Id = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexao.getConexao().prepareStatement(sql);

            ps = setInt(1, bibliotecaPOJO.getId());


            rs = ps.executeQuery();

            while (rs.next()) {
                bibliotecaPOJO.setEmail(rs.getString(1));

                bibliotecaPOJO.setId(rs.getInt(1));
                bibliotecaPOJO.setNome(rs.getString(2));
                bibliotecaPOJO.setEmail(rs.getString(3));
                bibliotecaPOJO.setTelefone(rs.getInt(4));
            }

            rs.close();
            ps.close();

            System.out.println("Consulta com sucesso");
        
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problema no metodo consultar");
        }
    }

    private PreparedStatement setInt(int i, Object id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setInt'");
    }

    public void incluirBiblioteca(BibliotecaPOJO bibliotecaPOJO) {
        Conexao conexao = new Conexao();

        String sql = "update bibliotexa set nome = ?, email = ?, telefone = ? where id = ?";

        PreparedStatement ps = null;

        try {
            ps = conexao.getConexao().prepareStatement(sql);

            ps.setString(1, bibliotecaPOJO.getNome());
            ps.setString(2, bibliotecaPOJO.getEmail());
            ps.setInt(3, bibliotecaPOJO.getTelefone());
            ps.setInt(4, (int) bibliotecaPOJO.getId());

            ps.execute();
            ps.close();

            System.out.println("Inclusão com sucesso");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problema no metodo ao atualizar");
        }

    }


    public void excluirBiblioteca(BibliotecaPOJO bibliotecaPOJO) {
        Conexao conexao = new Conexao();

        String sql = "delete from biblioteca where id = ?";

        PreparedStatement ps = null;

  
        try {
            ps = conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, (int) bibliotecaPOJO.getId());

            ps.execute();
            ps.close();

            System.out.println("Exclusão com sucesso");
        
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problema no método de exclusão");
        }
    }

    public void atualizarBiblioteca(BibliotecaPOJO bibliotecaPOJO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarBiblioteca'");
    }
}