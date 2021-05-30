package VDemyanov.Java_Lab8_WEB.util.pages;

public enum Page {
    LOGIN_PAGE("/WEB-INF/view/login.jsp"),
    REGISTER_PAGE("/WEB-INF/view/register.jsp"),
    WELCOME_PAGE ("/WEB-INF/view/user.jsp"),
    ERROR_PAGE ("/WEB-INF/view/error.jsp");

    private final String value;

    Page(String value) { this.value = value; }

    public String getPage() { return value; }
}