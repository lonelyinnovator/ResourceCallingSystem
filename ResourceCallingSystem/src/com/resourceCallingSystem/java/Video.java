package com.resourceCallingSystem.java;



public class Video extends Resource {
	private String playTime;
	private float frame;

	public Video(String iniCode, String iniName, float iniSize, String iniDate, String iniType, String iniSuffix, String iniPlayTime, float iniFrame) {
		super(iniCode, iniName, iniSize, iniDate, iniType, iniSuffix);
		playTime = iniPlayTime;
		frame = iniFrame;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public float getFrame() {
		return frame;
	}

	public void setFrame(float frame) {
		this.frame = frame;
	}
}
