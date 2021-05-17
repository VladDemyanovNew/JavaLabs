package VDemyanov.Java_Lab8_WEB.servlets;

import VDemyanov.Java_Lab8_WEB.service.DragonService;
import VDemyanov.Java_Lab8_WEB.service.PersonService;
import VDemyanov.Java_Lab8_WEB.service.RoleService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
    private PersonService personService;
    private RoleService roleService;
    private DragonService dragonService;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        personService = new PersonService();
        roleService = new RoleService();
        dragonService = new DragonService();

        final ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("personService", personService);
        servletContext.setAttribute("roleService", roleService);
        servletContext.setAttribute("dragonService", dragonService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //Close recourse.
        personService = null;
        roleService = null;
        dragonService = null;
    }
}
