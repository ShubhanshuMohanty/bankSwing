package bankMenu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDB {
    Connection con;
    PreparedStatement st;
    ResultSet rt; 
    String bid,apass;
    
    public LoginDB(Connection c,String id,String pass)
    {
        con=c;
        bid=id;
        apass=pass;
        
    }
    public boolean checkLogin()
    {
        try
        {
            st=con.prepareStatement("select * from userbankdata where bankid=? and password=? ");
            st.setString(1,bid);
            st.setString(2, apass);
            rt=st.executeQuery();
            if(rt.next())
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            System.out.println("error:"+e);
            return false;
        }
    }
}
