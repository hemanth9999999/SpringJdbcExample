package com.Example.jdbcConnection;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource ;

@Configuration
public class JdbcConnection {
	  @Autowired
	  private Environment env;
	  
	  @Bean({ "DerbyDS" })
	  public DataSource getDs() {
		   
		  System.out.println (env.getProperty("url","") + "  " + env.getProperty("driverClass","")) ; 
		  DriverManagerDataSource  ds = new DriverManagerDataSource(); 
		  	 ds.setDriverClassName(env.getProperty("driverClass","")) ; 
		  	 ds.setUrl(env.getProperty("url",""));
		  	 
		  	 return ds ; 
		 }
	  
	  @Bean({"Template"})
	  public JdbcTemplate getAllCircle() { 
		  JdbcTemplate template = new JdbcTemplate(getDs()) ; 
		  return template ; 
	  }
}
