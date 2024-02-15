package bankMenu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DepWithBal {
    
    Connection con;
    PreparedStatement st;
    ResultSet rt; 
    int bankid;
    float bal,amnt;
    
    public  DepWithBal(Connection c,int bankid)
    {
        con=c;
        this.bankid=bankid;
    }
    public void depo(float amt)
    {
        balance();
        bal=bal+amt;
        editBal();
    
    }
    
    public boolean wit(float amt)
    {
        balance();
        
        if(bal>=amt)
        {
            bal=bal-amt;
            editBal();
            return true;
        }
        return false;
        
    
    }
    
    public float balance()
    {
        try
        {
            st=con.prepareStatement("select * from persdata where bankid=?");
            st.setInt(1, bankid);
            rt=st.executeQuery();
            while(rt.next())
            {
                bal=rt.getFloat("bal");
            }
            return bal;
        }
        catch(Exception e)
        {
            System.out.println("error:"+e);
        }
        return 0f;
    }
    
    public void editBal()
    {
        try
        {
            st=con.prepareStatement("update persdata set bal=? where bankid=?");
            st.setFloat(1, bal);
            st.setInt(2, bankid);
            int i=st.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println("error:"+e);
        }
    }
}
