package com.gi.builmanager.infrastructure.mybatis;

import com.gi.builmanager.infrastructure.mybatis.type.BillingMap;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Mapper
public interface BillingSqlMapper {

    List<BillingMap> billingsByPeriod(LocalDate period);
}
