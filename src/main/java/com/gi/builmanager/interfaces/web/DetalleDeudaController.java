package com.gi.builmanager.interfaces.web;

import com.gi.builmanager.domain.model.billing.BillingRepository;
import com.gi.builmanager.infrastructure.mybatis.BillingSqlMapper;
import com.gi.builmanager.infrastructure.mybatis.type.BillingMap;
import com.gi.builmanager.interfaces.dto.BillingDto;
import com.gi.builmanager.interfaces.mapper.BillingWebMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/deuda")
public class DetalleDeudaController {

    @Autowired
    private BillingWebMapper billingWebMapper;

    @Autowired
    private BillingRepository billingRepository;

    /*@GetMapping(value = "/unidad/{idUnidad}")
    //@PreAuthorize(value = "")
    //@PostAuthorize()
    public List<BillingDto> getDetalleByUnidad(@PathVariable int idUnidad) {
        return billingRepository.retrieveCurrentPeriodBilling().stream()
                .map(billing -> billingMapper.toDto(billing))
                .collect(Collectors.toList());
    }*/

    @GetMapping(value = "/periodo/{period}")
    public List<BillingDto> getDetalleByPeriodo(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate period) {
        return billingRepository.getBillingByPeriod(period).stream()
                .map(billing -> billingWebMapper.toDto(billing))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/periodo/{period}/v2")
    public List<BillingMap> getDetalleByPeriodoV2(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate period) {
        return billingRepository.getBillingByPeriodV2(period);
    }
}
