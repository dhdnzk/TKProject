package servlet;

import dao.DAOManager;
import filePath.Path;
import servlet.servlet.noticeSupport.NoticeGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//TODO : Refactoring Class RecordShowingServlet
// TODO : Add comment
@WebServlet(name = "/recordShowingServlet", urlPatterns =
		"/recordShowingServlet")
public class RecordShowingServlet extends HttpServlet {

	// TODO : Add comment
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		showAllEmployees(request, response);

	}

	// TODO : Add comment
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			if (request.getParameter("search_mode") == null) {
				System.out.println("null");
			} else if(request.getParameter("search_mode").equals("")) {
				System.out.println("\"\"");
			} else {
				System.out.println("nothing");
			}
		} catch(NullPointerException e) {
			e.printStackTrace();
		}

	}

	// TODO : Add comment
	private void showAllEmployees(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String nextPageUrl;

		DAOManager daoManager = new DAOManager();

		try {

			session.setAttribute("list", daoManager.getAllEmployees());

			nextPageUrl = "emp_list.jsp";

		} catch (Exception e) {

			new NoticeGenerator(request,
								"can't get data from DB",
								"/menu",
								"return");

			nextPageUrl =  "error.jsp";

		}

		request.getRequestDispatcher(Path.BASE_VIEW + nextPageUrl).forward(request, response);

	}

}