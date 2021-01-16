package com.gi.builmanager.interfaces.web;

import com.gi.buildman.application.ExpenseService;
import com.gi.buildman.domain.model.billing.BillingRepository;
import com.gi.buildman.domain.model.expense.ExpenseItem;
import com.gi.buildman.domain.model.expense.ExpenseRepository;
import com.gi.buildman.domain.model.expenseconfig.ExpenseItemRepository;
import com.gi.builmanager.interfaces.dto.BillingDto;
import com.gi.builmanager.interfaces.dto.ExpenseDto;
import com.gi.builmanager.interfaces.dto.ExpenseItemDto;
import com.gi.builmanager.interfaces.dto.ExpenseItemValueDto;
import com.gi.builmanager.interfaces.mapper.BillingWebMapper;
import com.gi.builmanager.interfaces.mapper.ExpenseItemValueWebMapper;
import com.gi.builmanager.interfaces.mapper.ExpenseItemWebMapper;
import com.gi.builmanager.interfaces.mapper.ExpenseWebMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/gasto-comun")
@CrossOrigin(origins = {"*"})
public class GastoComunController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GastoComunController.class);

    @Autowired
    private ExpenseWebMapper expenseWebMapper;
    @Autowired
    private BillingWebMapper billingWebMapper;
    @Autowired
    private ExpenseItemWebMapper expenseItemWebMapper;
    @Autowired
    private ExpenseItemValueWebMapper expenseItemValueWebMapper;

    @Autowired
    private ExpenseService expenseService;
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private BillingRepository billingRepository;
    @Autowired
    private ExpenseItemRepository expenseItemRepository;

    @PostMapping("/cerrar")
    public ExpenseDto terminateOpenedExpense() {
        expenseService.terminateOpenedExpense();
        return expenseWebMapper.toDto(expenseRepository.retrieveCurrentExpense());
    }

    @PostMapping("/prorratear")
    public List<BillingDto> generateDebt() {
        expenseService.generateDebt();
        return billingRepository.retrieveCurrentPeriodBilling().stream()
                .map(billing -> billingWebMapper.toDto(billing))
                .collect(Collectors.toList());
    }

    @GetMapping("/abierto")
    public ExpenseDto retrieveOpenedExpense() {
        return expenseWebMapper.toDto(expenseRepository.retrieveOpenedExpense());
    }

    @PostMapping("/")
    public ExpenseDto updateExpense(@RequestBody ExpenseDto expenseDto){
        List<ExpenseItem> expenseItemList = expenseDto.getExpenseItemList().stream()
                .map(expenseItemDto -> expenseItemValueWebMapper.toModel(expenseItemDto))
                .collect(Collectors.toList());
        expenseService.updateExpense(expenseDto.getId(), expenseItemList);
        return expenseWebMapper.toDto(expenseRepository.retrieveOpenedExpense());
    }

    @GetMapping("/item/{tipo}")
    public List<ExpenseItemDto> getAllItems(@PathVariable String tipo){

        List<com.gi.buildman.domain.model.expenseconfig.ExpenseItem> expenseItems = expenseItemRepository.allExtraordinary();
        return expenseItems.stream()
                .map(expenseItem -> expenseItemWebMapper.toDto(expenseItem))
                .collect(Collectors.toList());
    }

    @GetMapping("/plantilla/")
    public List<ExpenseItemValueDto> getPlantillaGastosOrdinarios(){
        return expenseRepository.retrieveOrdinaryExpenses().stream()
                .map(expenseItem -> expenseItemValueWebMapper.toDto(expenseItem))
                .collect(Collectors.toList());
    }

    @GetMapping("/periodo-actual/")
    public LocalDate getPeriodoActual(){
        return expenseRepository.retrieveCurrentExpense().getDetails().getPeriod();
    }

}
