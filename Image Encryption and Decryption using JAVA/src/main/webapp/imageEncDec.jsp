<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Image Encryption & Decryption</title>
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
                    <h2>IMAGE ENCRYPTION</h2>
                </div>   
                              
                <div class="card-body">
                      <form action="ImageEnDe" method="post" enctype="multipart/form-data" >
                         <input type="hidden" name="action" value="imageE">
                         
<%
    String message=(String)request.getAttribute("resultEnc");
    if(message!=null)
    {
    	
%>
    <div class="alert alert-success alert-dismissible fade show text-center" role="alert">
        <strong><%=message %></strong>
   </div>
<%    		
    }
%>
                         
                         <div class="mb-3">
                             <label for="exampleInputEmail1" class="form-label">SECRET KEY:</label>
                             <input class="form-control" type="text" name="seKey" placeholder="Enter Secret Key here..." required>   
                         </div>
                      
                         <div class="mb-3">
                             <label for="exampleInputEmail1" class="form-label">SELECT IMAGE:</label>
                             <input type="file" class="form-control" name="image" required>
                         </div>
                      
                         <button type="submit" class="btn btn-secondary btn-lg btn-block">ENCRYPT</button>
                      </form>
                </div>
       
                
             </div>
          </div>
          
          <div class="col-sm-6 mt-4" >
            <div class="card text-center">
            
                <div class="card-header text-center">
                    <h2>IMAGE DECRYPTION</h2>
                </div>   
                              
                <div class="card-body">
                      <form action="ImageEnDe" method="post" enctype="multipart/form-data">
                          <input type="hidden" name="action" value="imageD">
                          
<%
    String message1=(String)request.getAttribute("resultDec");
    if(message1!=null)
    {
    	
%>
    <div class="alert alert-success alert-dismissible fade show text-center" role="alert">
        <strong><%=message1 %></strong>
   </div>
<%    		
    }
%>
                          
                         <div class="mb-3">
                             <label for="exampleInputEmail1" class="form-label">SECRET KEY:</label>
                             <input class="form-control" type="text" name="sdKey" placeholder="Enter Secret Key here..." required>   
                         </div>
                       
                         <div class="mb-3">
                             <label for="exampleInputEmail1" class="form-label">SELECT ENCRYPTED IMAGE:</label>
                             <input type="file" class="form-control" name="image" required>
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