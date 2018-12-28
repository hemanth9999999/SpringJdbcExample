package com.database.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.Example.JdbcModels.circle;
@Component
public class JdbcDaoImpl<T> {
	
	@Autowired 
	@Qualifier("Template")
	JdbcTemplate template ; 
	
	public java.util.List<Map<String,Object>>  getCircleCount( )
	{ String Sql = "Select count(1) from circle" ; 
	return  template.queryForList	(Sql); 
	}
	
	public String getCircleName( Integer Id )
	{ 
		String Sql = "Select name from Circle where id= ? "; 
		return template.queryForObject(Sql, new Object[] {Id}, String.class) ; 
			
	}
	
	public circle getCircle(Integer id) { 
		String Sql = "select * from circle where id = ? "; 
		return (circle) template.queryForObject(Sql, new Object[] {id}, new CircleMapper()) ;
		
		
	}
	
	public List<circle> getAllCircles(){
		String Sql = "select * from Circle" ; 
		List<circle>c = template.query(Sql, new CircleMapper()) ; 
		return c ; 
	}
	

	public circle putCircle(circle c) { 
		
		String Sql = "insert into circle values (? , ? ) "; 
		Integer ret = template.update(Sql, new Object[] {c.getId(),c.getName()}) ;
		if (ret>0) {
			return c  ;
		}else
		{ 
			return null ; 
		}
		
	}
	
	public static final class CircleMapper implements RowMapper{

		@Override
		public circle mapRow(ResultSet rs, int rowNum) throws SQLException {
			Integer id =rs.getInt("ID") ; 
			String name = rs.getString("Name") ; 
			circle c = new circle(id,name) ; 
			return c ;
			
		} 
		
	}

}
