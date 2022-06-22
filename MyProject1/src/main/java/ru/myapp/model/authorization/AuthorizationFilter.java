package ru.myapp.model.authorization;

import ru.myapp.ServletHelper;
import ru.myapp.model.User;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/authorization")
public class AuthorizationFilter extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, User> logPass = new HashMap<>();
        logPass.put("admin", new User("123", "admin"));

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (logPass.get("admin").getLogin().equals(login) && logPass.get("admin").getPassword().equals(password)) {
                //переход в меню администратора
            request.getRequestDispatcher("admin_menu.html").forward(request, response);

            } else {
            ServletHelper.populateHtmlBegin(response);
            response.getWriter().append("<p>Invalid password, try again</p>");
            response.getWriter().append("<p><a href=\"./authForm.html\">HA3AD</a></p> </body></html>");

            }
        }
    }

