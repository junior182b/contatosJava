/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImplementsDAO;

import DAO.TelefoneDAO;
import Entidades.TipoContato;
import Entidades.Telefone;
import Entidades.Contato;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alunos
 */
public class TelefoneDAOImplements implements TelefoneDAO {

    private Connection conexao;

    @Override
    public boolean inserir(Object obj) throws ClassNotFoundException, SQLException {
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("insert into telefone (ddd, numero, id_contato) values ( ? , ?, ?);", Statement.RETURN_GENERATED_KEYS);
            Telefone t = (Telefone) obj;
            statement.setInt(1, t.getDDD());
            statement.setString(2, t.getNumero());
            statement.setInt(3, t.getContato().getId());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                int idTelefoneInserido = rs.getInt(1);
                t.setId(idTelefoneInserido);
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Object objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Object> pesquisarTodos(Integer id) throws SQLException {
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("select * from telefone where id_contato = ? ");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            List<Object> telefones = new ArrayList<>();
            while (rs.next()) {
                Integer codigo = rs.getInt("id");
                Integer ddd = rs.getInt("ddd");
                String numero = rs.getString("numero");

                Contato contato = new Contato();
                contato.setId(id);

                Telefone telefone = new Telefone();
                telefone.setDDD(ddd);
                telefone.setNumero(numero);
                telefone.setId(codigo);
                telefone.setContato(contato);
                telefones.add(telefone);

            }
            return telefones;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return null;
    }

    @Override
    public Object pesquisar(Integer id) throws SQLException, ClassNotFoundException {
        conexao = SessionFactory.getConnection();
        PreparedStatement stm = conexao.prepareStatement("select * from telefone where id = ?");
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        if(rs.next()){
            Telefone telefone = new Telefone();
            int identificador = rs.getInt("id");
            String numero = rs.getString("numero");
            int ddd = rs.getInt("ddd");
   
            int idUser = rs.getInt("id_contato");
            Contato c = new Contato();
            c.setId(idUser);
            
            
            telefone.setDDD(ddd);
            telefone.setId(identificador);
            telefone.setNumero(numero);
            telefone.setContato(c);
        
            return telefone;
        }
        return null;
    }

    @Override
    public boolean excluir(Integer id) throws ClassNotFoundException, SQLException {
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("delete from telefone where id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
      public Integer excluirTelefones(Integer id) throws ClassNotFoundException, SQLException {
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("delete from telefone where id_contato = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override //sem parametro de id usuario
    public List<Object> pesquisarTodos() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object pesquisarNome(String pesquisa) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
