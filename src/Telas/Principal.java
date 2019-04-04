/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Entidades.Contato;
import javax.swing.JFrame;

/**
 *
 * @author Alunos
 */
public class Principal {

    public static JFramePrincipal frame;

    public static void main(String[] args) throws Exception {

        frame = new JFramePrincipal();
        frame.setResizable(false);
        frame.setSize(800, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void chamaTelaContatos() {
        JPanelContatos panel;
        try {
            panel = new JPanelContatos();
            frame.setContentPane(panel);
            frame.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static void chamaTelaTipoContatos() {
        JPanelTipoContato panel;
        try {
            panel = new JPanelTipoContato();
            frame.setContentPane(panel);
            frame.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static void chamaTelaFone(Contato contato) {
        JPanelTelefones panel;
        try {
            panel = new JPanelTelefones(contato);
            frame.setContentPane(panel);
            frame.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static void chamaTelaRelatorios() {
        JPanelRelatorio panel;
        try {
            panel = new JPanelRelatorio();
            frame.setContentPane(panel);
            frame.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
