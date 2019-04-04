/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public interface InterfaceGerenciaTabela {
    
     public abstract void carregaTabela(List<Object> lista);
     
     public abstract boolean camposPreenchidos();
     
     public abstract void limpaCampos();
     
     public abstract Object retornaSelecionadoTabela();
    
}
