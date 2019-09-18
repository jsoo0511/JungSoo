package hw.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hw.dto.Product;

@WebServlet("/AddProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String number = request.getParameter("number");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String info = request.getParameter("info");
		
		Product product = new Product(number, name, price, info);
		
		HttpSession session = request.getSession();
		session.setAttribute("recentproduct", product);
		
		Cookie cookie = new Cookie("recentcookie", "recentproduct");
		cookie.setMaxAge(10);
		response.addCookie(cookie);
		
		response.sendRedirect(request.getContextPath() + "/main.jsp");
	}
}
