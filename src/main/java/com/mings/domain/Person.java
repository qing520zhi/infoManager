package com.mings.domain;

/**
 * @program: infoManager
 * @description: Student和Teacher的父类
 * @author: mings
 * @create: 2025-11-06 10:53
 **/
public class Person {
	private String id;
	private String name;
	private int age;
	private String birthday;

	// 无参构造方法
	public Person() {
	}

	// 有参构造方法
	public Person(String id, String name, int age, String birthday) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", age='" + age + '\'' +
				", birthday='" + birthday + '\'' +
				'}';
	}
}
