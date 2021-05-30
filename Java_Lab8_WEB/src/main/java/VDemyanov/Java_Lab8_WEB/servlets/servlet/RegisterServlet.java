package VDemyanov.Java_Lab8_WEB.servlets.servlet;

import VDemyanov.Java_Lab8_WEB.entity.Person;
import VDemyanov.Java_Lab8_WEB.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String message = getServletContext().getInitParameter("test"); // пример параметра для одного сервлета

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        final PersonService personService = (PersonService) req.getServletContext().getAttribute("personService");

        try {
            Person person = personService.checkUserUniq(login);
            if (person == null) {
                Person newUser = new Person();
                newUser.setLogin(login);
                newUser.setPassword(password);
                newUser.setRole(2);
                personService.add(newUser);
                resp.sendRedirect(req.getContextPath() + "/");
               // req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(req, resp);
                //resp.sendRedirect(req.getContextPath() + "/");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/register.jsp")
                .forward(req, resp);
    }
}
