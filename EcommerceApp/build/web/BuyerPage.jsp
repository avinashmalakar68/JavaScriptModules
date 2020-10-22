<%
    String user =(String)session.getAttribute("user");
       if(user==null)
           response.sendRedirect("index.jsp");
%>
<html>
    
    <body>
        <h1>Buyer page</h1>
        <h3>Welcome-<%=user%></h3>
        <hr>
        <pre>
        <a href="CategoryPage">Explore-Store</a>
        <a href="shopping.jsp">View-Products</a>
        <a href="searchProduct.jsp">Search-Product</a>
        <a href="priceList.jsp">See Price List</a>
        <a href="DisplayCart">view cart</a>
        <hr>
        </pre>
        <a href="EndSession">Logout</a>
    </body>
</html>
