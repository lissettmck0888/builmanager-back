package com.gi.builmanager.infrastructure;

import com.gi.builmanager.domain.model.billing.Billing;
import com.gi.builmanager.domain.model.expenseconfig.ExpenseItem;
import com.gi.builmanager.domain.model.expenseconfig.ExpenseItemRepository;
import com.gi.builmanager.infrastructure.hibernate.entity.EstadoCuenta;
import com.gi.builmanager.infrastructure.hibernate.entity.ItemGastoComun;
import com.gi.builmanager.infrastructure.hibernate.repository.ItemGastoComunRepository;
import com.gi.builmanager.infrastructure.mapper.ExpenseItemMapper;
import com.gi.builmanager.infrastructure.mapper.RepositoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExpenseItemPrimaryRepository implements ExpenseItemRepository {

    @Autowired
    private ExpenseItemMapper expenseItemMapper;

    @Autowired
    private ItemGastoComunRepository itemGastoComunRepository;

    @Override
    public ExpenseItem getById(Integer id) {
        return null;
    }

    @Override
    public Integer save(ExpenseItem expenseItem, RepositoryMapper.RepositoryHelper<ExpenseItem, ItemGastoComun> repositoryHelper) {
        itemGastoComunRepository.save(expenseItemMapper.toRepository(expenseItem, repositoryHelper));
        return 1;
    }

    @Override
    public Integer saveAll(List<ExpenseItem> aggregate, RepositoryMapper.RepositoryHelper<ExpenseItem, ItemGastoComun> repositoryHelper) {
        return null;
    }

    @Override
    public List<ExpenseItem> allExtraordinary() {
        return itemGastoComunRepository.findAllByTipo("extraordinario").stream()
                .map(itemGastoComun -> expenseItemMapper.fromRepositoryType(itemGastoComun))
                .collect(Collectors.toList());
    }
}
