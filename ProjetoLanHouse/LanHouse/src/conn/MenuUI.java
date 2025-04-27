//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package conn;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuUI extends JFrame {
    public MenuUI() {
        this.setTitle("Menu Principal");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo((Component)null);
        this.setLayout(new GridLayout(4, 1, 10, 10));
        JLabel lblTitulo = new JLabel("Bem-vindo ao Sistema de Gerenciamento", 0);
        lblTitulo.setFont(new Font("Arial", 1, 16));
        this.add(lblTitulo);
        JButton btnCadastro = new JButton("Cadastro de Usuários");
        btnCadastro.addActionListener((e) -> new CadastroUI());
        this.add(btnCadastro);
        JButton btnSessao = new JButton("Gerenciamento de Sessões");
        btnSessao.addActionListener((e) -> new SessaoUI());
        this.add(btnSessao);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MenuUI();
    }
}
