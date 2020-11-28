package pl.hqbusiness.springboot2.week7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

  private DataSource dataSource;

  @Autowired
  public DBConfig(DataSource dataSource) {
    this.dataSource = dataSource;
  }

//  @Bean
//  public DataSource getDataSource() {
//    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//
//    dataSourceBuilder.url("jdbc:mysql://remotemysql.com:3306/2mw0RlmlyG");
//    dataSourceBuilder.username("2mw0RlmlyG");
//    dataSourceBuilder.password("39He4l1BJc");
//    dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
//
//    return dataSourceBuilder.build();
//  }

  @Bean
  public JdbcTemplate getJdbcTemplate() {
    return new JdbcTemplate(dataSource);
  }
}
