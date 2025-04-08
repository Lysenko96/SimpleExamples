package mono.merchant.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import mono.merchant.model.*;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

public class MonoMerchant {

    private Logger logger;
    private String merchantUrl = "https://api.monobank.ua/api/merchant";
    private static final String GET_LIST = "/split-receiver/list";
    private static final String GET_LIST_MERCHANT = "/submerchant/list";
    private static final String POST_INVOICE_CREATE = "/invoice/create";
    private static final String POST_INVOICE_CANCEL = "/invoice/cancel";
    private ObjectMapper mapper = new ObjectMapper();


    public MonoMerchant(Logger logger) {
        this.logger = logger;
//        this.merchantUrl = prop.getString("MERCHANT_URL", "https://api.monobank.ua/api/merchant");
    }

    public void createInvoice(MonoInvoice invoice) {
//        try {
//            String result = executeHttpPost(merchantUrl + POST_INVOICE_CREATE, objectMapper.writeValueAsString(invoice););
//            logger.info(String.valueOf(objectMapper.readValue(result, MonoInvoiceResponse.class)));
//        } catch (JsonProcessingException e) {
//            logger.severe("createInvoice: " + e.getMessage());
//        }
        executeHttpPost(merchantUrl + POST_INVOICE_CREATE, invoice);
    }

    public void cancelInvoice(MonoInvoiceCancel cancel) {
//        try {
//            String result = executeHttpPost(merchantUrl + POST_INVOICE_CANCEL, objectMapper.writeValueAsString(cancel));
//            logger.info(String.valueOf(objectMapper.readValue(result, MonoCancelResponse.class)));
//        } catch (JsonProcessingException e) {
//            logger.severe("cancelInvoice: " + e.getMessage());
//            throw new RuntimeException(e);
//        }
        executeHttpPost(merchantUrl + POST_INVOICE_CANCEL, cancel);
    }

//    private void sendInvoice(Class<?> clazz, String url, Object object) {
//        try {
//            Map<Object, Object> result = executeHttpPost(url, objectMapper.writeValueAsString(object), clazz);
////            logger.info(String.valueOf(objectMapper.readValue(result, clazz)));
//        } catch (JsonProcessingException e) {
//            logger.severe("sendInvoice: " + e.getMessage());
//        }
//    }

    public void getStatus(String invoiceId) {
        HttpGet request = new HttpGet("https://api.monobank.ua/api/merchant/invoice/status?invoiceId=" + invoiceId);
        request.setHeader("X-Token", "uvLCnG4n3VtM3LNkWD0SQ7DCFpowu0UVNDOqZAgbupU8");
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            CloseableHttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(response.getEntity());
                setParams(MonoInvoiceStatus.builder().build(), result, new HashMap<>());
            } else {
                logger.severe("getStatus: " + response.getStatusLine());
            }
        } catch (IOException e) {
            logger.severe("getStatus: " + e);
        }
    }


    private Map<Object, Object> executeHttpPost(String url, Object object) {
        Map<Object, Object> params = new HashMap<>();
        HttpPost request = new HttpPost(url);
        request.setHeader("X-Token", "uvLCnG4n3VtM3LNkWD0SQ7DCFpowu0UVNDOqZAgbupU8");
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            StringEntity entity = new StringEntity(mapper.writeValueAsString(object));
            request.setEntity(entity);
            CloseableHttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                System.out.println(("executeHttpPost response: " + response.getStatusLine()));
            }
            String result = EntityUtils.toString(response.getEntity());
            setParams(object, result, params);
            System.out.println(params);
        } catch (IOException e) {
            System.out.println(("executeHttpPost: " + e));
//            params.setError(false, e.getMessage());
        }
        return params;
    }

    public List<MonoReceiver> getReceiverList() {
        Result receivers = null;
        HttpGet request = new HttpGet(merchantUrl + GET_LIST);
        request.setHeader("X-Token", "uvLCnG4n3VtM3LNkWD0SQ7DCFpowu0UVNDOqZAgbupU8");
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            CloseableHttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(response.getEntity());
                receivers = mapper.readValue(result, new TypeReference<Result>() {
                });
            } else {
                logger.severe("executeHttpGet: " + response.getStatusLine());
            }
        } catch (IOException e) {
            logger.severe("executeHttpGet: " + e);
        }
        return receivers != null ? receivers.getList() : new ArrayList<>();
    }

    public List<MonoSubmerchant> getSubmerchantList() {
        ResultSubmerchant submerchants = null;
        HttpGet request = new HttpGet(merchantUrl + GET_LIST_MERCHANT);
        request.setHeader("X-Token", "uvLCnG4n3VtM3LNkWD0SQ7DCFpowu0UVNDOqZAgbupU8");
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            CloseableHttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(response.getEntity());
                logger.info(result);
                submerchants = mapper.readValue(result, new TypeReference<ResultSubmerchant>() {
                });
            } else {
                logger.severe("executeHttpGet: " + response.getStatusLine());
            }
        } catch (IOException e) {
            logger.severe("executeHttpGet: " + e);
        }
        return submerchants != null ? submerchants.getList() : new ArrayList<>();
    }

    private void setParams(Object obj, String result, Map<Object, Object> params) {
        System.out.println(result);
        try {
            if (obj.getClass().equals(MonoInvoice.class)) {
                MonoInvoiceResponse invoiceResp = mapper.readValue(result, MonoInvoiceResponse.class);
                System.out.println(obj.getClass().getSimpleName() + ": " + invoiceResp);
                params.put("invoiceId", invoiceResp.getInvoiceId());
                params.put("pageUrl", invoiceResp.getPageUrl());
            } else if (obj.getClass().equals(MonoInvoiceCancel.class)) {
                MonoCancelResponse cancelResp = mapper.readValue(result, MonoCancelResponse.class);
                System.out.println(obj.getClass().getSimpleName() + ": " + cancelResp);
                params.put("cancelStatus", cancelResp.getStatus());
            } else if (obj.getClass().equals(MonoInvoiceStatus.class)) {
                MonoInvoiceStatus monoStatus = mapper.readValue(result, MonoInvoiceStatus.class);
                System.out.println(obj.getClass().getSimpleName() + ": " + monoStatus);
                params.put("invoiceStatus", monoStatus.getStatus());
            }
        } catch (JsonProcessingException e) {
            System.out.println("setParams: " + e);
//            params.setError(false, e.getMessage());
        }
    }

    public static void main(String[] args) {
        MonoMerchant merchant = new MonoMerchant(Logger.getLogger("mono"));
//        merchant.getReceiverList();
//        merchant.getSubmerchantList();
        merchant.createInvoice(MonoInvoice.builder()
                .amount(4200)
                .merchantPaymInfo(MonoMerchantPaymInfo.builder()
                        .reference("84d0070ee4e44667b31371d8f8813947")
                        .basketOrder(Arrays.asList(MonoBasketItem.builder()
                                .name("Табурет")
                                .qty(2)
                                .sum(2100)
                                .total(4200)
                                .splitReceiverId("0a8637b3bccb42aa93fdeb791b8b58e8")
                                .build()))
                        .build())
                .validity(3600)
                .build());
//        merchant.getStatus("250408EedLLzZpkWT6ab");
//        merchant.cancelInvoice(MonoInvoiceCancel.builder()
////                .invoiceId(resp.getInvoiceId())
//                .invoiceId("25040297yzd9pjcNabow")
//                .build());
    }


}
