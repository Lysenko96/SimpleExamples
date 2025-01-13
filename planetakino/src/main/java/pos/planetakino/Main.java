package pos.planetakino;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.hc.client5.http.auth.AuthScope;
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpHost;

import java.io.IOException;
import java.io.StringReader;

public class Main {

    // http://dev-bill.planetakino.ua/hs/Sales/sellbonuses?sumbonuses=50&idpartner={{partner_vcard}}&checkid=1234567890&onlycheck=yes
    public static void main(String[] args) {
        Main main = new Main();
        main.getPartner();
//        main.sellBonus();
//        main.getPartner();
    }

    private void sellBonus() {
        HttpGet request = new HttpGet("http://dev-bill.planetakino.ua/billing_dev/hs/Sales/sellbonuses?sumbonuses=0&idpartner=380939861725&checkid=1234567890&onlycheck=yes");

        BasicCredentialsProvider provider = new BasicCredentialsProvider();
        provider.setCredentials(
                new AuthScope(new HttpHost("dev-bill.planetakino.ua")),
                new UsernamePasswordCredentials("BarCentr", "A8t589JD".toCharArray())
        );

        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(provider)
                .build()) {
            String response = httpClient.execute(request, new BasicHttpClientResponseHandler());
            System.out.println(response);
            System.out.println(response.split("code")[0]);
            System.out.println(response.split("code")[1].substring(0, 4).split("")[2]);
//            System.out.println("=\"-1\"".substring(0, 4).split("")[2]);

//            JAXBContext context = JAXBContext.newInstance(ResponseSellBonus.class);
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//            StringReader reader = new StringReader(response);
//            ResponseSellBonus result = (ResponseSellBonus) unmarshaller.unmarshal(reader);
//            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getPartner() {
        HttpGet request = new HttpGet("http://dev-bill.planetakino.ua/billing_dev/hs/ManagementPartners/getpartner?partnerid=380939861725&returnbonuses=yes");

        BasicCredentialsProvider provider = new BasicCredentialsProvider();
        provider.setCredentials(
                new AuthScope(new HttpHost("dev-bill.planetakino.ua")),
                new UsernamePasswordCredentials("BarCentr", "A8t589JD".toCharArray())
        );

        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(provider)
                .build()) {
            String response = httpClient.execute(request, new BasicHttpClientResponseHandler());
            System.out.println(response);
            JAXBContext context = JAXBContext.newInstance(Client.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader reader = new StringReader(response);
            Client client = (Client) unmarshaller.unmarshal(reader);
            System.out.println(client);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }
}