
package mypkg;
import java.sql.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class priceHandler extends SimpleTagSupport {

    
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/ecomdata","root","root");
            String sql ="select pname,price from products";
            PreparedStatement ps = con.prepareStatement(sql);
           ResultSet rs = ps.executeQuery(sql);
           while(rs.next()){
            String s1=rs.getString(1);
            String s2=rs.getString(2);
            out.println(s1+"<==>"+s2+"<br>");
           }
           con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
