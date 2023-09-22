package com.example.productdiscountcal;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

//    public void init() {
//        message = "Hello World!";
//    }

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String description=request.getParameter("description");
        float price=Float.parseFloat(request.getParameter("price"));
        float percent=Float.parseFloat(request.getParameter("percent"));
        float discountAmount= (float) (price*percent*0.01);
        float discountPrice= price-((float) (price*percent*0.01));

                // Hello
                PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>"+"Mô tả sản phẩm : "+ description + "</h1>");
        out.println("<h1>"+"Giá niêm yết của sản phẩm : "+ price + "</h1>");
        out.println("<h1>"+"Tỷ lệ chiết khấu : "+ percent + "</h1>");
        out.println("<h1>"+"Lượng chiết khấu: "+ discountAmount + "</h1>");
        out.println("<h1>"+"Gía sau khi được chiết khấu: "+ discountPrice + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}