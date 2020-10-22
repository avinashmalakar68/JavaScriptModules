<%@taglib uri="/WEB-INF/tlds/mylib.tld" prefix="sample"%>

<sample:info/>



<%
    String v1="",v2="";
    
    Cookie ck[]=request.getCookies();
    
    if(ck!=null){
        for(int i=0; i<ck.length;i++){
            String name=ck[i].getName();
            if(name.equals("id")){
                v1=ck[i].getValue();
            }else if(name.equals("pw")){
                v2=ck[i].getValue();
            }
        }
                
    }
   
%>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="text.css">
    </head>
    <body>
        <h3>E-Commerce Application</h3>
        <hr>
        <div class="form-container">
        <form action="VerifyUser" method="post">
            <table class="form-table">
            
            <tr>
                <td><input type="text" name="email" value="<%=v1%>"/></td>
            </tr>
            <tr>
                <td><input type="password" name="password" value="<%=v2%>"</td>
            </tr>
            <tr>
                <td>UserType</td><td><select name="utype"><option>admin</option><option>buyer</option></select></td>
            </tr>
            <tr>
                <td>Save Password</td><td><input type="checkbox" name="c1" value="yes" checked="checked"</td>
            </tr>
            <tr>
                <td><input type="submit" value="Login"</td><td><input type="reset" value="Reset"</td>
            </tr>
            
        </table>  
       </form>
             <a href="Registration.jsp">New-User</a>
       </div>

        <hr>
       
    </body>
</html>
