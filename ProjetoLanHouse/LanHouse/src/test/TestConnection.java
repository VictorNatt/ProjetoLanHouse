
package test;

import conn.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public TestConnection() {
    }

    public static void main(String[] args) throws Throwable {
        try {
            Throwable e = null;
            Object var2 = null;

            try {
                Connection connection = DatabaseConnection.connect();

                try {
                    if (connection != null) {
                        System.out.println("Conexão estabelecida com sucesso!");
                    }
                } finally {
                    if (connection != null) {
                        connection.close();
                    }

                }
            } catch (Throwable var11) {
                if (e == null) {
                    e = var11;
                } else if (e != var11) {
                    e.addSuppressed(var11);
                }

                throw e;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }

    }
}
