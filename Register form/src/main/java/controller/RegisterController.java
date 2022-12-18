package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDetails;
import service.RegisterService;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet(description = "Servlet for register", urlPatterns = { "/RegisterController" })
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RegisterService service = new RegisterService();
		
		//get parameters from request
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String password = request.getParameter("password");
		String repeatedPassword = request.getParameter("repeatedPassword");
		String department = request.getParameter("department");
		
		//print parameters
		service.printParameters(firstName, lastName, email, phoneNumber, password, repeatedPassword, department);
		
		//fields empty
		boolean isFieldsEmpty = service.isFieldsEmpty(firstName, lastName, email, phoneNumber, password, repeatedPassword, department);
		
		//password validation
		boolean isPasswordOk = service.isPasswordOk(password);
		
		//check email
		boolean isEmailOk = service.isEmailOk(email);
		
		if (isFieldsEmpty) {
			System.out.println("All fields filled.");
			if (isEmailOk) {
				System.out.println("Email is ok.");
				if (isPasswordOk) {
					if (password.equals(repeatedPassword)) {
						UserDetails userDetails = service.setUserDetails(firstName,lastName,email,phoneNumber,password,repeatedPassword,department );
						
						boolean saveUserDetailsInDataBase = service.saveUserDetailsInDataBase(userDetails);
						if (saveUserDetailsInDataBase) {
							response.sendRedirect("htmlPages/welcome.html");
						} else {
							response.sendRedirect("htmlPages/ErrorUserDetailsNotSaved.html");
						}
					}else {
						response.sendRedirect("htmlPages/wrongRepeatedPassword.html");
					}
				}else {
					response.sendRedirect("htmlPages/wrongPassword.html");
				}
			} else {
				response.sendRedirect("htmlPages/email.html");
			}
		} else {
			response.sendRedirect("htmlPages/fieldsEmpty.html");
		}

		
	}

}
