package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.entity.DemoEntity;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;

/**
 * @author chenlingl
 * @version 1.0
 * @date 2021/11/24 11:27
 */
public interface DemoMapper extends CommonInsertMapper<DemoEntity> {
    @InsertProvider(type= SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true, keyProperty="record.id")
    int insert(InsertStatementProvider<DemoEntity> insertStatement);

}
