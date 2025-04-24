//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Maquina {
    private Connection connection;

    public Maquina() {
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

    public boolean registerMaquina(int idM, String Disponibilidade) throws Throwable {
        String sql = "INSERT INTO TMaquina (idM, Disponibilidade) VALUES (?, ?)";

        try {
            Throwable e = null;
            Object var5 = null;

            try {
                PreparedStatement stmt = this.connection.prepareStatement(sql);

                boolean var10000;
                try {
                    stmt.setInt(1, idM);
                    stmt.setString(2, Disponibilidade);
                    int rowsAffected = stmt.executeUpdate();
                    var10000 = rowsAffected > 0;
                } finally {
                    if (stmt != null) {
                        stmt.close();
                    }

                }

                return var10000;
            } catch (Throwable var15) {
                if (e == null) {
                    e = var15;
                } else if (e != var15) {
                    e.addSuppressed(var15);
                }

                throw e;
            }
        } catch (SQLException e) {
            if ("23505".equals(e.getSQLState())) {
                System.out.println("Erro: Essa maquina ja foi criada");
            } else {
                System.out.println("Erro ao registrar a maquina: " + e.getMessage());
            }

            return false;
        }
    }
}
