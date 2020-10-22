
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AVI
 */
public class SaveUserData extends HttpServlet {
      private Connection con;
      private PreparedStatement ps;
      //private String sql;
    
    public void init(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3308/ecomdata","root","root");
        String sql = "insert into users values(?,?,?,?,?)";
        ps = con.prepareStatement(sql);
    }catch(Exception e){
        e.printStackTrace();
        
    }}
    public void destroy(){
        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out= response.getWriter();
            
            String s1 = request.getParameter("email");
            String s2 = request.getParameter("password");
            String s3 = request.getParameter("name");
            String s4 = request.getParameter("address");
            String s5 = request.getParameter("mobile");
            
            try{
               
                ps.setString(1,s1);
                ps.setString(2,s2);
                ps.setString(3,s3);       
                ps.setString(4,s4);
                ps.setString(5,s5);
                ps.executeUpdate();
                
                out.println("Regustration is completed");
                //System.out.println(s1);
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
