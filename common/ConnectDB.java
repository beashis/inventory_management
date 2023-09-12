package common;

import java.sql.*;


public class ConnectDB {
    /**change as for your system **/
    private static final String password = "Japan@123";
    public Connection conn = null;
    public Statement st = null;
    private static final String CAT_PROCEDURE = "{call insertcategories(?)}";
    private static final String PRODCUT_PROCEDURE = "{call insertproduct(?,?,?,?,?)}";
    public void connectToDB() throws SQLException, ClassNotFoundException {
        String driver="oracle.jdbc.driver.OracleDriver";
        String jdbc_url="jdbc:oracle:thin:@localhost:1521/XE";
        String user="system";
//        String query="CREATE TABLE EMP1(ID INT ,NAME VARCHAR(10))";
        Class.forName(driver);
        conn=DriverManager.getConnection(jdbc_url,user,password);
        st=conn.createStatement();
//        st.executeUpdate(query);
        System.out.println(conn.toString()+"Created Scuccesfully");

    }
    public void closedB() throws SQLException {
        st.close();
    }

    public static ResultSet queryExecute(String query) throws SQLException {
//        ResultSet rs = st.executeQuery(query);
//        st.close();
//        return rs;
        return  null;
    }


    public ResultSet getProductTable(int c_id) throws SQLException {
        String query = "select * from products where c_id="+c_id;
        return st.executeQuery(query);
    }


    public ResultSet getCategory(Statement st) throws SQLException{

        String query = "select * from categories";
        return st.executeQuery(query);

    }

    public boolean insertCategory(String category) throws SQLException{
        CallableStatement statement = null;
        Boolean flag = null;
        try{
            statement = conn.prepareCall(CAT_PROCEDURE);
            statement.setString(1 , category);
            flag = statement.execute();
        }catch (Exception e){
            System.out.println(e);
        }finally{
            return flag;
        }
    }

    public boolean insertNewProduct(String productName , int c_id , int quantity , int price , int discount) throws SQLException{
        CallableStatement statement = null;
        Boolean flag = null;
        try{
            statement = conn.prepareCall(PRODCUT_PROCEDURE);
            statement.setInt(1 , c_id);
            statement.setString(2 , productName);
            statement.setInt(3 , quantity);
            statement.setInt(4 , price);
            statement.setInt(5 , discount);
            flag = statement.execute();
        }catch (Exception e){
            System.out.println(e);
        }finally{
            return flag;
        }
    }

    public ResultSet updateProduct(int productCount , int c_id , int p_id) throws SQLException {

        String query = "update products set p_quantity =p_quantity + "+productCount+" where c_id ="+c_id+" AND p_id ="+p_id;
        return st.executeQuery(query);
    }

    public ResultSet updateProductInCart(int uid, int selectProduct) throws SQLException{
        CallableStatement statement = conn.prepareCall("{updateProduct()}");
        return statement.executeQuery();
    }
}
