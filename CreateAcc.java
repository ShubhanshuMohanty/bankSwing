
package bankMenu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CreateAcc {
    
    Connection con;
    PreparedStatement st;
    ResultSet rt; 
    String name, age, phono, gender, email;
    int i;
    
    public CreateAcc(Connection c,String name,String age,String phono,String gender,String email){
        con=c;
        this.name=name;
        this.age=age;
        this.phono=phono;
        this.gender=gender;
        this.email=email;
    }
    public boolean createBA()
    {
        try
        {
            st=con.prepareStatement("insert into userbankdata(name,age,phono,gender,email) values(?,?,?,?,?)");
            st.setString(1, name);
            st.setString(2, age);
            st.setString(3, phono);
            st.setString(4, gender);
            st.setString(5, email);
            i=st.executeUpdate();
            if(i>0)
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
    
    public String getBankId()
    {
        try
        {
            st=con.prepareStatement("select * from userbankdata where name=?");
            st.setString(1, name);
            rt=st.executeQuery();
            while(rt.next())
            {
                return rt.getString("bankid");
            }
        }
        catch(Exception e)
        {
            System.out.println("error:"+e);
        }
        return null;
    }
    
    public void createPersdata(int bid)
    {
        try
        {
            st=con.prepareStatement("insert into persdata(bankid,bal) values(?,?)");
            st.setInt(1, bid);
            st.setFloat(2, 0f);
            i=st.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println("error:"+e);
        }
    }
    
    //public void
}
