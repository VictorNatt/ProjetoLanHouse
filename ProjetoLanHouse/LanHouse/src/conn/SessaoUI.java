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
import javax.swing.JTextField;

public class SessaoUI extends JFrame {
    private JTextField txtIdM;
    private JTextField txtEmail;
    private JTextField txtData;
    private JTextField txtTempoInicial;
    private JTextField txtTempoFinal;
    private JButton btnRegistrar;

    public SessaoUI() {
        this.setTitle("Registro de Sessão");
        this.setSize(400, 350);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo((Component)null);
        this.setLayout(new GridLayout(6, 2, 10, 10));
        this.add(new JLabel("ID da Máquina:"));
        this.txtIdM = new JTextField();
        this.add(this.txtIdM);
        this.add(new JLabel("Email:"));
        this.txtEmail = new JTextField();
        this.add(this.txtEmail);
        this.add(new JLabel("Data (YYYY-MM-DD):"));
        this.txtData = new JTextField();
        this.add(this.txtData);
        this.add(new JLabel("Tempo Inicial (HH:MM):"));
        this.txtTempoInicial = new JTextField();
        this.add(this.txtTempoInicial);
        this.add(new JLabel("Tempo Final (HH:MM):"));
        this.txtTempoFinal = new JTextField();
        this.add(this.txtTempoFinal);
        this.btnRegistrar = new JButton("Registrar Sessão");
        this.add(this.btnRegistrar);
        this.add(new JLabel(""));
        this.btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
					SessaoUI.this.registrarSessao();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        this.setVisible(true);
    }

    private void registrarSessao() throws Throwable {
        try {
            int idM = Integer.parseInt(this.txtIdM.getText().trim());
            String email = this.txtEmail.getText().trim();
            String dataD = this.txtData.getText().trim();
            String tempoInicial = this.txtTempoInicial.getText().trim();
            String tempoFinal = this.txtTempoFinal.getText().trim();
            if (!this.isEmailValid(email)) {
                JOptionPane.showMessageDialog(this, "Email inválido! Insira um email no formato correto.", "Erro", 0);
                return;
            }

            Sessao sessao = new Sessao();
            if (!this.idMaquinaExiste(idM)) {
                JOptionPane.showMessageDialog(this, "ID da Máquina não encontrado. Por favor, insira um ID válido.", "Erro", 0);
                return;
            }

            if (!this.emailExiste(email)) {
                JOptionPane.showMessageDialog(this, "Email não encontrado. Por favor, use um email existente.", "Erro", 0);
                return;
            }

            if (this.conflitoDeHorario(dataD, tempoInicial, tempoFinal)) {
                JOptionPane.showMessageDialog(this, "Já existe uma sessão registrada com os mesmos horários para essa data.", "Erro", 0);
                return;
            }

            boolean sucesso = sessao.registerSessao(idM, email, dataD, tempoInicial, tempoFinal);
            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Sessão registrada com sucesso!");
                this.limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Falha ao registrar a sessão. Tente novamente.", "Erro", 0);
            }
        } catch (NumberFormatException var8) {
            JOptionPane.showMessageDialog(this, "ID da Máquina deve ser um número.", "Erro", 0);
        }

    }

    private boolean isEmailValid(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailRegex, email);
    }

    private boolean emailExiste(String email) {
        return true;
    }

    private boolean idMaquinaExiste(int idM) {
        return idM == 1 || idM == 2;
    }

    private boolean conflitoDeHorario(String dataD, String tempoInicial, String tempoFinal) {
        return false;
    }

    private void limparCampos() {
        this.txtIdM.setText("");
        this.txtEmail.setText("");
        this.txtData.setText("");
        this.txtTempoInicial.setText("");
        this.txtTempoFinal.setText("");
    }

    public static void main(String[] args) {
        new SessaoUI();
    }
}
