package com.resourceCallingSystem.java;

import java.util.Date;

/**
 * @author 沈佳军
 * @description Music is a kind of resource.
 * @date 2020/11/14
 */

public class Music extends Resource {
    private String playTime;
    private String bitRate;

    /**
     * @param iniCode
     * @param iniName
     * @param iniSize
     * @param iniDate
     * @param iniType
     * @param iniSuffix
     * @param iniPlayTime
     * @param iniBitRate
     * @return
     * @description
     */
    public Music(String iniCode, String iniName, float iniSize, String iniDate, String iniType, String iniSuffix, String iniPlayTime, String iniBitRate) {
        super(iniCode, iniName, iniSize, iniDate, iniType, iniSuffix);
        playTime = iniPlayTime;
        bitRate = iniBitRate;
    }

    /**
     * @param
     * @return String
     * @description
     */
    public String getPlayTime() {
        return playTime;
    }

    /**
     * @param playTime
     * @return void
     * @description
     */
    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    /**
     * @param
     * @return java.lang.String
     * @description
     */
    public String getBitRate() {
        return bitRate;
    }

    /**
     * @param bitRate
     * @return void
     * @description
     */
    public void setBitRate(String bitRate) {
        this.bitRate = bitRate;
    }

    /**
     * @param
     * @return java.lang.String
     * @description
     */
    @Override
    public String toString() {
        return super.toString() + " " + getPlayTime() + " " + getBitRate();
    }
}
