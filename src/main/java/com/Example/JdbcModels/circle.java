package com.Example.JdbcModels;

public class circle {
	int id ; 
	String name ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public circle(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "circle [id=" + id + ", name=" + name + "]";
	} 
	
	

}
