import com.example.firsttomcat.dao.Connection.Pool.Neo4jConnectionManager;
import com.example.firsttomcat.dao.Connection.Neo4jService;
import org.junit.jupiter.api.Test;

public class TestDb {

    @Test
    public void test() {
        Neo4jConnectionManager connectionManager = new Neo4jConnectionManager("neo4j+s://2f26ebae.databases.neo4j.io",
                "neo4j", "ipy6ASS3ezx6UmAsYGYEnJH8rJM5o8CuGZ5-ct4RaL8");
        Neo4jService service = new Neo4jService(connectionManager.getDriver());
        connectionManager.connect();
        System.out.println("подключение к дб прошло успешно");
    }
}



