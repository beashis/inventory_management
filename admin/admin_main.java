package admin;

public class admin_main {
    public void createProduct(int id, String name, int count)
    {
        String query="insert into inventory(id,name,count) values ("+id+","+name+","+count+")";
    }
    public void  addProduct(int id,int amount)
    {
        String query = "update inventory set count="+amount+"where id ="+id;
    }
    public void deleteProduct(int id,String name)
    {
        String query ="delete from inventory where id="+id;
    }
}
