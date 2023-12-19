<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Text Encryption & Decryption</title>
<%@ include file="common_cs_js.jsp"%>
</head>
<body>

<div class="text-center mt-5">
   <a href="index.jsp" style="text-decoration: none;color:black;"><h1>ENCRYPTION AND DECRYPTION USING AES ALGORITHM</h1></a>
</div>

<div class="container-fluid mt-3">
    <div class="row">
        <div class="col-sm-6 mt-4" >
            <div class="card text-center">
            
                <div class="card-header text-center">
                    <h2>TEXT ENCRYPTION</h2>
                </div>   
                
                <%
                      String eText=(String)request.getAttribute("eText");
                      String pText=(String)request.getAttribute("pText");
                      String sText=(String)request.getAttribute("sText");
                %>
                              
                <div class="card-body">
                      <form action="TextEnDe" method="post">
                         <input type="hidden" name="action" value="TextE">
                         <div class="mb-3">
                             <label for="exampleInputEmail1" class="form-label">SECRET KEY:</label>
                             <input class="form-control" type="text" name="secretKey" placeholder="Enter Secret Key here..." value="<% if(sText!=null){%> <%=sText %> <% } %>" required>   
                         </div>
                         <div class="mb-3">
                             <label for="exampleInputEmail1" class="form-label">PLAIN TEXT:</label>
                             <textarea class="form-control" rows="5" name="plainText"  required><% if(pText!=null){%> <%=pText %> <% } %> </textarea>   
                         </div>
                         <div class="mb-3">
                             <label for="exampleInputPassword1" class="form-label">ENCRYPTED TEXT</label>
                             <textarea class="form-control" rows="5" name="encryptText" readonly><% if(eText!=null){%> <%=eText %> <% } %></textarea>
                         </div>
                      
                         <button type="submit" class="btn btn-secondary btn-lg btn-block">ENCRYPT</button>
                      </form>
                </div>
       
                
             </div>
          </div>
          
          <div class="col-sm-6 mt-4" >
            <div class="card text-center">
            
                <div class="card-header text-center">
                    <h2>TEXT DECRYPTION</h2>
                </div> 
                
                 <%
                      String secKey=(String)request.getAttribute("secKey");
                      String encText=(String)request.getAttribute("encText");
                      String decryptedString=(String)request.getAttribute("decryptedString");
                %>  
                              
                <div class="card-body">
                      <form action="TextEnDe" method="post">
                         <input type="hidden" name="action" value="TextD">
                         <div class="mb-3">
                             <label for="exampleInputEmail1" class="form-label">SECRET KEY:</label>
                             <input class="form-control" type="text" name="secKey" placeholder="Enter Secret Key here..." value="<% if(secKey!=null){%> <%=secKey %> <% } %>" required>   
                         </div>
                         <div class="mb-3">
                             <label for="exampleInputEmail1" class="form-label">ENCRYPTED TEXT:</label>
                             <textarea class="form-control" rows="5" name="encText" required><% if(encText!=null){%> <%=encText %> <% } %></textarea>
                   
                             
                         </div>
                         <div class="mb-3">
                             <label for="exampleInputPassword1" class="form-label">DECRYPTED TEXT</label>
                             <textarea class="form-control" rows="5" id="decText" readonly><% if(decryptedString!=null){%> <%=decryptedString %> <% } %></textarea>
                         </div>
                      
                         <button type="submit" class="btn btn-secondary btn-lg btn-block">DECRYPT</button>
                      </form>
                </div>
       
                
             </div>
          </div>
     </div>
</div>

</body>
</html>