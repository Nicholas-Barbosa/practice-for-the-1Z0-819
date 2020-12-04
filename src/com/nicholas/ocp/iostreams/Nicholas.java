package com.nicholas.ocp.iostreams;

import java.io.Serializable;

public class Nicholas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String zip;

	private Integer age;

	private String country;

	public Nicholas(String name, String zip, Integer age, String country) {
		this.name = name;
		this.zip = zip;
		this.age = age;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public String getZip() {
		return zip;
	}

	public Integer getAge() {
		return age;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "Nicholas [name=" + name + ", zip=" + zip + ", age=" + age + ", country=" + country + "]";
	}

	
}
