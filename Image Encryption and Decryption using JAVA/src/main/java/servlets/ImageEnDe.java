package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import aes.ImageEnc;

/**
 * Servlet implementation class ImageEnDe
 */
@MultipartConfig
@WebServlet("/ImageEnDe")
public class ImageEnDe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageEnDe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		RequestDispatcher rd;
        String action=request.getParameter("action");
		System.out.println(action);
		if(action.equals("imageE"))
		{
			String seKey=request.getParameter("seKey");
			Part part =request.getPart("image");
			String imageFileName=part.getSubmittedFileName();   
			String path="C:/Users/ROHIT/OneDrive/Desktop/MyFolder/"+imageFileName;
			ImageEnc.EncryptImage(path, seKey);
			request.setAttribute("resultEnc","Selected Image Enrypted Successfully");
		    rd=request.getRequestDispatcher("imageEncDec.jsp");
		    rd.forward(request,response);
		}
		
		if(action.equals("imageD"))
		{
			String deKey=request.getParameter("sdKey");
			System.out.println(deKey);
			Part part =request.getPart("image");
			String imageFileName=part.getSubmittedFileName();
			String path="C:/Users/ROHIT/OneDrive/Desktop/EncDecImages/"+imageFileName;
			ImageEnc.DecryptImage(path, deKey);
			request.setAttribute("resultDec","Selected Image Decrypted Successfully");
		    rd=request.getRequestDispatcher("imageEncDec.jsp");
		    rd.forward(request,response);
		}
		
	}
	
}
