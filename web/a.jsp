<%-- 
    Document   : a
    Created on : Jun 21, 2018, 1:03:32 AM
    Author     : DEll
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            #b{
                display: none;
            }
        </style>
    </head>
    <body>
        <input type="submit"  value="Buy" onclick="myFunction()"/>
                <Input type="text" class="buy" name="qty" size="2px"/>
                 <input type="submit"  value="Buy More"/>
<!--                <script>
function myFunction() {
    document.getElementById('buyIiii').value="1";
}
</script>
                -->
                
                
                <script>
                    function myFunction() {
                        var x=document.getElementByClassName("buy");
                        x.value="1";
                    }
                </script>


    </body>
</html>
