/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImplementsDAO;

import DAO.TipoContatoDAO;
import Entidades.TipoContato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alunos
 */
public class TipoContatoDAOImplements implements TipoContatoDAO {

    private Connection conexao;

    @Override
    public boolean inserir(Object obj) throws Exception {
        try {
            conexao = SessionFactory.getConnection();
            TipoContato tipoContato = (TipoContato) obj;
            PreparedStatement statement = conexao.prepareStatement("insert into tipoContato (nome) values ( ? );", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, tipoContato.getNome());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                Integer idInserido = rs.getInt(1);
                tipoContato.setId(idInserido);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return false;
    }

    @Override
    public boolean update(Object objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object pesquisar(Integer id) throws Exception {
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("select * from tipoContato where id = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                TipoContato tipo = new TipoContato();
                tipo.setId(rs.getInt("id"));
                tipo.setNome(rs.getString("nome"));
                return (Object) tipo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return null;
    }
    
    
    @Override
     public  TipoContato pesquisarNome(String nome) throws Exception {
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("select * from tipoContato where nome = ?");
            statement.setString(1, nome);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                TipoContato tipoContato = new TipoContato();
                tipoContato.setId(rs.getInt("id"));
                tipoContato.setNome(rs.getString("nome"));
                return tipoContato;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return null;
    }
    
    

    @Override
    public boolean excluir(Integer id) throws Exception {
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("select * from contato where id_tipoContato = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) {
                PreparedStatement stment = conexao.prepareStatement("delete from tipoContato where id = ?");
                stment.setInt(1, id);
                return stment.executeUpdate() != 0;
            } 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return false;
    }

    @Override
    public List<Object> pesquisarTodos() throws ClassNotFoundException, SQLException {
        try {
            conexao = SessionFactory.getConnection();
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery("select * from tipoContato");
            List<Object> listaTipos = new ArrayList<>();
            while (rs.next()) {
                TipoContato tipo = new TipoContato();
                tipo.setId(rs.getInt("id"));
                tipo.setNome(rs.getString("nome"));
                listaTipos.add(tipo);
            }
            return listaTipos;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return null;
    }
    
    
        public int retornaProximoId() throws SQLException, ClassNotFoundException {
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement stm = conexao.prepareStatement("SHOW TABLE STATUS LIKE 'tipoContato'");
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
               return rs.getInt("auto_increment");
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
