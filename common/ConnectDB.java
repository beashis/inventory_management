package common;

import java.sql.*;


public class ConnectDB {
    /**change as for your system **/
    private static final String password = "Japan@123";
    static public Connection conn = null;
    static public Statement st = null;
    void connectToDB() throws SQLException, ClassNotFoundException {
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

    public static ResultSet queryExecute(String query) throws SQLException {
        ResultSet rs = st.executeQuery(query);
        st.close();
        return rs;
    }

}