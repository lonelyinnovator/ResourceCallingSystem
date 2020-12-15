package com.resourceCallingSystem.java;

/**
 * @author 沈佳军
 * @description Document is one kind of resource.
 * @date 2020/11/14
 */
public class Document extends Resource {
    private int wordNumber;

    /**
     * @param iniCode
     * @param iniName
     * @param iniSize
     * @param iniDate
     * @param iniType
     * @param iniSuffix
     * @param iniWordNumber
     * @return
     * @description The constructor of the document.
     */
    public Document(String iniCode, String iniName, float iniSize, String iniDate, String iniType, String iniSuffix, int iniWordNumber) {
        super(iniCode, iniName, iniSize, iniDate, iniType, iniSuffix);
        wordNumber = iniWordNumber;
    }

    /**
     * @param
     * @return int
     * @description Get the wordNumber of the document.
     */
    public int getWordNumber() {
        return wordNumber;
    }

    /**
     * @param wordNumber
     * @return void
     * @description Set the wordNumber of the document.
     */
    public void setWordNumber(int wordNumber) {
        this.wordNumber = wordNumber;
    }

    /**
     * @param
     * @return String
     * @description Override toString method.
     */
    @Override
    public String toString() {
        return super.toString() + " " + String.valueOf(getWordNumber());
    }
}
