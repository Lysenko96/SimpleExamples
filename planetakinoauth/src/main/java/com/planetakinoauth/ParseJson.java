package com.planetakinoauth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.planetakinoauth.model.OrderImportInputDto;

public class ParseJson {

    private static String json = "{\n" +
            "  \"lineItems\": [\n" +
            "    {\n" +
            "      \"type\": \"product\",\n" +
            "      \"hasAccruedBonuses\": true,\n" +
            "      \"discountAllocations\": [\n" +
            "        {\n" +
            "          \"discountId\": 0,\n" +
            "          \"redeemCode\": \"string\",\n" +
            "          \"used\": true,\n" +
            "          \"appliedManualDiscount\": true,\n" +
            "          \"allocatedAmount\": {\n" +
            "            \"amount\": 0,\n" +
            "            \"currencyCode\": \"string\"\n" +
            "          },\n" +
            "          \"tmpDiscountApplicationId\": \"string\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"totalRefunded\": {\n" +
            "        \"amount\": 0,\n" +
            "        \"currencyCode\": \"string\"\n" +
            "      },\n" +
            "      \"payWithBonuses\": true,\n" +
            "      \"canPayWithBonuses\": true,\n" +
            "      \"appliedManualDiscount\": true,\n" +
            "      \"subtotalPrice\": {\n" +
            "        \"amount\": 0,\n" +
            "        \"currencyCode\": \"string\"\n" +
            "      },\n" +
            "      \"totalPrice\": {\n" +
            "        \"amount\": 0,\n" +
            "        \"currencyCode\": \"string\"\n" +
            "      },\n" +
            "      \"totalDiscounted\": {\n" +
            "        \"amount\": 0,\n" +
            "        \"currencyCode\": \"string\"\n" +
            "      },\n" +
            "      \"bonusesPrice\": {\n" +
            "        \"amount\": 0,\n" +
            "        \"currencyCode\": \"string\"\n" +
            "      },\n" +
            "      \"serviceFee\": {\n" +
            "        \"amount\": 0,\n" +
            "        \"currencyCode\": \"string\"\n" +
            "      },\n" +
            "      \"serviceFeeDiscounted\": {\n" +
            "        \"amount\": 0,\n" +
            "        \"currencyCode\": \"string\"\n" +
            "      },\n" +
            "      \"serviceFeeTotalPrice\": {\n" +
            "        \"amount\": 0,\n" +
            "        \"currencyCode\": \"string\"\n" +
            "      },\n" +
            "      \"serviceFeeTotalTax\": {\n" +
            "        \"amount\": 0,\n" +
            "        \"currencyCode\": \"string\"\n" +
            "      },\n" +
            "      \"serviceFeeTaxType\": \"vat_20_ua\",\n" +
            "      \"serviceFeeTaxRate\": 100,\n" +
            "      \"lineItemUnitPrice\": {\n" +
            "        \"amount\": 0,\n" +
            "        \"currencyCode\": \"string\"\n" +
            "      },\n" +
            "      \"lineItemSubtotalPrice\": {\n" +
            "        \"amount\": 0,\n" +
            "        \"currencyCode\": \"string\"\n" +
            "      },\n" +
            "      \"lineItemTotalPrice\": {\n" +
            "        \"amount\": 0,\n" +
            "        \"currencyCode\": \"string\"\n" +
            "      },\n" +
            "      \"lineItemTotalTax\": {\n" +
            "        \"amount\": 0,\n" +
            "        \"currencyCode\": \"string\"\n" +
            "      },\n" +
            "      \"lineItemDiscounted\": {\n" +
            "        \"amount\": 0,\n" +
            "        \"currencyCode\": \"string\"\n" +
            "      },\n" +
            "      \"lineItemTaxType\": \"vat_20_ua\",\n" +
            "      \"lineItemTaxRate\": 100,\n" +
            "      \"importData\": {\n" +
            "        \"id\": \"string\",\n" +
            "        \"source\": \"dream_town\"\n" +
            "      },\n" +
            "      \"cinemaHallId\": 0,\n" +
            "      \"cinemaId\": 0,\n" +
            "      \"movieId\": 0,\n" +
            "      \"quantity\": 0,\n" +
            "      \"sessionId\": 0,\n" +
            "      \"productSku\": \"string\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"liqpayOrderId\": \"string\",\n" +
            "  \"pkOrderId\": \"string\",\n" +
            "  \"customerId\": 0,\n" +
            "  \"cinemaId\": 1,\n" +
//            "  \"appType\": \"online\",\n" +
            "  \"typeOfPayments\": [\n" +
            "    \"CASH\"\n" +
            "  ],\n" +
            "  \"merchantId\": 1,\n" +
            "  \"pointOfSaleId\": 1,\n" +
            "  \"discountApplications\": [\n" +
            "    {\n" +
            "      \"used\": true,\n" +
            "      \"appliedManualDiscount\": true,\n" +
            "      \"discountId\": 0,\n" +
            "      \"redeemCode\": \"string\",\n" +
            "      \"allocationMethod\": \"across\",\n" +
            "      \"discountMethod\": \"code\",\n" +
            "      \"value\": {\n" +
            "        \"amount\": 0,\n" +
            "        \"currencyCode\": \"string\"\n" +
            "      },\n" +
            "      \"tmpId\": \"string\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"subtotalPrice\": {\n" +
            "    \"amount\": 0,\n" +
            "    \"currencyCode\": \"string\"\n" +
            "  },\n" +
            "  \"totalPrice\": {\n" +
            "    \"amount\": 0,\n" +
            "    \"currencyCode\": \"string\"\n" +
            "  },\n" +
            "  \"totalDiscounted\": {\n" +
            "    \"amount\": 0,\n" +
            "    \"currencyCode\": \"string\"\n" +
            "  },\n" +
            "  \"bonusesPrice\": {\n" +
            "    \"amount\": 0,\n" +
            "    \"currencyCode\": \"string\"\n" +
            "  },\n" +
            "  \"serviceFee\": {\n" +
            "    \"amount\": 0,\n" +
            "    \"currencyCode\": \"string\"\n" +
            "  },\n" +
            "  \"serviceFeeDiscounted\": {\n" +
            "    \"amount\": 0,\n" +
            "    \"currencyCode\": \"string\"\n" +
            "  },\n" +
            "  \"serviceFeeTotalPrice\": {\n" +
            "    \"amount\": 0,\n" +
            "    \"currencyCode\": \"string\"\n" +
            "  },\n" +
            "  \"serviceFeeTotalTax\": {\n" +
            "    \"amount\": 0,\n" +
            "    \"currencyCode\": \"string\"\n" +
            "  },\n" +
            "  \"lineItemsTotalPrice\": {\n" +
            "    \"amount\": 0,\n" +
            "    \"currencyCode\": \"string\"\n" +
            "  },\n" +
            "  \"lineItemsTotalTax\": {\n" +
            "    \"amount\": 0,\n" +
            "    \"currencyCode\": \"string\"\n" +
            "  },\n" +
            "  \"lineItemsDiscounted\": {\n" +
            "    \"amount\": 0,\n" +
            "    \"currencyCode\": \"string\"\n" +
            "  },\n" +
            "  \"totalRefunded\": {\n" +
            "    \"amount\": 0,\n" +
            "    \"currencyCode\": \"string\"\n" +
            "  },\n" +
            "  \"fiscalReceiptId\": \"string\",\n" +
            "  \"fiscalizationError\": \"string\",\n" +
            "  \"fiscalizationErrorAt\": \"2024-12-24T11:30:01.559Z\",\n" +
            "  \"fiscalizedAt\": \"2024-12-24T11:30:01.559Z\",\n" +
            "  \"cardId\": 0,\n" +
            "  \"staffId\": 0,\n" +
            "  \"importData\": {\n" +
            "    \"id\": \"string\",\n" +
            "    \"source\": \"dream_town\"\n" +
            "  }\n" +
            "}";

    private static String jsonLineItems =
       "{\"lineItems\": [ { \"type\": \"product\", \"hasAccruedBonuses\": true, \"discountAllocations\": [ { \"discountId\": 0, \"redeemCode\": \"string\", \"used\": true, \"appliedManualDiscount\": true, \"allocatedAmount\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"tmpDiscountApplicationId\": \"string\" } ], \"totalRefunded\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"payWithBonuses\": true, \"canPayWithBonuses\": true, \"appliedManualDiscount\": true, \"subtotalPrice\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"totalPrice\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"totalDiscounted\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"bonusesPrice\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"serviceFee\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"serviceFeeDiscounted\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"serviceFeeTotalPrice\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"serviceFeeTotalTax\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"serviceFeeTaxType\": \"vat_20_ua\", \"serviceFeeTaxRate\": 100, \"lineItemUnitPrice\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"lineItemSubtotalPrice\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"lineItemTotalPrice\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"lineItemTotalTax\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"lineItemDiscounted\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"lineItemTaxType\": \"vat_20_ua\", \"lineItemTaxRate\": 100, \"importData\": { \"id\": \"string\", \"source\": \"dream_town\" }, \"cinemaHallId\": 0, \"cinemaId\": 0, \"movieId\": 0, \"quantity\": 0, \"sessionId\": 0, \"productSku\": \"string\" } ]}";
    private static String jsonAllocated = " {\n" +
            "                        \"amount\": 1," +
            "                        \"currencyCode\": \"string\"" +
            "                    }";

    private static String result = " { \"type\": \"product\", \"hasAccruedBonuses\": true, \"discountAllocations\": [ { \"discountId\": 0, \"redeemCode\": \"string\", \"used\": true, \"appliedManualDiscount\": true, \"allocatedAmount\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"tmpDiscountApplicationId\": \"string\" } ], \"totalRefunded\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"payWithBonuses\": true, \"canPayWithBonuses\": true, \"appliedManualDiscount\": true, \"subtotalPrice\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"totalPrice\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"totalDiscounted\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"bonusesPrice\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"serviceFee\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"serviceFeeDiscounted\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"serviceFeeTotalPrice\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"serviceFeeTotalTax\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"serviceFeeTaxType\": \"vat_20_ua\", \"serviceFeeTaxRate\": 100, \"lineItemUnitPrice\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"lineItemSubtotalPrice\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"lineItemTotalPrice\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"lineItemTotalTax\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"lineItemDiscounted\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"lineItemTaxType\": \"vat_20_ua\", \"lineItemTaxRate\": 100, \"importData\": { \"id\": \"string\", \"source\": \"dream_town\" }, \"cinemaHallId\": 0, \"cinemaId\": 0, \"movieId\": 0, \"quantity\": 0, \"sessionId\": 0, \"productSku\": \"string\" } ], \"liqpayOrderId\": \"string\", \"pkOrderId\": \"string\", \"customerId\": 0, \"cinemaId\": 1, \"appType\": \"online\", \"typeOfPayments\": [ \"CASH\" ], \"merchantId\": 1, \"pointOfSaleId\": 1, \"discountApplications\": [ { \"used\": true, \"appliedManualDiscount\": true, \"discountId\": 0, \"redeemCode\": \"string\", \"allocationMethod\": \"across\", \"discountMethod\": \"code\", \"value\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"tmpId\": \"string\" } ], \"subtotalPrice\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"totalPrice\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"totalDiscounted\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"bonusesPrice\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"serviceFee\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"serviceFeeDiscounted\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"serviceFeeTotalPrice\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"serviceFeeTotalTax\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"lineItemsTotalPrice\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"lineItemsTotalTax\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"lineItemsDiscounted\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"totalRefunded\": { \"amount\": 0, \"currencyCode\": \"string\" }, \"fiscalReceiptId\": \"string\", \"fiscalizationError\": \"string\", \"fiscalizationErrorAt\": \"2024-12-24T11:30:01.559Z\", \"fiscalizedAt\": \"2024-12-24T11:30:01.559Z\", \"cardId\": 0, \"staffId\": 0, \"importData\": { \"id\": \"string\", \"source\": \"dream_town\" } ";

    private static String res = "    [\n" +
            "        {\n" +
            "          \"discountId\": 1,\n" +
            "          \"redeemCode\": \"string\",\n" +
            "          \"used\": true,\n" +
            "          \"appliedManualDiscount\": true,\n" +
            "          \"allocatedAmount\": {\n" +
            "            \"amount\": 0,\n" +
            "            \"currencyCode\": \"string\"\n" +
            "          },\n" +
            "          \"tmpDiscountApplicationId\": \"string\"\n" +
            "        }\n" +
            "      ]";

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        //           OrderImportInputDto orderImportInputDto =  mapper.readValue(result, OrderImportInputDto.class);
        OrderImportInputDto orderImportInputDto = null;
//        List<OrderLineItemDiscountAllocationInputDto> orderImportInputDto = null;
        try {
//            orderImportInputDto = mapper.readValue(res, new TypeReference<>() {});
            orderImportInputDto = mapper.readValue(json, OrderImportInputDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
//            OrderLineItemDiscountAllocationInputDto orderImportInputDto =  mapper.readValue(jsonAllocated, OrderLineItemDiscountAllocationInputDto.class);
//            AllocatedAmount allocatedAmount = mapper.readValue(jsonAllocated, AllocatedAmount.class);
//        OrderImportInputDto d = new OrderImportInputDto();
//        d.setAppType(null);
        System.out.println(orderImportInputDto);
    }
}
