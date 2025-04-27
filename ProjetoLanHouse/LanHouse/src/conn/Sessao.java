//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Sessao {
    private Connection connection;

    public Sessao() {
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

    public boolean registerSessao(int idM, String email, String dataD, String tempoInicial, String tempoFinal) throws Throwable {
        String sql = "INSERT INTO TSessao (idm, email, datad, tempoinicial, tempofinal) VALUES (?, ?, ?, ?, ?)";

        try {
            Throwable e = null;
            Object var8 = null;

            try {
                PreparedStatement stmt = this.connection.prepareStatement(sql);

                boolean var10000;
                try {
                    stmt.setInt(1, idM);
                    stmt.setString(2, email);
                    stmt.setString(3, dataD);
                    stmt.setString(4, tempoInicial);
                    stmt.setString(5, tempoFinal);
                    int rowsAffected = stmt.executeUpdate();
                    var10000 = rowsAffected > 0;
                } finally {
                    if (stmt != null) {
                        stmt.close();
                    }

                }

                return var10000;
            } catch (Throwable var18) {
                if (e == null) {
                    e = var18;
                } else if (e != var18) {
                    e.addSuppressed(var18);
                }

                throw e;
            }
        } catch (SQLException e) {
            if ("23505".equals(e.getSQLState())) {
                System.out.println("Erro: Alguem essa maquina já está ocupada ou não existe");
            } else {
                System.out.println("Erro ao registrar Sessao: " + e.getMessage());
            }

            return false;
        }
    }
}
