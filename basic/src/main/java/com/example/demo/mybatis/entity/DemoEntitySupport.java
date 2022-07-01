package com.example.demo.mybatis.entity;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author chenlingl
 * @version 1.0
 * @date 2021/11/24 11:31
 */
public class DemoEntitySupport {

    public static final DemoEntityTable demoEntityTable = new DemoEntityTable();
    public static final SqlColumn<Integer> id = demoEntityTable.id;
    public static final SqlColumn<Integer> uniqId = demoEntityTable.uniqId;
    public static final SqlColumn<String> name = demoEntityTable.name;

    public static final class DemoEntityTable extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);
        public final SqlColumn<Integer> uniqId = column("uniq_id", JDBCType.INTEGER);
        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        protected DemoEntityTable() {
            super("GeneratedAlways");
        }

    }
}
