package anton.lysenko.info.demopaypal;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//http://localhost:8080/demopaypal_war_exploded/hello-servlet?product=name&subTotal=100&tax=10&total=110

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String product = request.getParameter("product");
        String subTotal = request.getParameter("subTotal");
        String tax = request.getParameter("tax");
        String total = request.getParameter("total");
        Order order = new Order(product, subTotal, tax, "0", total);
        PaymentService paymentService = new PaymentService();
        try {
            String link = paymentService.authorizePayment(order);
            response.sendRedirect(link);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}