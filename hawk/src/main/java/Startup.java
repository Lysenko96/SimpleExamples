//import com.wealdtech.hawk.HawkClient;
//import com.wealdtech.hawk.HawkCredentials;
//import org.apache.hc.client5.http.classic.methods.HttpPost;
//import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
//import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
//import org.apache.hc.client5.http.impl.classic.HttpClients;
//import org.apache.hc.core5.http.io.entity.EntityUtils;
//import org.apache.hc.core5.http.io.entity.StringEntity;
//
//import javax.crypto.Mac;
//import javax.crypto.spec.SecretKeySpec;
//import java.net.URI;
//import java.nio.charset.StandardCharsets;
//import java.util.Base64;
//
//public class Startup {
//
//    public static void main(String[] args) {
//        String url = "https://ereceipt.loyaltyai.t3zt.com/api/v1/receipts/";
//        String payload = "{\"merchant_receipt_id\":\"6443dc6a-b872-4ee7-b028-e139e1be5deb\",\"loyalty_identifier\":\"\",\"paid_sum\":6.00,\"discount_sum\":0,\"items\":[{\"product_id\":\"33224\",\"product_name\":\"Напій 0.8л.\",\"price\":10.00,\"quantity\":1,\"quantity_unit\":\"ШТ.\"}],\"payment\":{\"masked_pan\":\"XXXXXXXXXXXX3958\",\"paid_at\":\"2024-11-19T17:49:25+0200\",\"rrn\":\"000019686506\",\"terminal_auth_code\":\"991503\",\"terminal_id\":\"IAAA0002\",\"description\":\"VISA\"}}";
//        String hawkKeyId = "tOvJ5W.14UgLpPPVwqDsE1pP7dvjKy608XdjYGH";
//        String hawkSecret = "B5dNR5Ma.dp2MeOSUa6QadTI7ZAPJnSKJcdpJSKMAVKt4Azd7R0eUoqIpwizdiTrMKoyGEPzv";
//
//        HawkCredentials hawkCredentials = new HawkCredentials.Builder()
//                .keyId(hawkKeyId)
//                .key(hawkSecret)
//                .algorithm(HawkCredentials.Algorithm.SHA256)
//                .build();
//
//        HawkClient hawkClient = new HawkClient.Builder().credentials(hawkCredentials).build();
//
//        Mac mac = null;
//        try {
//            mac = Mac.getInstance("HmacSHA256");
//            mac.init(new SecretKeySpec(hawkSecret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
//            byte[] macBytes = mac.doFinal(payload.getBytes(StandardCharsets.UTF_8));
//            String macBase64 = Base64.getEncoder().encodeToString(macBytes);
//            String authorizationHeader = hawkClient.generateAuthorizationHeader(URI.create(url), "POST", macBase64, null, null, null);
//            sendHawkPost(url, payload, authorizationHeader);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//
////and JMeter specifics:
//
//        // Define the request details
////        URI uri = null;
////        String contentType = "application/json";
////        try {
////            uri = new URI(url);
////        } catch (URISyntaxException e) {
////            throw new RuntimeException(e);
////        }
//
//        // Create a Hawk client
////        HawkClient hawkClient = new HawkClient.Builder()
////                .credentials(credentials)
////                .build();
//
//        // Generate Hawk authorization header
//        try {
////            String hawkHeader = generateHawkHeader(url, "POST", payload, hawkKeyId, hawkSecret);
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
////        String hawkHeader = hawkClient.generateAuthorizationHeader(
////                uri,
////                "POST",
////                null,
////                contentType,
////                null,
////                null
////        );
//
//    }
//
////    private static String generateHawkHeader(String payload, String hawkKeyId, String hawkSecret) throws Exception {
////        // Create a timestamp and nonce
////        String timestamp = String.valueOf(Instant.now().getEpochSecond());
////        String nonce = UUID.randomUUID().toString().replace("-", "").substring(0, 6);
////
////        // Canonical string for signing
////        String normalizedString = "hawk.1.header\n" +
////                timestamp + "\n" +
////                "RZKGNz" + "\n" +
////                "POST"+ "\n" +
////                "api/v1/receipts/\n" + // Path
////                "https://ereceipt.loyaltyai.t3zt.com/443" + "\n" +
////                payload.length() + "\n" +
////                payload + "\n";
////
////        // Generate the MAC using HMAC-SHA256
////        Mac mac = Mac.getInstance("HmacSHA256");
////        mac.init(new SecretKeySpec(hawkSecret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
////        byte[] macBytes = mac.doFinal(normalizedString.getBytes(StandardCharsets.UTF_8));
////        String macBase64 = Base64.getEncoder().encodeToString(macBytes);
////
////        // Build the Hawk Authorization header
////        return "Hawk id=\"" + hawkKeyId + "\", ts=\"" + timestamp + "\", nonce=\"" + nonce + "\", mac=\"" + macBase64 + "\"";
////    }
//
//    private static void sendHawkPost(String url, String payload, String hawkHeader) throws Exception {
//        try (CloseableHttpClient client = HttpClients.createDefault()) {
//            HttpPost post = new HttpPost(url);
//            post.setHeader("Authorization", hawkHeader);
//            post.setHeader("Content-Type", "application/json; charset=utf-8");
//
//            // Add the payload
//            StringEntity entity = new StringEntity(payload);
//            post.setEntity(entity);
//
//            // Execute the request
//            CloseableHttpResponse response = client.execute(post);
//            String responseString = EntityUtils.toString(response.getEntity());
//            System.out.println("Response Code: " + response.getCode());
//            System.out.println("Response: " + responseString);
//        }
//    }
//}
