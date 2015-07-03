package org.sonatype.mavenbook.web;

import org.sonatype.mavenbook.weather.WeatherService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jarsen on 7/2/15.
 */
public class WeatherServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

        String zip = request.getParameter("zip");
        WeatherService weatherService = new WeatherService();
        PrintWriter out = response.getWriter();
        try {
            out.println(weatherService.retrieveForecast(zip));
        } catch (Exception ex) {
            out.println("Error retrieving forecast: " + ex.getMessage());
        }
        out.flush();
        out.close();

    }

}
