package servlets;

import entity.Person;
import executive.HelloWorldLocal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.ejb.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Home on 6/3/2015.
 */
public class TestClient extends HttpServlet implements javax.servlet.Servlet {
    @EJB
    private HelloWorldLocal hello;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        try {
            Person person = new Person();
            person.setName(request.getParameter("name"));
            Person personName = hello.createPerson(person);
            request.getSession().setAttribute("result", personName.getName());
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
}