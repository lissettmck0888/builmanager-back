package com.gi.builmanager.infrastructure;

import com.gi.builmanager.domain.model.billing.Billing;
import com.gi.builmanager.domain.model.billing.BillingRepository;
import com.gi.builmanager.infrastructure.hibernate.entity.EstadoCuenta;
import com.gi.builmanager.infrastructure.hibernate.entity.GastoComun;
import com.gi.builmanager.infrastructure.hibernate.repository.EstadoCuentaRepository;
import com.gi.builmanager.infrastructure.hibernate.repository.GastoComunRepository;
import com.gi.builmanager.infrastructure.mapper.BillingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class BillingPrimaryRepository implements BillingRepository {

    @Autowired
    private BillingMapper billingMapper;

    @Autowired
    private EstadoCuentaRepository estadoCuentaRepository;
    @Autowired
    private GastoComunRepository gastoComunRepository;

    @Override
    public List<Billing> retrieveCurrentPeriodBilling() {
        GastoComun gastoComun = gastoComunRepository.findByEstado("Actual");

        List<EstadoCuenta> byGastoComun = estadoCuentaRepository.findByGastoComunOrderById(gastoComun);
        return byGastoComun.stream()
                .map(estadoCuenta -> billingMapper.fromRepositoryType(estadoCuenta))
                .collect(Collectors.toList());
    }

    @Override
    public Billing retrieveCurrentPropertyPeriodBilling(Integer propertyId) {
        GastoComun gastoComun = gastoComunRepository.findByEstado("Actual");
        return billingMapper.fromRepositoryType(estadoCuentaRepository.findByGastoComunAndUnidad_idUnidad(gastoComun, propertyId));
    }

    @Override
    public List<Billing> getBillingByPeriod(LocalDate period) {
        GastoComun gastoComun = gastoComunRepository.findByPeriodo(period);
        return estadoCuentaRepository.findByGastoComunOrderById(gastoComun).stream()
                .map(estadoCuenta -> billingMapper.fromRepositoryType(estadoCuenta))
                .collect(Collectors.toList());
    }

    @Override
    public Billing getById(Integer id) {
        EstadoCuenta estadoCuenta = estadoCuentaRepository.findById(id).orElse(null);
        return Objects.nonNull(estadoCuenta) ? billingMapper.fromRepositoryType(estadoCuenta) : null;
    }

    @Override
    public Integer save(Billing aggregate) {
        estadoCuentaRepository.save(billingMapper.toRepository(aggregate));
        return 1;
    }

    @Override
    public Integer saveAll(List<Billing> aggregate) {
        estadoCuentaRepository.saveAll(aggregate.stream()
                .map(billing -> billingMapper.toRepository(billing))
                .collect(Collectors.toList())
        );
        return 1;
    }
}
