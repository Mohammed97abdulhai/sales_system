package application.controllers;

import application.dtos.SaleDTO;
import application.dtos.UpdateTransactionDTO;
import application.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static application.util.FormatterUtil.toMap;

@RestController
@RequestMapping("v1/sales")
public class SaleController {

    @Autowired
    SaleService saleService;

    @PostMapping()
    public Object addSale(@RequestBody SaleDTO saleDTO){
        return toMap("sale", saleService.addSale(saleDTO));
    }

    @GetMapping()
    public Object getAllSales(@RequestParam(required = false, name = "page", defaultValue = "0") Integer page,
                              @RequestParam(required = false, name = "limit", defaultValue = "10") Integer limit){
        return toMap("sales" ,saleService.getAllSales(page, limit));
    }

    @PutMapping("/{sale_id}/transaction/{transaction_id}")
    public Object UpdateTransaction(@PathVariable(name = "sale_id") Long saleId,
                                    @PathVariable(name = "transaction_id") Long transId,
                                    @RequestBody UpdateTransactionDTO dto){
        return saleService.updateTransaction(dto, saleId, transId);
    }
}
