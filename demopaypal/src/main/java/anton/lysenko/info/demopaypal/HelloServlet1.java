package anton.lysenko.info.demopaypal;

import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.ShippingAddress;
import com.paypal.api.payments.Transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "helloServlet1", value = "/hello-servlet1")
public class HelloServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String paymentId = request.getParameter("paymentId");
        String token = request.getParameter("token");
        String PayerID = request.getParameter("PayerID");

        PaymentService paymentService = new PaymentService();
        System.out.println(paymentId);
        Payment payment = null;
        if (paymentId != null)
            payment = paymentService.getPaymentDetails(paymentId);

        System.out.println(payment);

        PayerInfo payerInfo = payment.getPayer().getPayerInfo();
        Transaction transaction = payment.getTransactions().get(0);
        ShippingAddress shippingAddress = transaction.getItemList().getShippingAddress();


        payment = paymentService.executePayment(paymentId, PayerID);

        request.setAttribute("payer", payerInfo);
        request.setAttribute("transaction", transaction);
        request.setAttribute("shippingAddress", shippingAddress);

        String url = "http://localhost:8080/demopaypal_war_exploded/hello-servlet1?paymentId=" + paymentId + "&token=" + token + "&PayerID=" + PayerID;
        System.out.println(url);

        try {
            request.getRequestDispatcher(url).forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
