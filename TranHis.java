package bankMenu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TranHis {
    Connection con;
    PreparedStatement st;
    ResultSet rt; 
    int bankid,abankid;
    float money;
    String mode;
    
    public  TranHis(Connection c,int bankid,int abankid,String mode,Float money)
    {
        con=c;
        this.bankid=bankid;
        this.abankid=abankid;
        this.mode=mode;
        this.money=money;
        
        
     }
    public void insert()
    {
        try
        {
            st=con.prepareStatement("insert into transactionTable(bankid,abankid,bal,mode) values(?,?,?,?)");
            st.setInt(1, bankid);
            st.setInt(2, abankid);
            st.setFloat(3, money);
            st.setString(4, mode);
            int i=st.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println("error:"+e);
        }
    }
}
