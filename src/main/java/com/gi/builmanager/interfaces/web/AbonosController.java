package com.gi.builmanager.interfaces.web;

import com.gi.builmanager.application.BillingService;
import com.gi.builmanager.interfaces.dto.PaymentDto;
import com.gi.builmanager.interfaces.mapper.TransactionWebMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/abono/")
public class AbonosController {

    @Autowired
    private TransactionWebMapper transactionWebMapper;

    @Autowired
    private BillingService billingService;

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void registrarAbono(@RequestBody PaymentDto paymentDto) {
        billingService.registerPayment(transactionWebMapper.toModel(paymentDto));
    }

    /*@GetMapping(value = "/unidad/{idUnidad}")
    public List<AbonoDto>  listaAbonosPorUnidad(@PathVariable int idUnidad){
        return BuilManagerUtils.convertList(abonosServices.obtenerPagosPorUnidad(idUnidad),
                Abono.class, AbonoDto.class, conversionService);
    }

    @GetMapping(value = "/periodo/{periodo}")
    public List<AbonoDto>  listaAbonosPorPeriodo(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate periodo){
        return BuilManagerUtils.convertList(abonosServices.obtenerPagosPorPeriodo(periodo),
                Abono.class, AbonoDto.class, conversionService);
    }*/


}
