package org.moonzhou.advancedprogramming.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/2/27 09:33
 */
@Slf4j
public class Demo001MapTwoKey {
    private static final String SPLIT_LINE = "---------";

    public static void main(String[] args) {
        jdkWay();

        guavaWay();

        guavaWay2();
    }

    private static void jdkWay() {
        Map<String, Map<String, Integer>> map = new HashMap<>();
        // 存放元素
        Map<String, Integer> workMap = new HashMap<>();
        workMap.put("Jan", 20);
        workMap.put("Feb", 28);
        map.put("Hydra", workMap);

        // 取出元素
        Integer dayCount = map.get("Hydra").get("Jan");

        log.info("jdkWay: {}.", map);
    }

    private static void guavaWay() {
        log.info("\n");

        Table<String, String, Integer> table = HashBasedTable.create();
        // 存放元素
        table.put("Hydra", "Jan", 20);
        table.put("Hydra", "Feb", 28);

        table.put("Trunks", "Jan", 28);
        table.put("Trunks", "Feb", 16);

        // 取出元素
        Integer dayCount = table.get("Hydra", "Feb");
        log.info("guavaWay: {}", table);


        // rowKey或columnKey的集合
        Set<String> rowKeys = table.rowKeySet();
        Set<String> columnKeys = table.columnKeySet();
        log.info("row keys: {}", rowKeys);
        log.info("column keys: {}", columnKeys);

        // value集合
        Collection<Integer> values = table.values();
        log.info("values: {}.", values);
    }

    private static void guavaWay2() {
        log.info("\n");

        Table<String, String, Integer> table = HashBasedTable.create();
        // 存放元素
        table.put("Hydra", "Jan", 20);
        table.put("Hydra", "Feb", 28);
        table.put("Hydra", "Mar", 29);

        table.put("Trunks", "Jan", 28);
        table.put("Trunks", "Feb", 16);

        // 取出元素
        Integer dayCount = table.get("Hydra", "Feb");
        log.info("guavaWay2: {}", table);


        // rowKey或columnKey的集合
        Set<String> rowKeys = table.rowKeySet();
        Set<String> columnKeys = table.columnKeySet();
        log.info("row keys: {}", rowKeys);
        log.info("column keys: {}", columnKeys);

        // value集合
        Collection<Integer> values = table.values();
        log.info("values: {}.", values);

        // key sum
        log.info(SPLIT_LINE);
        for (String key : table.rowKeySet()) {
            Set<Map.Entry<String, Integer>> rows = table.row(key).entrySet();
            int total = 0;
            for (Map.Entry<String, Integer> row : rows) {
                total += row.getValue();
            }
            log.info(key + " sum: " + total);
        }

        // row column convert
        Table<String, String, Integer> table2 = Tables.transpose(table);
        Set<Table.Cell<String, String, Integer>> cells = table2.cellSet();

        log.info(SPLIT_LINE);
        cells.forEach(cell ->
                log.info(cell.getRowKey() + "," + cell.getColumnKey() + ":" + cell.getValue())
        );

        // nest map
        log.info(SPLIT_LINE);
        Map<String, Map<String, Integer>> rowMap = table.rowMap();
        Map<String, Map<String, Integer>> columnMap = table.columnMap();
        log.info("row map: {}", rowMap);
        log.info("column map: {}", columnMap);
    }
}
