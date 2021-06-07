package VDemyanov.Java_Lab8_WEB.command;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {
    String execute(HttpServletRequest request);
}
