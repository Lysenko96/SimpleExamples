package anton.lysenko.info.demopaypal;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;

public class PaymentService {

    private static final String CLIENT_ID = "AbhKc8A3a9heZvCQnySawCOfUM5wTdSSUd5rRUjTdi5s9Z1nYssQJGrWQdv-vxRHCNzpxR452HGz0_HV";
    private static final String  SECRET = "EIn2XNowkIcWNLDQPssYCZGN5sTi1VjHbSdKSbZpQsNj4AnhZ2J-UBotDNNFU9WMSxNT1Nv-4K489lRV";
    private static final String MODE = "sandbox";

    public String authorizePayment(Order order){
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName("anton").setLastName("lysenko").setEmail("anton.lys96@gmail.com");

        payer.setPayerInfo(payerInfo);

        List<Transaction> transactions = getTransactionInformation(order);

        Payment payment = new Payment();
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:8080/demopaypal_war_exploded/hello-servlet1");
        redirectUrls.setReturnUrl("http://localhost:8080/demopaypal_war_exploded/hello-servlet1");
        payment.setTransactions(transactions).setRedirectUrls(redirectUrls).setPayer(payer).setIntent("authorize");
        Payment resultPayment = null;
        APIContext context = new APIContext(CLIENT_ID, SECRET, MODE);
        try {
             resultPayment = payment.create(context);
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }


        System.out.println(resultPayment);

        return getLink(resultPayment);
    }

    public Payment getPaymentDetails(String paymentId) {
        APIContext apiContext = new APIContext(CLIENT_ID, SECRET, MODE);
        Payment payment = null;
        try {
            payment = Payment.get(apiContext, paymentId);
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return payment;
    }

    public Payment executePayment(String paymentId, String payerId){
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);

        Payment payment = new Payment().setId(paymentId);
        APIContext apiContext  = new APIContext(CLIENT_ID, SECRET, MODE);
        try {
            payment = payment.execute(apiContext, paymentExecution);
        } catch (PayPalRESTException e){
            e.printStackTrace();
        }
        return payment;
    }

    private String getLink(Payment resultPayment){
        List<Links> links = resultPayment.getLinks();
        String resultLink = null;
        for(Links link : links){
            if(link.getRel().equalsIgnoreCase("approval_url")){
                resultLink = link.getHref();
            }
        }
        return resultLink;
    }

    private List<Transaction> getTransactionInformation(Order order){
        Details details = new Details();
        details.setShipping(order.getShipping());
        details.setSubtotal(order.getSubTotal());
        details.setTax(order.getTax());

        System.out.println(details);

        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal(order.getTotal());
        amount.setDetails(details);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription(order.getName());

        ItemList itemList = new ItemList();
        List<Item> items = new ArrayList<>();

        Item item = new Item();
        item.setCurrency("USD").setName(order.getName()).setPrice(order.getSubTotal()).setTax(order.getTax()).setQuantity("1");

        items.add(item);
        itemList.setItems(items);
        transaction.setItemList(itemList);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);
        return transactions;
    }

}
