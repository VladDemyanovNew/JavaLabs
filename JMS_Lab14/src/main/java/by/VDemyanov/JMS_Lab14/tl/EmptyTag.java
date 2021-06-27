package by.VDemyanov.JMS_Lab14.tl;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmptyTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print(LocalDateTime.now());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return SKIP_BODY;
    }
}
