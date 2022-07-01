package com.example.demo.mybatis;

import com.example.demo.mybatis.mapper.DemoMapper;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.insert.render.BatchInsert;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

import static com.example.demo.mybatis.entity.DemoEntitySupport.*;

/**
 * @author chenlingl
 * @version 1.0
 * @date 2021/11/24 9:27
 */
@Component
public class BatchInsertUtil<T> {

    @Resource
    private SessionFactoryConfig sessionFactoryConfig;


    public void batchInsertByExecutorType(Class<T> mapper, List<T> list) throws Exception {
        SqlSession session = sessionFactoryConfig.sqlSessionFactory().openSession(ExecutorType.BATCH);
        DemoMapper simpleMapper = session.getMapper(DemoMapper.class);
        BatchInsert<T> batchInsert = SqlBuilder.insertBatch(list)
                .into(demoEntityTable)
                .map(id).toProperty("id")
                .map(uniqId).toProperty("uniqId")
                .map(name).toProperty("name")
                .build()
                .render(RenderingStrategies.MYBATIS3);
//        batchInsert.insertStatements().forEach(simpleMapper::insert);

        session.commit();
    }
}
