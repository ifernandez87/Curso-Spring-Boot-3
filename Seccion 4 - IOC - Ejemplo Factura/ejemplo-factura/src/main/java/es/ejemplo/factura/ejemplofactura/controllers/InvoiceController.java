package es.ejemplo.factura.ejemplofactura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ejemplo.factura.ejemplofactura.models.Client;
import es.ejemplo.factura.ejemplofactura.models.Invoice;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private Invoice invoice;

    @GetMapping("detail")
    public Invoice detail() {
        Client c = Client.builder().name(invoice.getClient().getName()).lastname(invoice.getClient().getLastname())
                .build();
        Invoice i = Invoice.builder()
                .client(c)
                .description(invoice.getDescription())
                .items(invoice.getItems())
                .build();
        return i;
    }

}
