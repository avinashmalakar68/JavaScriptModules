<%@page  errorPage="myerrors.jsp" %>

<%!
     int getDiscount(int price){
     int discount =0;
        if(price>=1000)
            discount=price*20/100;
        else
            discount=price*10/100;
        return discount;
     }
    
    


%>
<%
    int code = Integer.parseInt(request.getParameter("t1"));
    Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3308/ecomdata","root","root");
    String sql = "select * from products where pcode=?";
    java.sql.PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1,code);
    java.sql.ResultSet rs = ps.executeQuery();
    rs.next();
    String s1 = rs.getString(1);
    String s2 = rs.getString(2);
    String s3 = rs.getString(3);
    String s4 = rs.getString(4);
    String s5 = rs.getString(5);
    con.close();
    
%>
<html>
    
    <body>
        <h3>Product details</h3>
        <hr>
        <pre>
        Code    <% out.println(s1);%>  
        Name    <% out.println(s2);%>  
        Desc    <% out.println(s3);%>  
        Cate    <% out.println(s4);%>
        Price   <% out.println(s5);%>
        Discount<%=getDiscount(Integer.parseInt(s5))%>
        </pre>
        <hr>
        <a href="searchProduct">Back</a>
    </body>
</html>
