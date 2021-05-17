package VDemyanov.Java_Lab8_WEB.servlets.servlet;

import VDemyanov.Java_Lab8_WEB.entity.Dragon;
import VDemyanov.Java_Lab8_WEB.service.DragonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteDragonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        final DragonService dragonService = (DragonService) req.getServletContext().getAttribute("dragonService");

        try {
            dragonService.remove(Integer.valueOf(req.getParameter("id")));
            req.setAttribute("dragons", dragonService.getAll());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        req.getRequestDispatcher("/WEB-INF/view/user.jsp").forward(req, resp);
    }
}
