package VDemyanov.Java_Lab8_WEB.command;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = null;
        // извлечение имени команды из запроса
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
        // если команда не задана в текущем запросе
            return current;
        }
        // получение объекта, соответствующего команде
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {

        }
        return current;
    }
}
