package com.gi.builmanager.infrastructure;

import com.gi.builmanager.domain.model.billing.Billing;
import com.gi.builmanager.domain.model.billing.Transaction;
import com.gi.builmanager.domain.model.billing.TransactionRepository;
import com.gi.builmanager.domain.shared.RepositoryHelper;
import com.gi.builmanager.infrastructure.hibernate.entity.EstadoCuenta;
import com.gi.builmanager.infrastructure.hibernate.entity.GastoComun;
import com.gi.builmanager.infrastructure.hibernate.entity.Movimiento;
import com.gi.builmanager.infrastructure.hibernate.entity.Unidad;
import com.gi.builmanager.infrastructure.hibernate.mapper.helper.GastoComunEntityHelper;
import com.gi.builmanager.infrastructure.hibernate.mapper.helper.UnidadEntityHelper;
import com.gi.builmanager.infrastructure.hibernate.repository.GastoComunRepository;
import com.gi.builmanager.infrastructure.hibernate.repository.MovimientoRepository;
import com.gi.builmanager.infrastructure.hibernate.mapper.TransactionMapper;
import com.gi.builmanager.infrastructure.hibernate.repository.UnidadRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class TransactionPrimaryRepository extends TransactionRepository implements InitializingBean {

    @Autowired
    TransactionMapper transactionMapper;

    @Autowired
    private MovimientoRepository movimientoRepository;
    @Autowired
    private GastoComunRepository gastoComunRepository;
    @Autowired
    private UnidadRepository unidadRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        RepositoryHelper.SourceId<Integer> sourceIdGastoComun = domain -> ((Transaction)domain).getDetails().getExpenseId();
        RepositoryHelper.SourceId<Integer> sourceIdUnidad = domain -> ((Transaction)domain).getDetails().getPropertyId();

        RepositoryHelper.Action<GastoComun> actionGastoComun = (source, target) -> ((Movimiento)target).setGastoComun(source);
        RepositoryHelper.Action<Unidad> actionUnidad = (source, target) -> ((Movimiento)target).setUnidad(source);

        super.addHelper(GastoComun.class, new GastoComunEntityHelper(gastoComunRepository, sourceIdGastoComun, actionGastoComun));
        super.addHelper(Unidad.class, new UnidadEntityHelper(unidadRepository, sourceIdUnidad, actionUnidad));
    }

    @Override
    public List<Transaction> retrieveClosedPeriodPaymentsList() {
        GastoComun last = gastoComunRepository.findUltimoGastoComunCerrado().orElse(null);
        if (Objects.nonNull(last)){
            return movimientoRepository.findByGastoComunAndTipo(last, "Abono").stream()
                    .map(movimiento -> transactionMapper.fromRepositoryType(movimiento))
                    .collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public Transaction getById(Integer id) {
        return null;
    }

    @Override
    public Integer save(Transaction transaction) {
        movimientoRepository.save(transactionMapper.toRepository(transaction));
        return 1;
    }

    @Override
    public Integer saveAll(List<Transaction> transactionList) {
        super.startPersistence();
        movimientoRepository.saveAll(transactionList.stream()
                .map(transaction -> {
                    Movimiento movimiento = transactionMapper.toRepository(transaction);
                    super.fillData(movimiento, transaction);
                    return movimiento;
                })
                .collect(Collectors.toList())
        );
        return 1;
    }

}
