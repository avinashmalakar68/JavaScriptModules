
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductDetails extends HttpServlet {
    private Connection con;
    private PreparedStatement ps;
    
    public void init(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3308/ecomdata","root","root");
        String sql ="select * from products where pcode=?";
        ps=con.prepareStatement(sql);
        }catch(Exception e){
        e.printStackTrace();
        }     
    }
    public void destroy(){
        try{
        con.close();
        }catch(Exception e)
        {
        e.printStackTrace();
        }    
    }

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String s = request.getParameter("code");
        try{
            ps.setInt(1,Integer.parseInt(s));
            ResultSet rs= ps.executeQuery();
            rs.next();
            String s1 = rs.getString(1);
            String s2 = rs.getString(2);
            String s3 = rs.getString(3);
            String s4 = rs.getString(4);
            String s5 = rs.getString(5);
            
            out.println("<html>");
            out.println("<body>");
            out.println("<h3> Product-Details</h3>");
            out.println("<hr>");
            out.println("<table border=2>");
            out.println("<tr>");
            out.println("<td>code</td>");
            out.println("<td>"+s1+"</td></tr>");
            out.println("<tr>");
            out.println("<td>name</td>");
            out.println("<td>"+s2+"</td></tr>");
            out.println("<tr>");
            out.println("<td>desc</td>");
            out.println("<td>"+s3+"</td></tr>");
            out.println("<tr>");
            out.println("<td>cat</td>");
            out.println("<td>"+s4+"</td></tr>");
            out.println("<tr>");
            out.println("<td>Price</td>");
            out.println("<td>"+s5+"</td></tr>");
            out.println("</table>");
            out.println("<hr>");
            out.println("<a href=CartManager?code="+s+">Add-to-Cart</a><br>");
            out.println("<a href=CategoryPage>Category</a><br>");
            out.println("<a href=BuyerPage.jsp>Buyer-home</a>");
            out.println("</body>");
            out.println("</html>");
            }catch(Exception e){
            out.println(e);
            }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
