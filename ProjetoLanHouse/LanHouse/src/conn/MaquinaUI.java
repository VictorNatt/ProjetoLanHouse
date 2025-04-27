//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package conn;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MaquinaUI extends JFrame {
    private Maquina maquina = new Maquina();

    public MaquinaUI() {
        this.inicializarComponentes();
    }

    private void inicializarComponentes() {
        this.setTitle("Cadastro de Máquina");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(3);
        this.setLayout(new GridLayout(3, 2));
        JLabel lblIdM = new JLabel("ID da Máquina:");
        JTextField txtIdM = new JTextField();
        JLabel lblDisponibilidade = new JLabel("Disponibilidade:");
        JTextField txtDisponibilidade = new JTextField();
        JButton btnRegistrar = new JButton("Registrar Máquina");
        this.add(lblIdM);
        this.add(txtIdM);
        this.add(lblDisponibilidade);
        this.add(txtDisponibilidade);
        this.add(new JLabel());
        this.add(btnRegistrar);
        btnRegistrar.addActionListener((e) -> {
            try {
                int idM = Integer.parseInt(txtIdM.getText().trim());
                String disponibilidade = txtDisponibilidade.getText();
                if (disponibilidade.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro", 0);
                    return;
                }

                boolean sucesso = this.maquina.registerMaquina(idM, disponibilidade);
                if (sucesso) {
                    JOptionPane.showMessageDialog(this, "Máquina registrada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Falha ao registrar a máquina.", "Erro", 0);
                }
            } catch (NumberFormatException var7) {
                JOptionPane.showMessageDialog(this, "O ID da Máquina deve ser um número inteiro.", "Erro", 0);
            } catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

        });
    }

    public static void main(String[] args) {
        String senha = JOptionPane.showInputDialog((Component)null, "Digite a senha para acessar o sistema:", "Login", -1);
        if ("admin".equals(senha)) {
            SwingUtilities.invokeLater(() -> {
                MaquinaUI janela = new MaquinaUI();
                janela.setVisible(true);
            });
        } else {
            JOptionPane.showMessageDialog((Component)null, "Senha incorreta. Programa será encerrado.", "Erro", 0);
            System.exit(0);
        }

    }
}
