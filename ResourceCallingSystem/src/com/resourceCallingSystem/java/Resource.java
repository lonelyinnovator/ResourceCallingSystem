package com.resourceCallingSystem.java;

import java.util.Objects;

public class Resource {
	private String code;
	private String name;
	private float size;
	private String modifiedDate;
	private String type;
	private String suffix;

	public Resource(String iniCode, String iniName, float iniSize, String iniDate, String iniType, String iniSuffix){
		code = iniCode;
		name = iniName;
		size = iniSize;
		modifiedDate = iniDate;
		type = iniType;
		suffix = iniSuffix;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Override
	public String toString(){
		return getCode() + " " + getName() + " " + String.valueOf(getSize()) + " " + getModifiedDate() + " " + getType()
				+ " " + getSuffix();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Resource resource = (Resource) o;
		return Objects.equals(code, resource.code);
	}
}
