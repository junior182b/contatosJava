/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImplementsDAO;

import ImplementsDAO.SessionFactory;
import Entidades.TipoContato;
import Entidades.Contato;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import DAO.TipoContatoDAO;
import DAO.ContatoDAO;
import Entidades.Telefone;
import com.sun.javafx.scene.control.skin.VirtualFlow;


/**
 *
 * @author Alunos
 */
public class ContatoDAOImplements implements ContatoDAO {

    private Connection conexao;
        

    @Override
    public boolean inserir(Object obj) throws Exception {
        try {
            conexao = SessionFactory.getConnection();
            Contato contato = (Contato) obj;
            PreparedStatement statement = conexao.prepareStatement("insert into contato (nome, email, nascimento, id_tipoContato) values ( ? , ? , ?, ?);", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, contato.getNome());
            statement.setString(2, contato.getEmail());
            statement.setDate(3, new Date(contato.getNascimento().getTime()));
            statement.setInt(4, contato.getTipoContato().getId());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                Integer idInserido = rs.getInt(1);
                contato.setId(idInserido);
                return true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        } finally {
            conexao.close();
        }
        return false;
    }
    

    @Override
    public boolean update(Object obj) throws Exception {
        try {
            conexao = SessionFactory.getConnection();
            Contato contato = (Contato) obj;
            PreparedStatement statement = conexao.prepareStatement("update contato set nome = ?, email = ?, nascimento = ?, id_tipoContato = ? where id = ?");
            statement.setString(1, contato.getNome());
            statement.setString(2, contato.getEmail());
            statement.setDate(3, new Date(contato.getNascimento().getTime()));
            statement.setInt(4, contato.getTipoContato().getId());
            statement.setInt(5, contato.getId());
            int executeUpdate = statement.executeUpdate();
            return executeUpdate != 0;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return false;
    }

    public int retornaProximoId() throws SQLException, ClassNotFoundException {
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement stm = conexao.prepareStatement("SHOW TABLE STATUS LIKE 'contato'");
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
               return rs.getInt("auto_increment");
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Object pesquisar(Integer id) throws Exception {
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("select * from contato where id = ? ");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                Date nascimento = rs.getDate("nascimento");
                String email = rs.getString("email");
                int idTipoContato = rs.getInt("id_tipoContato");
                Contato contato = new Contato();
                contato.setNome(nome);
                contato.setEmail(email);
                contato.setNascimento(nascimento);
                contato.setId(id);
               
                TipoContatoDAOImplements tipoDAOImp = new TipoContatoDAOImplements();
                TipoContato tipo = (TipoContato) tipoDAOImp.pesquisar(idTipoContato);
                contato.setTipoContato(tipo);
            
                return (Object) contato;
            }
        } catch (ClassNotFoundException | SQLException e) {
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
            PreparedStatement statement = conexao.prepareStatement("delete from contato where id = ?");
            statement.setInt(1, id);
            return statement.executeUpdate() != 0;
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
            Statement statmnt = conexao.createStatement();
            ResultSet resultSet = statmnt.executeQuery("select * from contato");
            List<Object> lista = new ArrayList<>();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                Date nascimento = resultSet.getDate("nascimento");
                Integer idTipoContato = resultSet.getInt("id_tipoContato");
                Contato contato = new Contato();
                contato.setId(id);
                contato.setNome(nome);
                contato.setEmail(email);
                contato.setNascimento(nascimento);
                
                
                TipoContatoDAOImplements tipoDaoImp = new TipoContatoDAOImplements();
                TipoContato tipoContato = (TipoContato) tipoDaoImp.pesquisar(idTipoContato);
     
                contato.setTipoContato(tipoContato);
                
                TelefoneDAOImplements telDAOImp = new TelefoneDAOImplements();
                List<Object> listaTelefone = telDAOImp.pesquisarTodos(contato.getId());              
                List<Telefone> telefones = new ArrayList<>();
                for(Object obj : listaTelefone){
                    telefones.add((Telefone) obj);
                }
                contato.setTelefones(telefones);
                
                
                lista.add(contato);
            }
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return null;
    }

    @Override
    public Object pesquisarNome(String pesquisa) throws Exception {
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("select * from contato where nome = ? ");
            statement.setString(1, pesquisa);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                Date nascimento = rs.getDate("nascimento");
                int idTipo = rs.getInt("id_TipoContato");
                Contato contato = new Contato();
                contato.setId(id);
                contato.setNome(nome);
                contato.setEmail(email);
                contato.setNascimento(nascimento);
        
                TipoContatoDAOImplements tipoContatoImp = new TipoContatoDAOImplements();
                TipoContato tipo = (TipoContato)tipoContatoImp.pesquisar(idTipo);
                contato.setTipoContato(tipo);
                return (Object) contato;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return null;
    }
    
   
    public List<Object> pesquisarPorTipoContato(Integer idPesquisa) throws Exception {
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("select * from contato where id_tipoContato = ? order by nome");
            statement.setInt(1, idPesquisa);
            ResultSet rs = statement.executeQuery();
            List<Object> listaContatosOrdenada = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                Date nascimento = rs.getDate("nascimento");
                int idTipo = rs.getInt("id_TipoContato");
                Contato contato = new Contato();
                contato.setId(id);
                contato.setNome(nome);
                contato.setEmail(email);
                contato.setNascimento(nascimento);
        
                TipoContatoDAOImplements tipoContatoImp = new TipoContatoDAOImplements();
                TipoContato tipo = (TipoContato)tipoContatoImp.pesquisar(idTipo);
                contato.setTipoContato(tipo);
                
                TelefoneDAOImplements telDAOImp = new TelefoneDAOImplements();
                List<Object> listaTelefone = telDAOImp.pesquisarTodos(contato.getId());              
                List<Telefone> telefones = new ArrayList<>();
                for(Object obj : listaTelefone){
                    telefones.add((Telefone) obj);
                }
                contato.setTelefones(telefones);
                listaContatosOrdenada.add(contato);
            }
            return listaContatosOrdenada;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return null;
    }
    

}
