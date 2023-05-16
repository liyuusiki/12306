package cn.edu.guet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class TicketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String startStation=request.getParameter("startStation");
        System.out.println("起始站:"+startStation);
        String endStation=request.getParameter("endStation");
        System.out.println("终点站:"+endStation);
        String departureDate=request.getParameter("departureDate");
        System.out.println("出发日期:"+departureDate);

        String allticket=TicketSearch.search(startStation,endStation,departureDate);

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.print(allticket);
        out.flush();
        out.close();
        /*response.setContentType("application/json;charset=UTF-8");
        String weather="{\"status\":\"1\",\"count\":\"1\",\"info\":\"OK\",\"infocode\":\"10000\",\"lives\":[{\"province\":\"北京\",\"city\":\"东城区\",\"adcode\":\"110101\",\"weather\":\"晴\",\"temperature\":\"24\",\"winddirection\":\"北\",\"windpower\":\"≤3\",\"humidity\":\"16\",\"reporttime\":\"2023-05-07 11:39:12\",\"temperature_float\":\"24.0\",\"humidity_float\":\"16.0\"}]}";
        PrintWriter out=response.getWriter();
        out.print(weather);
        out.flush();
        out.close();*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
