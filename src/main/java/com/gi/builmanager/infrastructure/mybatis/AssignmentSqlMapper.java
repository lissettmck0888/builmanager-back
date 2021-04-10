package com.gi.builmanager.infrastructure.mybatis;

import com.gi.builmanager.infrastructure.mybatis.type.AssignmentMap;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface AssignmentSqlMapper {

    List<AssignmentMap> activeAssignments();

}
