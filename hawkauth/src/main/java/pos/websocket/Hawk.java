//package pos.websocket;
//
//import com.wealdtech.hawk.HawkClient;
//import com.wealdtech.hawk.HawkCredentials;
//import org.apache.hc.client5.http.classic.methods.HttpPost;
//import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
//import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
//import org.apache.hc.client5.http.impl.classic.HttpClients;
//import org.apache.hc.core5.http.io.entity.EntityUtils;
//import org.apache.hc.core5.http.io.entity.StringEntity;
//
//import java.net.URI;
//import java.nio.charset.StandardCharsets;
//import java.security.MessageDigest;
//import java.util.Base64;
//
//public class Hawk {
//    private final String hawkKeyId;
//    private final String hawkSecret;
//    private final String host;
//    private final int port;
//
//    public Hawk(String hawkKeyId, String hawkSecret, String host, int port) {
//        this.hawkKeyId = hawkKeyId;
//        this.hawkSecret = hawkSecret;
//        this.host = host;
//        this.port = port;
//    }
//
//    private String generateHawkHeader(String path, String method, String payload) throws Exception {
//        String url = "https://" + host + ":" + port + path;
//        System.out.println(payload);
//        System.out.println(url);
//        String payloadHash = calculatePayloadHash(payload, "application/json");
//        System.out.println(payloadHash);
//
//        HawkCredentials hawkCredentials = new HawkCredentials.Builder()
//                .keyId(hawkKeyId)
//                .key(hawkSecret)
//                .algorithm(HawkCredentials.Algorithm.SHA256)
//                .build();
//
//        HawkClient hawkClient = new HawkClient.Builder()
//                .credentials(hawkCredentials)
//                .build();
//
//        return hawkClient.generateAuthorizationHeader(URI.create(url), method, payloadHash, null, null, null);
//    }
//
//    private static String calculatePayloadHash(String payload, String contentType) throws Exception {
//        String normalizedPayload = "hawk.1.payload\n" +
//                contentType + "\n" +
//                payload + "\n";
//
//        MessageDigest digest = MessageDigest.getInstance("SHA-256");
//        byte[] payloadHashBytes = digest.digest(normalizedPayload.getBytes(StandardCharsets.UTF_8));
//        return Base64.getEncoder().encodeToString(payloadHashBytes);
//    }
//
//    private String sendRequest(String method, String url, String payload, String hawkHeader) throws Exception {
//        try (CloseableHttpClient client = HttpClients.createDefault()) {
//            CloseableHttpResponse response = null;
//
//            if ("POST".equalsIgnoreCase(method)) {
//                HttpPost post = new HttpPost(url);
//                post.setHeader("Authorization", hawkHeader);
//                post.setHeader("Content-Type", "application/json");
//
//                // Add payload if not null
//                if (payload != null) {
//                    StringEntity entity = new StringEntity(payload);
//                    post.setEntity(entity);
//                }
//
//                response = client.execute(post);
//            }
//
//            // Get the response as a string
//            return EntityUtils.toString(response.getEntity());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//}
