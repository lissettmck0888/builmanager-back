package com.gi.builmanager.infrastructure.mapper;

import com.gi.builmanager.domain.model.billing.Billing;
import com.gi.builmanager.domain.model.billing.BillingDetails;
import com.gi.builmanager.domain.model.billing.BillingId;
import com.gi.builmanager.infrastructure.hibernate.entity.DetalleDeudadUnidad;
import com.gi.builmanager.infrastructure.hibernate.entity.EstadoCuenta;
import com.gi.builmanager.infrastructure.hibernate.repository.GastoComunRepository;
import com.gi.builmanager.infrastructure.hibernate.repository.UnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BillingMapper implements RepositoryMapper<Billing, EstadoCuenta> {

    @Autowired
    private GastoComunRepository gastoComunRepository;
    @Autowired
    private UnidadRepository unidadRepository;

    @Override
    public Billing fromRepositoryType(EstadoCuenta estadoCuenta) {

        return Billing.builder()
                .id(BillingId.builder().id(estadoCuenta.getId()).build())
                .details(BillingDetails.builder()
                        .apportionFactor(estadoCuenta.getFactorProrrateo())
                        .balance(estadoCuenta.getSaldo())
                        .payment(estadoCuenta.getAbonos())
                        .period(estadoCuenta.getGastoComun().getPeriodo())
                        .periodDebt(estadoCuenta.getDeudaInicial())
                        .previousPeriodDebt(estadoCuenta.getMontoAnterior())
                        .mainPropertyId(estadoCuenta.getUnidad().getIdUnidad())
                        .mainPropertyIdentifier(estadoCuenta.getUnidad().getNumero())
                        //.guestFullName(estadoCuenta.get)
                        .build())
                .build();
    }

    @Override
    public EstadoCuenta toRepository(Billing billing) {
        return EstadoCuenta.builder()
                .factorProrrateo(billing.getDetails().getApportionFactor())
                .saldo(billing.getDetails().getBalance())
                .abonos(billing.getDetails().getPayment())
                .gastoComun(gastoComunRepository.findById(billing.getDetails().getExpenseId()).orElseThrow(IllegalArgumentException::new))
                .deudaInicial(billing.getDetails().getPeriodDebt())
                .montoAnterior(billing.getDetails().getPreviousPeriodDebt())
                .unidad(unidadRepository.findById(billing.getDetails().getMainPropertyId()).orElseThrow(IllegalArgumentException::new))
                .build();
    }
}
