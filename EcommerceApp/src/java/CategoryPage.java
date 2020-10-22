import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CategoryPage extends HttpServlet {
    private Connection con;
    private PreparedStatement ps;
    public void init(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3308/ecomdata","root","root");
        String sql = "select distinct pcat from products order by pcat";
        ps = con.prepareStatement(sql);        
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
        
        int n=0;
        HttpSession session = request.getSession();
        String user=(String)session.getAttribute("user");
        if(user==null)
            response.sendRedirect("index.jsp");
        
        HashSet<String> set = (HashSet<String>) session.getAttribute("cart");
        if(set!=null)
            n=set.size();
        PrintWriter out = response.getWriter();
        try{
            ResultSet rs = ps.executeQuery();
            out.println("<html>");
            out.println("<body>");
            out.println("<h3>Select Desired Category"+user+"</h3>");
            out.println("<hr>");
            while(rs.next()){
                String s = rs.getString(1);
                out.println("<a href=ProductList?ct="+s+">");
                out.println(s);
                out.println("<br>");
                out.println("</a>");
            }
            out.println("<hr>");
            out.println("<h5>Total products:"+n+"</h5>");
            out.println("<a href=BuyerPage.jsp>Back</a>");
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
