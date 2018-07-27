package com.uas.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 *测试数据源创建
 * */
@RestController
public class QueryController {

    private  static final Logger logger= Logger.getLogger(QueryController.class);

    @Autowired
    private JdbcTemplate  jdbcTemplate;
    @GetMapping("/getEmployee")
    public List<Map<String,Object>> get(){
          return jdbcTemplate.queryForList("select  em_code,em_name from  employee ",new Object[]{});
    }

}
