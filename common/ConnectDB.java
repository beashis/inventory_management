package common;

import java.sql.*;


public class ConnectDB {
    /**change as for your system **/
    private static final String password = "Japan@123";
    public Connection conn = null;
    public Statement st = null;
    private static final String CAT_PROCEDURE = "{call insertcategories(?)}";
    private static final String PRODCUT_PROCEDURE = "{call insertproduct(?,?,?,?,?)}";
    private static final String  cutomer_PROCEDURE = "{call insertcustomer(?,?)}";
    private static final String  UPDATE_PROCEDURE = "{call updatequantity(?,?,?)}";
    private static final String  cartInsert_PROCEDURE = "{call insertcart(?,?,?)}";
    public void connectToDB() throws SQLException, ClassNotFoundException {
        String driver="oracle.jdbc.driver.OracleDriver";
        String jdbc_url="jdbc:oracle:thin:@localhost:1521/XE";
        String user="system";
//        String query="CREATE TABLE EMP1(ID INT ,NAME VARCHAR(10))";
        Class.forName(driver);
        conn=DriverManager.getConnection(jdbc_url,user,password);
        st=conn.createStatement();
//        st.executeUpdate(query);
//        System.out.println(conn.toString()+"Created Scuccesfully");

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

    public ResultSet displayCartQuery(int uid) throws SQLException{

        String query = "select products.p_name,products.p_price,cart.quantity,products.p_discount,(cart.quantity*(products.p_price-(products.p_discount*products.p_price)/100)) AS final_price from cart  join products  on cart.p_id=products.p_id where cart.u_id="+uid;
        return st.executeQuery(query);
    }

    public ResultSet emptyCart(int uid) throws SQLException{

        String query = "delete from cart where u_id=" + uid;
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

    public Boolean updateProduct(int productCount , int c_id , int pp_id) throws SQLException {

        CallableStatement statement = null;
        Boolean flag = null;
        try{
            statement = conn.prepareCall(UPDATE_PROCEDURE);
            statement.setInt(1 , c_id);
            statement.setInt(2 , pp_id);
            statement.setInt(3 , productCount);
            flag = statement.execute();
        }catch (Exception e){
            System.out.println(e);
        }finally{
            return flag;
        }
    }

    public boolean updateProductInCart(int uid, int selectProduct, int productCount) throws SQLException{
        CallableStatement statement = null;
        Boolean flag = null;
        try{
            statement = conn.prepareCall(cartInsert_PROCEDURE);
            statement.setInt(1 , uid);
            statement.setInt(2 , selectProduct);
            statement.setInt(3 , productCount);
            flag = statement.execute();
        }catch (Exception e){
            System.out.println(e);
        }finally{
            return flag;
        }
    }

    public ResultSet getAdminData() throws SQLException {
        String query = "select * from i_admin";
        return st.executeQuery(query);
    }
    public ResultSet getCustomerUid(String username) throws SQLException {
        String query = "select USER_ID from customers where USERNAME='"+username + "'";
        return st.executeQuery(query);
    }

    public  boolean insertCustomerDb(String user_name , String user_pass){
        CallableStatement statement = null;
        Boolean flag = null;
        try{
            statement = conn.prepareCall(cutomer_PROCEDURE);
            statement.setString(1 , user_name);
            statement.setString(2 , user_pass);
            flag = statement.execute();
        }catch (Exception e){
            System.out.println(e);
        }finally{
            return flag;
        }
    }

    public ResultSet getCustomerData() throws SQLException {
        String query = "select * from CUSTOMERS";
        return st.executeQuery(query);
    }

    public ResultSet deleteProduct(int p_id) throws SQLException {
        String query = "delete from products where p_id=" + p_id;
        return st.executeQuery(query);
    }

}
