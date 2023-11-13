package com.example.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//duplicate InventoryResponse because no access to class in inventoryservice
public class InventoryResponse {

    private String skuCode;
    private boolean isInStock;
}
