public class Main {

    public static void main(String[] args) {
        try {
//            String payload = "{\"merchant_receipt_id\":\"6443dc6a-b872-4ee7-b028-e139e1be5deb\",\"loyalty_identifier\":\"\",\"paid_sum\":6.00,\"discount_sum\":0,\"items\":[{\"product_id\":\"33224\",\"product_name\":\"Напій 0.8л.\",\"price\":10.00,\"quantity\":1,\"quantity_unit\":\"ШТ.\"}],\"payment\":{\"masked_pan\":\"XXXXXXXXXXXX3958\",\"paid_at\":\"2024-11-19T17:49:25+0200\",\"rrn\":\"000019686506\",\"terminal_auth_code\":\"991503\",\"terminal_id\":\"IAAA0002\",\"description\":\"VISA\"}}";
            String payload = "{\"merchant_receipt_id\":\"6443dc6a-b872-4ee7-b028-e139e1be5deb\",\"loyalty_identifier\":\"\",\"paid_sum\":6.00,\"discount_sum\":0,\"items\":[{\"product_id\":\"33224\",\"product_name\":\"Напій 0.8л.\",\"price\":10.00,\"quantity\":1,\"quantity_unit\":\"ШТ.\"}],\"payment\":{\"masked_pan\":\"XXXXXXXXXXXX3958\",\"paid_at\":\"2024-11-19T17:49:25+0200\",\"rrn\":\"000019686506\",\"terminal_auth_code\":\"991503\",\"terminal_id\":\"IAAA0002\",\"description\":\"VISA\"}}";
            String hawkKeyId = "tOvJ5W.14UgLpPPVwqDsE1pP7dvjKy608XdjYGH";
//            String hawkKeyId = "dh37fgj492je";
//            String hawkSecret = "werxhqb98rpaxn39848xrunpaw3489ruxnpa98w4rxn";
            String host = "ereceipt.loyaltyai.t3zt.com";
//            String host = "example.com";
            int port = 443;
//            int port = 8080;

            Hawk hawk = new Hawk(hawkKeyId, null, host, port);

            // Sending a POST request
            String postResponse = hawk.sendPost("/api/v1/receipts/", payload);
            System.out.println("POST Response: " + postResponse);

            // Sending a GET request
//            String getResponse = hawkClient.sendGet("/api/v1/receipts/");
//            String getResponse = hawkClient.sendGet("/resource/1?b=1&a=2");
//            System.out.println("GET Response: " + getResponse);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
