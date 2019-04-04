/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Entidades.Contato;
import Entidades.Telefone;
import ImplementsDAO.ContatoDAOImplements;
import ImplementsDAO.TelefoneDAOImplements;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alunos
 */
public final class JPanelTelefones extends javax.swing.JPanel implements InterfaceGerenciaTabela {

    /**
     * Creates new form JPanelTelefonesx
     * @param contato
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public JPanelTelefones(Contato contato) throws SQLException, ClassNotFoundException {
        initComponents();
        jTextFieldUsuarioNome.setText(contato.getNome());

        TelefoneDAOImplements telImplements = new TelefoneDAOImplements();
        List<Object> telefones = telImplements.pesquisarTodos(contato.getId());
        if (telefones.size() > 0) {
            carregaTabela(telefones);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabelTituloTelefone = new javax.swing.JLabel();
        jLabelFoneUsuario = new javax.swing.JLabel();
        jLabelDDDFone = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();
        jTextFieldUsuarioNome = new javax.swing.JTextField();
        jTextFieldDDD = new javax.swing.JTextField();
        jTextFieldTelefone = new javax.swing.JTextField();
        jButtonIncluirFone = new javax.swing.JButton();
        jButtonDeletaFone = new javax.swing.JButton();
        jButtonSairFone = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(2137483647, 2147483647));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabelTituloTelefone.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabelTituloTelefone.setText("TELEFONE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        jPanel1.add(jLabelTituloTelefone, gridBagConstraints);

        jLabelFoneUsuario.setText("Usuário:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jLabelFoneUsuario, gridBagConstraints);

        jLabelDDDFone.setText("DDD:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jLabelDDDFone, gridBagConstraints);

        jLabelTelefone.setText("Fone:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jLabelTelefone, gridBagConstraints);

        jTextFieldUsuarioNome.setEditable(false);
        jTextFieldUsuarioNome.setColumns(12);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jTextFieldUsuarioNome, gridBagConstraints);

        jTextFieldDDD.setColumns(5);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(jTextFieldDDD, gridBagConstraints);

        jTextFieldTelefone.setColumns(12);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(jTextFieldTelefone, gridBagConstraints);

        jButtonIncluirFone.setText("+");
        jButtonIncluirFone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirFoneActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel1.add(jButtonIncluirFone, gridBagConstraints);

        jButtonDeletaFone.setText("-");
        jButtonDeletaFone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletaFoneActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(jButtonDeletaFone, gridBagConstraints);

        jButtonSairFone.setText("Sair");
        jButtonSairFone.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonSairFone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairFoneActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        jPanel1.add(jButtonSairFone, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 60;
        add(jPanel1, gridBagConstraints);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Tipo", "DDD", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 11, 0);
        add(jScrollPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIncluirFoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirFoneActionPerformed

        if (camposPreenchidos()) {
            try {
                Integer ddd = Integer.parseInt(jTextFieldDDD.getText());
                String numero = jTextFieldTelefone.getText();

                Telefone telefone = new Telefone();
                telefone.setDDD(ddd);
                telefone.setNumero(numero);
           
                ContatoDAOImplements contatoDaoImpl = new ContatoDAOImplements();
                Contato contato = (Contato) contatoDaoImpl.pesquisarNome(jTextFieldUsuarioNome.getText());
                telefone.setContato(contato);

                TelefoneDAOImplements telefoneImp = new TelefoneDAOImplements();
                telefoneImp.inserir(telefone);

                carregaTabela(telefoneImp.pesquisarTodos(contato.getId()));
                limpaCampos();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{JOptionPane.showMessageDialog(null, "FORMATO\nDDD: xx\nTelefone: xxxxxxxxx");}

    }//GEN-LAST:event_jButtonIncluirFoneActionPerformed

    private void jButtonSairFoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairFoneActionPerformed
        Principal.chamaTelaContatos();
    }//GEN-LAST:event_jButtonSairFoneActionPerformed

    private void jButtonDeletaFoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeletaFoneActionPerformed
        int linha = jTable1.getSelectedRow();
        if (linha > -1) {
            try {
                Telefone telefone = (Telefone) retornaSelecionadoTabela();
                if (telefone != null) {
                    TelefoneDAOImplements foneImpl = new TelefoneDAOImplements();
                    ContatoDAOImplements contatoDAOImp = new ContatoDAOImplements();
                    if (foneImpl.excluir(telefone.getId())) {
                        Contato contato = (Contato) contatoDAOImp.pesquisar(telefone.getContato().getId());
                        List<Object> telefones = foneImpl.pesquisarTodos(contato.getId());
                        if (telefones.size() > 0) {
                            carregaTabela(telefones);
                        } else {
                            JOptionPane.showMessageDialog(null, "Telefones deletado");
                            carregaTabela(new ArrayList<>());
                        }
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(JPanelTelefones.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione o telefone");
        }

    }//GEN-LAST:event_jButtonDeletaFoneActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeletaFone;
    private javax.swing.JButton jButtonIncluirFone;
    private javax.swing.JButton jButtonSairFone;
    private javax.swing.JLabel jLabelDDDFone;
    private javax.swing.JLabel jLabelFoneUsuario;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JLabel jLabelTituloTelefone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldDDD;
    private javax.swing.JTextField jTextFieldTelefone;
    private javax.swing.JTextField jTextFieldUsuarioNome;
    // End of variables declaration//GEN-END:variables

    @Override
    public Object retornaSelecionadoTabela() {
        try {
            int linha = jTable1.getSelectedRow();
            int id = Integer.parseInt(jTable1.getValueAt(linha, 0).toString());
            return new TelefoneDAOImplements().pesquisar(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void limpaCampos() {
        jTextFieldDDD.setText("");
        jTextFieldTelefone.setText("");
    }

    @Override
    public boolean camposPreenchidos(){
        if (jTextFieldDDD.getText().length() > 0 && jTextFieldTelefone.getText().length() > 0) {
            if(Integer.parseInt(jTextFieldDDD.getText()) > 10)
                return true;
        }
        return false;
    }

    @Override
    public void carregaTabela(List<Object> lista) {
        List<Object> listaTelefones = lista; //passar lista vinda do banco com todos os usuarios

        String[] colunas = {"Código", "DDD", "Telefone"};
        String[][] dados = new String[listaTelefones.size()][colunas.length];
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < listaTelefones.size(); i++) {
            Telefone telefone = (Telefone) listaTelefones.get(i);
            dados[i][0] = String.valueOf(telefone.getId());
            dados[i][1] = String.valueOf(telefone.getDDD());
            dados[i][2] = String.valueOf(telefone.getNumero());
        }
        DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
        jTable1.setModel(modelo);
    }
}
