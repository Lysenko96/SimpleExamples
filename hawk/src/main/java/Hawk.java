
import com.wealdtech.hawk.HawkClient;
import com.wealdtech.hawk.HawkCredentials;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

public class Hawk {

    private final String hawkKeyId;
    private final String hawkSecret;
    private final String host;
    private final int port;

    public Hawk(String hawkKeyId, String hawkSecret, String host, int port) {
        this.hawkKeyId = hawkKeyId;
        this.hawkSecret = hawkSecret;
        this.host = host;
        this.port = port;
    }

    public String sendPost(String path, String payload) throws Exception {
        String url = "https://" + host + ":" + port + path;

        // Generate Hawk header
        return generateHawkHeader(path, "POST", payload);

        // Send HTTP POST request
//        return sendRequest("POST", url, payload, hawkHeader);
    }

//    public String sendGet(String path) throws Exception {
//        String url = "https://" + host + ":" + port + path;
//
//        // Generate Hawk header
//        String hawkHeader = generateHawkHeader(path, "GET", "");
//
//        // Send HTTP GET request
//        return sendRequest("GET", url, null, hawkHeader);
//    }

    private String generateHawkHeader(String path, String method, String payload) throws Exception {
        // Create a timestamp and nonce
//        String timestamp = String.valueOf(Instant.now().getEpochSecond());
//        String nonce = UUID.randomUUID().toString().replace("-", "").substring(0, 6);
        String url = "https://" + host + ":" + port + path;
        System.out.println(payload);
        System.out.println(url);
        String payloadHash = calculatePayloadHash(payload, "application/json");
        System.out.println(payloadHash);

        HawkCredentials hawkCredentials = new HawkCredentials.Builder()
                .keyId(hawkKeyId)
                .key(hawkSecret)
                .algorithm(HawkCredentials.Algorithm.SHA256)
                .build();

//        Hawk.PayloadValidation payloadValidation = Hawk.PayloadValidation.IFPRESENT;
//
//        HawkClientConfiguration configuration = new HawkClientConfiguration.Builder()
//                .payloadValidation(payloadValidation)
//                .build();

        HawkClient hawkClient = new HawkClient.Builder()
                .credentials(hawkCredentials)// Set Hawk credentials
                .build();

        String result = hawkClient.generateAuthorizationHeader(URI.create(url), method, payloadHash, null, null, null);
        return sendRequest("POST", url, payload, result);
        // Canonical string for signing
//        String normalizedString = "hawk.1.header\n" +
//                timestamp + "\n" +
//                nonce + "\n" +
//                method.toUpperCase() + "\n" +
//                path + "\n" +
//                host + "\n" +
//                port + "\n" +
//                payloadHash + "\n" +
//                "\n";
//
//        // Generate the MAC using HMAC-SHA256
//        Mac mac = Mac.getInstance("HmacSHA256");
//        mac.init(new SecretKeySpec(hawkSecret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
//        byte[] macBytes = mac.doFinal(normalizedString.getBytes(StandardCharsets.UTF_8));
//        String macBase64 = Base64.getEncoder().encodeToString(macBytes);


        // Build the Hawk Authorization header
//        return "Hawk id=\"" + hawkKeyId + "\", ts=\"" + timestamp + "\", nonce=\"" + nonce + "\", mac=\"" + macBase64 + "\", hash=\"" + payloadHash + "\"";
    }

    private static String calculatePayloadHash(String payload, String contentType) throws Exception {
        String normalizedPayload = "hawk.1.payload\n" +
                contentType + "\n" +
                payload + "\n";

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] payloadHashBytes = digest.digest(normalizedPayload.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(payloadHashBytes);
    }

    private String sendRequest(String method, String url, String payload, String hawkHeader) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            CloseableHttpResponse response;

            if ("POST".equalsIgnoreCase(method)) {
                HttpPost post = new HttpPost(url);
                post.setHeader("Authorization", hawkHeader);
                post.setHeader("Content-Type", "application/json");

                // Add payload if not null
                if (payload != null) {
                    StringEntity entity = new StringEntity(payload);
                    post.setEntity(entity);
                }

                response = client.execute(post);
            } else if ("GET".equalsIgnoreCase(method)) {
                HttpGet get = new HttpGet(url);
                get.setHeader("Authorization", hawkHeader);
                response = client.execute(get);
            } else {
                throw new UnsupportedOperationException("Method not supported: " + method);
            }

            // Get the response as a string
            return EntityUtils.toString(response.getEntity());
        }
    }
}
