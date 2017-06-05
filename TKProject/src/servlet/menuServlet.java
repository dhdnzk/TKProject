package servlet;

import directory.Directories;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by bumskim on 2017. 6. 5..
 *
 */
@WebServlet(name = "menuServlet", urlPatterns = "/menu")
public class menuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        try {
            session.getAttribute("id");
            request.getRequestDispatcher(Directories.baseView + "menu.jsp").forward(request, response);
        } catch(NullPointerException e) {
            request.getRequestDispatcher(Directories.baseView + "login.jsp").forward(request, response);
        }
    }
}