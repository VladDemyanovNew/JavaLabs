package VDemyanov.Java_Lab8_WEB.servlets.filter;

import VDemyanov.Java_Lab8_WEB.entity.Person;
import VDemyanov.Java_Lab8_WEB.service.DragonService;
import VDemyanov.Java_Lab8_WEB.service.PersonService;
import VDemyanov.Java_Lab8_WEB.service.RoleService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import static java.util.Objects.nonNull;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

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
                moveToMenu(req, res, role);

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

                        moveToMenu(req, res, role);

                    } else {
                        moveToMenu(req, res, Person.ROLE.UNKNOWN);
                    }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void moveToMenu(final HttpServletRequest req,
                            final HttpServletResponse res,
                            Person.ROLE role) throws ServletException, IOException {

        if (role.equals(Person.ROLE.ADMIN))
            req.getRequestDispatcher("/WEB-INF/view/admin.jsp").forward(req, res);
        else if (role.equals(Person.ROLE.USER))
            req.getRequestDispatcher("/WEB-INF/view/user.jsp").forward(req, res);
        else
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);
    }

    @Override
    public void destroy() {
    }

}
