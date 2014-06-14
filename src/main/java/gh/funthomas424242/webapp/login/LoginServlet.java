package gh.funthomas424242.webapp.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    // Runs when the servlet is loaded onto the server.
    @Override
    public void init() {
        //
    }

    // Runs on a thread whenever there is HTTP GET request
    // Take 2 arguments, corresponding to HTTP request and response
    @Override
    public void doGet(final HttpServletRequest request,
            final HttpServletResponse response) throws IOException,
            ServletException {

        final LoginBean loginBean = new LoginBean();
        request.setAttribute("loginBean", loginBean);

        forwardToLoginPage(request, response);

    }

    // Runs as a thread whenever there is HTTP POST request
    @Override
    public void doPost(final HttpServletRequest request,
            final HttpServletResponse response) throws IOException,
            ServletException {

        final String user = request.getParameter("user");
        final String password = request.getParameter("password");

        final LoginBean loginBean = new LoginBean();

        if ((user != null) && (password != null) && !user.isEmpty()
                && !password.isEmpty()) {
            loginBean.setMeldung("Ihre Anmeldung war erfolgreich.");
        } else {
            loginBean.setMeldung("Bitte prüfen Sie Ihre Zugangsdaten.");
        }

        request.setAttribute("loginBean", loginBean);

        forwardToLoginPage(request, response);
    }

    // Runs when the servlet is unloaded from the server.
    @Override
    public void destroy() {
        //
    }

    private void forwardToLoginPage(final HttpServletRequest request,
            final HttpServletResponse response) throws ServletException,
            IOException {
        final RequestDispatcher dispatcher = request
                .getRequestDispatcher("/login/login.html");
        dispatcher.forward(request, response);
    }

}
