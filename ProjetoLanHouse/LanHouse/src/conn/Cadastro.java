
package conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cadastro {
    private Connection connection;

    public Cadastro() {
        try {
            this.connection = DatabaseConnection.connect();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }

    }

    public Connection getConnection() {
        return this.connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean registerCliente(String nome, String email, String senha) throws Throwable {
        String sql = "INSERT INTO TCliente (nome, email, senha) VALUES (?, ?, ?)";

        try {
            Throwable e = null;
            Object var6 = null;

            try {
                PreparedStatement stmt = this.connection.prepareStatement(sql);

                boolean var10000;
                try {
                    stmt.setString(1, nome);
                    stmt.setString(2, email);
                    stmt.setString(3, senha);
                    int rowsAffected = stmt.executeUpdate();
                    var10000 = rowsAffected > 0;
                } finally {
                    if (stmt != null) {
                        stmt.close();
                    }

                }

                return var10000;
            } catch (Throwable var16) {
                if (e == null) {
                    e = var16;
                } else if (e != var16) {
                    e.addSuppressed(var16);
                }

                throw e;
            }
        } catch (SQLException e) {
            if ("23505".equals(e.getSQLState())) {
                System.out.println("Erro: Já existe uma conta com esse nome ou e-mail!");
            } else {
                System.out.println("Erro ao registrar usuário: " + e.getMessage());
            }

            return false;
        }
    }
}
