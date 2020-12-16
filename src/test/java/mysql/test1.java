package mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test1 {

    @Autowired
    private DataSource dataSource;

    @RequestMapping(value = "test")
    public void test() throws SQLException {

        Connection con = dataSource.getConnection();
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from system_user ");
        while (rs.next()) {
            String name = rs.getString("username");
            System.out.println(name);
        }

    }

    public static void main(String[] args) {
        com.mysql.jdbc.jdbc2.optional.MysqlDataSource ds;
        Connection conn2;
        // create connection with a datasource object
        ds = new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
        ds.setServerName("localhost");
        ds.setDatabaseName("test");
        ds.setPort(3306);
        // ds.setURL("jdbc:mysql://localhost:3306/bestree");
        try {
            conn2 = ds.getConnection("root", "123456");
            if (!conn2.isClosed()) {
                System.out.println("Succeeded connecting to the Database!");
            }
            Statement statement = conn2.createStatement();
            String sql = "select * from sys_user";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("username");
                System.out.println(name);
            }
            rs.close();
            conn2.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
