//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/LanHouse";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";

    public DatabaseConnection() {
    }

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/LanHouse", "postgres", "root");
    }
}

