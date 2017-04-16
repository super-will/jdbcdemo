package com.will.entity;

/**
 * @author hcguo
 *
 */
public class Student {
	
	   private int Id;
	   
	   private String name;
	   
	   private int age;
	   
	   private String sex;
		
		public int getId() {
			return Id;
		}
		
		public void setId(int id) {
			Id = id;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public int getAge() {
			return age;
		}
		
		public void setAge(int age) {
			this.age = age;
		}
		
		public String getSex() {
			return sex;
		}
		
		public void setSex(String sex) {
			this.sex = sex;
		}
		   
}
