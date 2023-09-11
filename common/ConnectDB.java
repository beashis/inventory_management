package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class ConnectDB {
    /**change as for your system **/
    private static final String password = "Japan@123";
    public Connection conn = null;
    public Statement st = null;
    public void connectToDB() throws SQLException, ClassNotFoundException {
        String driver="oracle.jdbc.OracleDriver";
        String jdbc_url="jdbc:oracle:thin:@localhost:1521/XE";
        String user="system";
//        String query="CREATE TABLE EMP1(ID INT ,NAME VARCHAR(10))";
        Class.forName(driver);
        conn=DriverManager.getConnection(jdbc_url,user,password);
        st=conn.createStatement();
//        st.executeUpdate(query);
        System.out.println(st+"Created Scuccesfully");

    }

    public void queryExecute(String query) throws SQLException {
        st.executeUpdate(query);
        st.close();
    }


}
