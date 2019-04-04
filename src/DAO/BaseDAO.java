/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Contato;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alunos
 */
public interface BaseDAO {
    public boolean inserir(Object obj) throws Exception;
    public boolean update(Object objeto) throws Exception;
    public Object pesquisar(Integer id) throws Exception;
    public Object pesquisarNome(String pesquisa) throws Exception;
    public boolean excluir(Integer id) throws Exception;
    public List<Object> pesquisarTodos() throws ClassNotFoundException, SQLException;

}
