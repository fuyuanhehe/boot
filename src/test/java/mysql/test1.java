package mysql;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.*;

public class test1 {

    @Autowired
    private DataSource dataSource;


    public static void main(String[] args) {

        MysqlDataSource ds;
        Connection conn2;
        // create connection with a datasource object
        ds = new MysqlDataSource();
        ds.setServerName("localhost");
        ds.setDatabaseName("test");
        ds.setPort(3306);
        ds.setURL("jdbc:mysql://localhost:3306/test?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT");
        try {
            conn2 = ds.getConnection("root", "123456");

            Statement statement = conn2.createStatement();
            String sql = "select * from user";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Date name = rs.getDate("c");
                System.out.println(name);
            }
            rs.close();

       /*     System.out.print(LocalDate.now());
            System.out.print(LocalTime.now());
            System.out.print(LocalDateTime.now());
            PreparedStatement st = conn2.prepareStatement("insert into user (c)values(?)");
            st.setObject(1,LocalDateTime.now());*/

         //   st.setObject(3, LocalTime.now());
        //    st.setObject(4, LocalDateTime.now());

          //  st.execute();
         //   st.close();
           conn2.close();




        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
}
