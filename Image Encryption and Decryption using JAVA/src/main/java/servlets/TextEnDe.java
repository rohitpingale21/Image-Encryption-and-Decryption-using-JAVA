package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aes.AES;

/**
 * Servlet implementation class TextEnDe
 */
@WebServlet("/TextEnDe")
public class TextEnDe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TextEnDe() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String action=request.getParameter("action");
		
		if(action.equals("TextE"))
		{
			String plainText=request.getParameter("plainText");
			final String secretKey=request.getParameter("secretKey");			
			String encryptedString = AES.encrypt(plainText, secretKey);
			
			RequestDispatcher rd;
			request.setAttribute("eText",encryptedString);
			request.setAttribute("pText",plainText);
			request.setAttribute("sText",secretKey);
			rd=request.getRequestDispatcher("TextEncDec.jsp");
			rd.forward(request, response);
		}
		
		if(action.equals("TextD"))
		{
			final String secKey=request.getParameter("secKey");
			String encText=request.getParameter("encText");			
			String decryptedString = AES.decrypt(encText, secKey);
			
			RequestDispatcher rd;
			request.setAttribute("secKey",secKey);
			request.setAttribute("encText",encText);
			request.setAttribute("decryptedString",decryptedString);
			rd=request.getRequestDispatcher("TextEncDec.jsp");
			rd.forward(request, response);
		}
		
	}

}
