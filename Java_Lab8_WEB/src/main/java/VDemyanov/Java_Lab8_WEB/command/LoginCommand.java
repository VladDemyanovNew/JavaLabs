package VDemyanov.Java_Lab8_WEB.command;

import VDemyanov.Java_Lab8_WEB.entity.Person;
import VDemyanov.Java_Lab8_WEB.service.DragonService;
import VDemyanov.Java_Lab8_WEB.service.PersonService;
import VDemyanov.Java_Lab8_WEB.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import static java.util.Objects.nonNull;

public class LoginCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) {
        String page = null;
        // извлечение из запроса логина и пароля
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        final PersonService personService = (PersonService) req.getServletContext().getAttribute("personService");
        final RoleService roleService = (RoleService) req.getServletContext().getAttribute("roleService");
        final DragonService dragonService = (DragonService) req.getServletContext().getAttribute("dragonService");
        final HttpSession session = req.getSession();

        try {
            //Logged user.
            if (nonNull(session) && nonNull(session.getAttribute("login")) &&
                    nonNull(session.getAttribute("password"))) {

                final Person.ROLE role = (Person.ROLE) session.getAttribute("role");
                moveToMenu(role);

            } else {
                Person person = personService.userIsExist(login, password);
                if (person != null) {

                    final String userRole = roleService.getRoleName(person.getRole());
                    final Person.ROLE role;

                    req.setAttribute("person", person);
                    req.setAttribute("dragons", dragonService.getAll());

                    if (userRole.equals("admin"))
                        role = Person.ROLE.ADMIN;
                    else if (userRole.equals("user"))
                        role = Person.ROLE.USER;
                    else
                        role = Person.ROLE.UNKNOWN;

                    req.getSession().setAttribute("password", password);
                    req.getSession().setAttribute("login", login);
                    req.getSession().setAttribute("role", role);

                    page = moveToMenu(role);

                } else {
                    page = moveToMenu(Person.ROLE.UNKNOWN);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return page;
    }

    private String moveToMenu(Person.ROLE role) throws ServletException, IOException {

        if (role.equals(Person.ROLE.ADMIN))
            return "/WEB-INF/view/admin.jsp";
        else if (role.equals(Person.ROLE.USER))
            return "/WEB-INF/view/user.jsp";
        else
            return "/WEB-INF/view/login.jsp";
    }
}
