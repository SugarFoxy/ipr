package perf.ipr.db;

import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.postgresql.util.PSQLException;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

//Создала чисто для того чтобы показать что с бд могу и так работать.
@SpringBootTest
public class DbTest {
    private static DataBaseQueries dataBaseQueries;

    @BeforeEach
    public void fillData() throws SQLException {
        dataBaseQueries = new DataBaseQueries();
        dataBaseQueries.fillUserData();
        dataBaseQueries.fillItemData();
        dataBaseQueries.createDuplicateName();
    }

    @Test
    @Description("Проверка GROUP BY")
    public void dbGroupByTest() throws SQLException {
        ResultSet groupBy = dataBaseQueries.selectDataGroupBy();
        List<String> expect =List.of(
                "TestUser0",
                "TestUser1",
                "TestUser2",
                "TestUser3",
                "TestUser4",
                "TestUser5",
                "TestUser6",
                "TestUser7",
                "TestUser8",
                "TestUser9");
        List<String> results = getResults(groupBy);
        assertTrue(results.containsAll(expect) && expect.containsAll(results));
    }

    @Test
    @Description("Проверка LIKE")
    public void dbLikeTest() throws SQLException {
        ResultSet like = dataBaseQueries.selectDataLike();
        List<String> expect =List.of("TestUser8", "TestUser8");
        List<String> results = getResults(like);
        assertTrue(results.containsAll(expect) && expect.containsAll(results));
    }

    @Test
    @Description("Проверка JOIN")
    public void dbJoinTest() throws SQLException {
        ResultSet join = dataBaseQueries.selectDataJoin();
        List<String> expect = List.of("TestUser0 | ItemName0",
                "TestUser2 | ItemName2",
                "TestUser4 | ItemName4",
                "TestUser6 | ItemName6",
                "TestUser8 | ItemName8");
        List<String> results = getResults(join);
        assertTrue(results.containsAll(expect) && expect.containsAll(results));
    }

    @AfterEach
    public void close() throws SQLException {
        dataBaseQueries.dropTable();
    }

    private List<String> getResults(ResultSet rs) throws SQLException {
        List<String> results = new ArrayList<>();
        while (rs.next()) {
            String column2;
            try {
                rs.getString(2);
                column2 = " | " + rs.getString(2);
            } catch (PSQLException e) {
                column2 = "";
            }
            results.add(rs.getString(1) + column2);
        }
        return results;
    }
}
