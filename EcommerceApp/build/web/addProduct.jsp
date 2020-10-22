
<html>
    
    <body>
        <h1>E-Commerce Application</h1>
        <hr>
        <h2>Adding product Form</h2>
        <hr>
        <form action="SaveProduct" method="post">
        <table>
            
            <tr>
                <td>Pcode</td><td><input type="text" name="pcode"/></td>
            </tr>
            <tr>
                <td>Pname</td><td><input type="text" name="pname"</td>
            </tr>
            <tr>
                <td>Pdesc</td><td><input type="text" name="pdesc"/></td>
            </tr>
             <tr>
                         <td>Pcat</td><td><select name="pcat">
                                 <option>computer</option>
                                 <option>books</option>
                                 <option>furniture</option>
                                 <option>electronics</option>
                                 <option>other</option>

                     </select></td>
            </tr>
             <tr>
                <td>Price</td><td><input type="text" name="price"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Save"</td><td><input type="reset" value="Reset"</td>
            </tr>
        </table>  
       </form>
        <hr>
        <a href="index.jsp">Home</a><br>
        
    </body>
</html>
