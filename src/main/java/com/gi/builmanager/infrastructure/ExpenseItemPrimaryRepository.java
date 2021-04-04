package com.gi.builmanager.infrastructure;

import com.gi.builmanager.domain.model.expenseconfig.ExpenseItem;
import com.gi.builmanager.domain.model.expenseconfig.ExpenseItemRepository;
import com.gi.builmanager.infrastructure.hibernate.repository.ItemGastoComunRepository;
import com.gi.builmanager.infrastructure.hibernate.mapper.ExpenseItemMapper;
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
    public Integer save(ExpenseItem expenseItem) {
        itemGastoComunRepository.save(expenseItemMapper.toRepository(expenseItem));
        return 1;
    }

    @Override
    public Integer saveAll(List<ExpenseItem> aggregate) {
        return null;
    }

    @Override
    public List<ExpenseItem> allExtraordinary() {
        return itemGastoComunRepository.findAllByTipo("extraordinario").stream()
                .map(itemGastoComun -> expenseItemMapper.fromRepositoryType(itemGastoComun))
                .collect(Collectors.toList());
    }
}
