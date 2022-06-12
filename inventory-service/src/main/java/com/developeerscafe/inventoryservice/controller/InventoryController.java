package com.developeerscafe.inventoryservice.controller;

import com.developeerscafe.inventoryservice.dto.InventoryResponse;
import com.developeerscafe.inventoryservice.model.Inventory;
import com.developeerscafe.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
        return inventoryService.isInStock(skuCode);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Inventory> createUpdateStock(@RequestBody List<Inventory> inventoryStockData) {
        return inventoryService.createUpdateStock(inventoryStockData);
    }
}