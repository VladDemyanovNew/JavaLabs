package VDemyanov.Java_Lab8_WEB.servlets;

import java.io.*;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "secondTaskServlet", value = "/secondTaskServlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        try {
            writer.println("Текущая дата: " + new Date() + "<BR>");
            writer.println("метод доступа    " + request.getMethod() + "<BR>");
            writer.println("URL    "+ request.getRequestURL() + "<BR>");
            writer.println("Протокол    "+ request.getProtocol() + "<BR>");
            writer.println("IP-адреса клиента, от имени которого пришел запрос" + request.getRemoteAddr() + "<BR>");
            writer.println("Имя клиента " + request.getRemoteHost() + "   " + request.getRemoteUser() + "<BR>");
            writer.println("Номер порта " + request.getRemotePort() + "<BR>");
            writer.println("Cтрока HTTP-запроса  " + request.getQueryString() + "<BR>");
            writer.println("Имя и порт сервера  " + request.getServerName() +  "  " + request.getServerPort() + "<BR>");
            writer.println("Путь   " + request.getContextPath() + "<BR>");
            writer.println( request.getScheme() + "<BR>");

            writer.println("<BR><BR>Информация о заголовке запроса:<BR>");
            Enumeration< String > e = request.getHeaderNames();
            while (e.hasMoreElements()) {
                String name = e.nextElement();
                String value = request.getHeader(name);
                writer.println(name + " = " + value + "<BR>");
            }
        } finally {
            writer.close();
        }
    }

    public void destroy() {
    }
}