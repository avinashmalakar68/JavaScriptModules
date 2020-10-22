import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VerifyUser extends HttpServlet {
       private Connection con;
       private PreparedStatement ps;
        public void init(){
            try{
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3308/ecomdata","root","root");
                    String sql = "select * from users where email=? and password=?";
                    ps = con.prepareStatement(sql);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        public void destroy(){
            try{
                con.close();
            }catch(Exception e){
               e.printStackTrace();
            }
        }
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out =  response.getWriter();
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String utype = request.getParameter("utype");
             
            if(utype.equals("admin")){
                if(email.equals("admin@gmail.com") && password.equals("indore")){
                    response.sendRedirect("AdminPage.jsp");
                }else{
                    out.println("invalid credentials");
                }
            
            }else if(utype.equals("buyer")){
                try{
                    ps.setString(1,email);
                    ps.setString(2,password);
                    ResultSet rs = ps.executeQuery();
                    boolean b = rs.next();
                    if(b==true){
                        //getting session object for the user
                        HttpSession session = request.getSession();
                        session.setAttribute("user",email);
                        
                        
                        String ch=request.getParameter("c1");
                        if(ch!=null){
                        Cookie c1 = new Cookie("id",email);
                        Cookie c2 = new Cookie("pw",password);
                        c1.setMaxAge(60*60*24*7);
                        c2.setMaxAge(60*60*24*7);
                        
                        response.addCookie(c1);
                        response.addCookie(c2);
                    }
                        response.sendRedirect("BuyerPage.jsp");
                    }else{
                         out.println("invalid buyer credentials");   
                    }
                }catch(Exception e){
                out.println(e);
                } 
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

