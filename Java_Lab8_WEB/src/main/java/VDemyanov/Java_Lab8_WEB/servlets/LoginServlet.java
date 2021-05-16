package VDemyanov.Java_Lab8_WEB.servlets;

import VDemyanov.Java_Lab8_WEB.bl.Util;
import VDemyanov.Java_Lab8_WEB.entity.Person;
import VDemyanov.Java_Lab8_WEB.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {

    PersonService personService = new PersonService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter writer = null;
        try {
            response.setContentType("text/html");
            writer = response.getWriter();

            String login = request.getParameter("userLogin");
            String password = request.getParameter("userPassword");

            Person person = personService.getByLoginAndPassword(login, password);

            if (person != null) {
                writer.println("<p>login: " + person.getLogin() + "</p>");
                writer.println("<p>password: " + person.getPassword() + "</p>");
                writer.println("<p>role: " + person.getRole() + "</p>");
            } else {
                writer.println("<p>Error!</p>");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            writer.close();
        }
    }
}