package bankMenu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ForAnotherAcc {
    Connection con;
    PreparedStatement st;
    ResultSet rt; 
    int bankid;
    
    public  ForAnotherAcc(Connection c,int bankid)
    {
        con=c;
        this.bankid=bankid;
     }
    
    public boolean checkBankAcc()
    {
        try
        {
            st=con.prepareStatement("select * from persdata where bankid=?");
            st.setInt(1, bankid);
            rt=st.executeQuery();
           if( rt.next())
           {
               return true;
           }
            
        }
        catch(Exception e)
        {
            System.out.println("error:"+e);
        }
        return false;
    }
}
