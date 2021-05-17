package VDemyanov.Java_Lab8_WEB.servlets.servlet;

import VDemyanov.Java_Lab8_WEB.entity.Dragon;
import VDemyanov.Java_Lab8_WEB.service.DragonService;
import com.sun.javafx.scene.layout.region.Margins;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddDragonServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        final String name = req.getParameter("name");
        final int power = Integer.parseInt(req.getParameter("power"));
        final int health = Integer.parseInt(req.getParameter("health"));

        final DragonService dragonService = (DragonService) req.getServletContext().getAttribute("dragonService");

        Dragon dragon = new Dragon();
        dragon.setName(name);
        dragon.setPower(power);
        dragon.setHealth(health);

        try {
            dragonService.add(dragon);
            req.setAttribute("dragons", dragonService.getAll());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        req.getRequestDispatcher("/WEB-INF/view/user.jsp").forward(req, resp);
    }
}
