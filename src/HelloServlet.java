import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) {
        try(ServletOutputStream servletOutputStream = res.getOutputStream()) {
            servletOutputStream.print("Hello world");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
