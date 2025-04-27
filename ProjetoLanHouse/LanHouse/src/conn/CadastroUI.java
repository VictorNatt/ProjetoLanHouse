//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package conn;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CadastroUI extends JFrame {
    private JTextField txtNome;
    private JTextField txtEmail;
    private JPasswordField txtSenha;
    private JButton btnRegistrar;

    public CadastroUI() {
        this.setTitle("Cadastro de Usuário");
        this.setSize(400, 250);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo((Component)null);
        this.setLayout(new GridLayout(4, 2, 10, 10));
        this.add(new JLabel("Nome:"));
        this.txtNome = new JTextField();
        this.add(this.txtNome);
        this.add(new JLabel("Email:"));
        this.txtEmail = new JTextField();
        this.add(this.txtEmail);
        this.add(new JLabel("Senha:"));
        this.txtSenha = new JPasswordField();
        this.add(this.txtSenha);
        this.btnRegistrar = new JButton("Registrar Usuário");
        this.add(this.btnRegistrar);
        this.add(new JLabel(""));
        this.btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
					CadastroUI.this.registrarUsuario();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        this.setVisible(true);
    }

    private void registrarUsuario() throws Throwable {
        String nome = this.txtNome.getText().trim();
        String email = this.txtEmail.getText().trim();
        String senha = (new String(this.txtSenha.getPassword())).trim();
        if (!nome.isEmpty() && !email.isEmpty() && !senha.isEmpty()) {
            if (!this.isValidEmail(email)) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um e-mail no formato correto.", "Erro", 0);
            } else {
                Cadastro cadastro = new Cadastro();
                boolean sucesso = cadastro.registerCliente(nome, email, senha);
                if (sucesso) {
                    JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
                    this.txtNome.setText("");
                    this.txtEmail.setText("");
                    this.txtSenha.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Falha ao cadastrar o usuário. Verifique se a conta já existe ou tente novamente.", "Erro", 0);
                }

            }
        } else {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.", "Erro", 0);
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(emailRegex, email);
    }

    public static void main(String[] args) {
        new CadastroUI();
    }
}
