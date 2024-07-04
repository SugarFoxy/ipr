package perf.ipr.db;

import lombok.extern.slf4j.Slf4j;
import org.postgresql.ds.PGSimpleDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
public class DataBaseQueries {

    private final Statement stmt;

    public DataBaseQueries(PropertiesConfiguration configuration) throws SQLException {
        String[] servers = {configuration.getDbHost()};
        int[] ports = {Integer.parseInt(configuration.getDbPort())};
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setServerNames(servers);
        dataSource.setPortNumbers(ports);
        dataSource.setDatabaseName(configuration.getDbName());
        dataSource.setUser(configuration.getDbUser());
        dataSource.setPassword(configuration.getDbPassword());
        this.stmt = dataSource.getConnection().createStatement();
    }

    public void fillUserData() throws SQLException {
        for (int i = 0; i < 10; i++) {
            stmt.executeUpdate("INSERT INTO users (id,name, email) values('" + i + "','TestUser" + i + "', 'email" + i + "@mail.ru')");
        }
    }

    public void fillItemData() throws SQLException {
        for (int i = 0; i < 10; i++) {
            boolean available = i % 2 == 0;
            stmt.executeUpdate("INSERT INTO items (id,name, description, available, owner_id) " +
                    "values('" + i + "','ItemName" + i + "', 'description" + i + "', '" + available + "', '" + i + "')");
        }
    }

    public void createDuplicateName() throws SQLException {
        for (int i = 0; i < 10; i++) {
            stmt.executeUpdate("INSERT INTO users (id,name, email) " +
                    "values('" + (i + 10) + "','TestUser" + i + "', 'email" + (i + 10) + "@mail.ru')");
        }
    }

    public void dropTable() throws SQLException {
        stmt.executeUpdate("DELETE FROM users");
        stmt.executeUpdate("DELETE FROM items");
    }

    public ResultSet selectDataLike() throws SQLException {
        return stmt.executeQuery("SELECT name FROM users WHERE email LIKE '%8%'");
    }

    public ResultSet selectDataGroupBy() throws SQLException {
        return stmt.executeQuery("SELECT name FROM users GROUP BY name");
    }

    public ResultSet selectDataJoin() throws SQLException {
        return stmt.executeQuery(
                "SELECT u.name as user_name, i.name as item_name FROM users as u " +
                "JOIN items as i on i.owner_id = u.id " +
                "WHERE available = 'true'");
    }
}
