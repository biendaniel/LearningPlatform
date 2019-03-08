import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserService userService = new UserService();
//        PrintWriter printWriter = response.getWriter();
        userService.delete(3);
//        List<User> user = userService.findAll();
//        printWriter.append("<html><body>"+user +"</body></html>");
    }

}