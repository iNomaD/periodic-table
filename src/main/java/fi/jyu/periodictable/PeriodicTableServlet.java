package fi.jyu.periodictable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Denis on 08.09.2017.
 */
@WebServlet("/PeriodicTableServlet")
public class PeriodicTableServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String elementName = request.getParameter("elementName").toString();
        PrintWriter out = response.getWriter();
        if(elementName.equals("")){
            out.write(new PeriodicElement(-1, "NULL", "NULL", "error: Please, provide a value!").toJSON());
        }else{
            try {
                // get atomic number and symbol
                PeriodicElement element = ServiceResponseProcessor.getElementInfo(elementName);

                //find definition in the dictionary
                ServiceResponseProcessor.defineElement(element);

                //return in JSON
                out.write(element.toJSON());
            } catch (Exception e) {
                e.printStackTrace();
                out.write(new PeriodicElement(-1, "NULL", "NULL", "error: Something went wrong!").toJSON());
            }
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
