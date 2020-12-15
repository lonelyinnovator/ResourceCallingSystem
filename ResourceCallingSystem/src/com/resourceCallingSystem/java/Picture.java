package com.resourceCallingSystem.java;

import java.util.Date;

public class Picture extends Resource {
	private String pixel;

	public Picture(String iniCode, String iniName, float iniSize, String iniDate, String iniType, String iniSuffix, String iniPixel) {
		super(iniCode, iniName, iniSize, iniDate, iniType, iniSuffix);
		pixel = iniPixel;
	}

	public String getPixel() {
		return pixel;
	}

	public void setPixel(String pixel) {
		this.pixel = pixel;
	}

	@Override
	public String toString(){
		return super.toString() + " " + getPixel();
	}
}
