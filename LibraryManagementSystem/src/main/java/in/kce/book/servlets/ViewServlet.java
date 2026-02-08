package in.kce.book.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import in.kce.book.bean.BookBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		BookBean b=(BookBean)session.getAttribute("book");
		out.print("<html><body>");
		out.print("<h3>Book Information</h3>");
		out.print("Book Title:"+b.getBookName());
		out.print("<br><br>Author Name:"+b.getAuthor().getAuthorName());
		out.print("<br><br>Author Contact:"+b.getAuthor().getContactNo());
		out.print("<br><br>Book Price:"+b.getCost());
		out.print("<br><br>Book ISBN:"+b.getIsbn());
		out.print("</body></html>");
		}
}
