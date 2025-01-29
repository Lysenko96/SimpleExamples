package pos.websocket;

import com.wealdtech.hawk.HawkClient;
import com.wealdtech.hawk.HawkCredentials;
import okhttp3.*;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.Objects;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        String payload = "{\n" +
                "  \"merchant_receipt_id\" : \"" + UUID.randomUUID() + "\",\n" +
                "  \"paid_sum\" : 169.00,\n" +
                "  \"discount_sum\" : 0.00,\n" +
                "  \"items\" : [ {\n" +
                "    \"product_id\" : \"233215\",\n" +
                "    \"product_name\" : \"Капці-чешки різнокольорові ЗЕД арт.YBE240515-222/К285\",\n" +
                "    \"price\" : 169.00,\n" +
                "    \"quantity\" : 1,\n" +
                "    \"quantity_unit\" : \"ШТ.\"\n" +
                "  } ],\n" +
                "  \"payment\" : {\n" +
                "    \"masked_pan\" : \"544568417XXXXXX8\",\n" +
                "    \"paid_at\" : \"2025-01-06T10:39:34.00000+0200\",\n" +
                "    \"rrn\" : \"092363269103\",\n" +
                "    \"terminal_auth_code\" : \"449891\",\n" +
                "    \"terminal_id\" : \"S1K904C1\",\n" +
                "    \"description\" : \"MasterCard\"\n" +
                "  },\n" +
                "  \"fiscal\" : {\n" +
                "    \"registered_at\" : \"2025-01-06T10:38:49.00000+0200\",\n" +
                "    \"url\" : \"https://cabinet.tax.gov.ua/cashregs/check?id=158221&fn=3001046175&sm=169.00&date=2025-01-06&time=10:38:49\",\n" +
                "    \"rso_fn\" : \"3001046175\",\n" +
                "    \"receipt_fn\" : \"158231\"\n" +
                "  }\n" +
                "}";
        String hawkKeyId = "tOvJ5W.14UgLpPPVwqDsE1pP7dvjKy608XdjYGH";
        String hawkSecret = "B5dNR5Ma.dp2MeOSUa6QadTI7ZAPJnSKJcdpJSKMAVKt4Azd7R0eUoqIpwizdiTrMKoyGEPzv";

        String url = "https://ereceipt.loyaltyai.t3zt.com/api/v1/receipts/";


        String payloadHash = calculatePayloadHash(payload, "application/json");

        HawkCredentials hawkCredentials = new HawkCredentials.Builder()
                .keyId(hawkKeyId)
                .key(hawkSecret)
                .algorithm(HawkCredentials.Algorithm.SHA256)
                .build();

        HawkClient hawkClient = new HawkClient.Builder()
                .credentials(hawkCredentials)
                .build();

        String hawkHeader = hawkClient.generateAuthorizationHeader(URI.create(url), "POST", payloadHash, null, null, null);
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(payload, MediaType.parse("application/json")))
                .header("Authorization", hawkHeader)
                .header("Content-Type", "application/json")
                .build();
        OkHttpClient client = null;

        try {
            client = new OkHttpClient.Builder()
                    .sslSocketFactory(createSSLSocketFactory(), new TrustAllCertificates())
                    .hostnameVerifier((hostname, session) -> true)
                    .build();
        } catch (Exception e) {
            System.out.println("client error");
            throw new RuntimeException(e);
        }
        try (
                Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                System.out.println(Objects.requireNonNull(response.body()).string());
            } else {
                System.out.println("Request failed: " + response.code());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static SSLSocketFactory createSSLSocketFactory() throws Exception {
        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(null, new TrustManager[]{new TrustAllCertificates()}, null);
        return sslContext.getSocketFactory();
    }

    private static class TrustAllCertificates implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private static String calculatePayloadHash(String payload, String contentType) {
        String normalizedPayload = "hawk.1.payload\n" +
                contentType + "\n" +
                payload + "\n";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] payloadHashBytes = digest.digest(normalizedPayload.getBytes(StandardCharsets.UTF_8));

            return Base64.getEncoder().encodeToString(payloadHashBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}