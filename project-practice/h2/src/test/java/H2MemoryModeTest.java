import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by C0907 on 2017/8/23.
 *
 * 该case，需要在本地启动h2服务器
 */
public class H2MemoryModeTest {


    public static void main(String[] a)
            throws Exception {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.
                getConnection("jdbc:h2:tcp://localhost/mem:test2", "sa", "");
        // add application code here
        Statement stmt = conn.createStatement();

        stmt.executeUpdate("CREATE TABLE TEST_MEM(ID INT PRIMARY KEY,NAME VARCHAR(255));");
        stmt.executeUpdate("INSERT INTO TEST_MEM VALUES(1, 'Hello_Mem');");
        ResultSet rs = stmt.executeQuery("SELECT * FROM TEST_MEM");
        while(rs.next()) {
            System.out.println(rs.getInt("ID")+","+rs.getString("NAME"));
        }
        conn.close();
    }

}
