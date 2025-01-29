package pos.websocket;

import com.sun.corba.se.impl.legacy.connection.DefaultSocketFactory;
import com.wealdtech.hawk.HawkClient;
import com.wealdtech.hawk.HawkCredentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.config.TlsConfig;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.socket.ConnectionSocketFactory;
import org.apache.hc.client5.http.socket.PlainConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.DefaultClientTlsStrategy;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.TlsSocketStrategy;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.config.RegistryBuilder;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.ssl.TLS;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import sun.security.ssl.SSLContextImpl;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Objects;
import java.util.UUID;

public class MainTest {
    public static void main(String[] args) {
//        String payload = "{\"merchant_receipt_id\":\"" + UUID.randomUUID() + "\",\"loyalty_identifier\":\"\",\"paid_sum\":6.00,\"discount_sum\":0,\"items\":[{\"product_id\":\"33224\",\"product_name\":\"Напій 0.8л.\",\"price\":10.00,\"quantity\":1,\"quantity_unit\":\"ШТ.\"}],\"payment\":{\"masked_pan\":\"XXXXXXXXXXXX3958\",\"paid_at\":\"2024-11-19T17:49:25+0200\",\"rrn\":\"000019686506\",\"terminal_auth_code\":\"991503\",\"terminal_id\":\"IAAA0002\",\"description\":\"VISA\"}}";
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
//        TlsConfig tlsConfig = TlsConfig.custom()
//                .setSupportedProtocols(TLS.V_1_2)
//                .build();
//
//        SSLContext sslContext = null;
//        try {
//            sslContext = SSLContextBuilder.create()
//                    .setProtocol("TLSv1.2")
//                    .build();
//        } catch (NoSuchAlgorithmException | KeyManagementException e) {
//            throw new RuntimeException(e);
//        }
////            SSLContext sslContext = SSLContext.getInstance("TLSv1.3");
//        System.out.println("###sslContext.getProtocol()");
//        System.out.println(sslContext.getProtocol());
//            sslContext.init(null, null, new SecureRandom());
//            Security.addProvider(new SunProvider());
//        TlsConfig tlsConfig = TlsConfig.custom()
//                .setSupportedProtocols(TLS.V_1_2)
//                .build();
//
//        SSLContext sslContext = null;
//        try {
//            sslContext = SSLContextBuilder.create()
//                    .setProtocol("TLSv1.2")
//                    .build();
//        } catch (NoSuchAlgorithmException | KeyManagementException e) {
//            throw new RuntimeException(e);
//        }
////            SSLContext sslContext = SSLContext.getInstance("TLSv1.3");
//        System.out.println("###sslContext.getProtocol()");
//        System.out.println(sslContext.getProtocol());
//            sslContext.init(null, null, new SecureRandom());
//            Security.addProvider(new SunProvider());
//        Request request = new Request.Builder()
//                .url(url)
//                .header("Authorization", hawkHeader)
//                .header("Content-Type", "application/json")
//                .build();
//        OkHttpClient client = new OkHttpClient();
        //                PoolingHttpClientConnectionManager cm = PoolingHttpClientConnectionManagerBuilder.create()
//                        .setDefaultTlsConfig(tlsConfig)
//                        .setTlsSocketStrategy(DefaultClientTlsStrategy.createDefault())
//                            .setTlsVersions(TLS.V_1_0)
//                            .setHostnameVerifier(NoopHostnameVerifier.INSTANCE)
//                        .build();
        final SSLContext sslContext;
        try {
            sslContext = new SSLContextBuilder()
                    .loadTrustMaterial(null, (x509CertChain, authType) -> true)
                    .build();
        } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException e) {
            throw new RuntimeException(e);
        }

        //                PoolingHttpClientConnectionManager cm = PoolingHttpClientConnectionManagerBuilder.create()
////                        .setDefaultTlsConfig(tlsConfig)
//                        .setTlsSocketStrategy(DefaultClientTlsStrategy.createDefault())
////                            .setTlsVersions(TLS.V_1_0)
////                            .setHostnameVerifier(NoopHostnameVerifier.INSTANCE)
//                        .build();



        try (PoolingHttpClientConnectionManager cm = PoolingHttpClientConnectionManagerBuilder.create()
                .build();

             CloseableHttpClient client = HttpClients.custom()
                     .setConnectionManager(cm)
                     .build()) {

            HttpPost post = new HttpPost(url);
            post.setHeader("Authorization", hawkHeader);
            post.setHeader("Content-Type", "application/json");
////
            StringEntity entity = new StringEntity(payload);
            post.setEntity(entity);
//////
            String result = client.execute(post, new BasicHttpClientResponseHandler());
////            String result = "";
//////
            System.out.println(result);

            payloadHash = calculatePayloadHash(result, "application/json");

            System.out.println(payloadHash);


            String operationId = result.split("\"")[3];
            System.out.println(operationId);

            String urlGet = "https://ereceipt.loyaltyai.t3zt.com/api/v1/receipts/" + operationId + "/status/";
//            String urlGet = "https://ereceipt.loyaltyai.t3zt.com/api/v1/receipts/677b96c987354ec7ae485c6c.eaa20974-2395-41fd-8f3b-c9b3955a7e47/status/";
            String hawkHeaderGet = hawkClient.generateAuthorizationHeader(URI.create(urlGet), "GET", payloadHash, null, null, null);
            HttpGet get = new HttpGet(urlGet);
            get.setVersion(HttpVersion.HTTP_2_0);
            get.setHeader("Authorization", hawkHeaderGet);
            get.setHeader("Content-Type", "application/json");

            entity = new StringEntity(result);
            get.setEntity(entity);

            result = client.execute(get, new BasicHttpClientResponseHandler());

            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
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