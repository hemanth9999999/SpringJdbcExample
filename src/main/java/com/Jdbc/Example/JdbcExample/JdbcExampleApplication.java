package com.Jdbc.Example.JdbcExample;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.Example.JdbcModels.circle;
import com.database.dao.JdbcDaoImpl;
@ComponentScan({"com.database.dao","com.Example.jdbcConnection" , "com.Example.JdbcModels","com.Jdbc.Example.JdbcExample"})
@SpringBootApplication
public class JdbcExampleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JdbcExampleApplication.class, args);
		JdbcDaoImpl bean1 = context.getBean(JdbcDaoImpl.class); 
		Iterator iter = bean1.getCircleCount().iterator();
		Map<String, Integer> first	 = (Map<String , Integer >) iter.next();
		
		Map.Entry<String , Integer > entry = first.entrySet().iterator().next() ; 
		Integer value = entry.getValue();
		  
		System.out.println("value is " + value);
		System.out.println(first.get(entry.getKey())) ; 
		System.out.println(bean1.getCircleName(1));
		System.out.println(bean1.getCircle(1));
		System.out.println(bean1.getAllCircles());
		//System.out.println(bean1.putCircle(new circle(3,"third circle")));

		
		
	}

}

