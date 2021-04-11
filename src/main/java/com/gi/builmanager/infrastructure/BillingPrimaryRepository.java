package com.gi.builmanager.infrastructure;

import com.gi.builmanager.domain.model.billing.Billing;
import com.gi.builmanager.domain.model.billing.BillingRepository;
import com.gi.builmanager.domain.shared.RepositoryHelper;
import com.gi.builmanager.infrastructure.hibernate.entity.EstadoCuenta;
import com.gi.builmanager.infrastructure.hibernate.entity.GastoComun;
import com.gi.builmanager.infrastructure.hibernate.entity.Unidad;
import com.gi.builmanager.infrastructure.hibernate.mapper.helper.GastoComunEntityHelper;
import com.gi.builmanager.infrastructure.hibernate.mapper.helper.UnidadEntityHelper;
import com.gi.builmanager.infrastructure.hibernate.repository.EstadoCuentaRepository;
import com.gi.builmanager.infrastructure.hibernate.repository.GastoComunRepository;
import com.gi.builmanager.infrastructure.hibernate.mapper.BillingMapper;
import com.gi.builmanager.infrastructure.hibernate.repository.UnidadRepository;
import com.gi.builmanager.infrastructure.mybatis.BillingSqlMapper;
import com.gi.builmanager.infrastructure.mybatis.type.BillingMap;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class BillingPrimaryRepository extends BillingRepository implements InitializingBean {

    @Autowired
    private BillingMapper billingMapper;

    @Autowired
    private BillingSqlMapper billingSqlMapper;
    @Autowired
    private EstadoCuentaRepository estadoCuentaRepository;
    @Autowired
    private GastoComunRepository gastoComunRepository;
    @Autowired
    private UnidadRepository unidadRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        RepositoryHelper.SourceId<Integer> sourceIdGastoComun = domain -> ((Billing)domain).getDetails().getExpenseId();
        RepositoryHelper.SourceId<Integer> sourceIdUnidad = domain -> ((Billing)domain).getDetails().getMainPropertyId();

        RepositoryHelper.Action<GastoComun> actionGastoComun = (source, target) -> ((EstadoCuenta)target).setGastoComun(source);
        RepositoryHelper.Action<Unidad> actionUnidad = (source, target) -> ((EstadoCuenta)target).setUnidad(source);

        super.addHelper(GastoComun.class, new GastoComunEntityHelper(gastoComunRepository, sourceIdGastoComun, actionGastoComun));
        super.addHelper(Unidad.class, new UnidadEntityHelper(unidadRepository, sourceIdUnidad, actionUnidad));
    }

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
    public List<BillingMap> getBillingByPeriodV2(LocalDate period) {
        return billingSqlMapper.billingsByPeriod(period);
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
        super.startPersistence();
        estadoCuentaRepository.saveAll(aggregate.stream()
                .map(billing -> {
                    EstadoCuenta estadoCuenta = billingMapper.toRepository(billing);
                    super.fillData(estadoCuenta, billing);
                    return estadoCuenta;
                })
                .collect(Collectors.toList())
        );
        return 1;
    }

}
