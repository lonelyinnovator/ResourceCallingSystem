package com.resourceCallingSystem.java;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 沈佳军
 * @description Print the data to the file.
 * @date 2020/11/14
 */
public class FileOut {
    private static PrintWriter fileOut;
    /**
     * @param fileName
     * @return
     * @description The constructor of the FIleOut.
     */
    public FileOut(String fileName) throws IOException {
        fileOut = new PrintWriter(new FileWriter(fileName), true);
    }
    /**
     * @param str
     * @return void
     * @description Print data to the file.
     */
    public void dataOutput(String str) {
        fileOut.println(str);
    }
    /**
     * @param
     * @return PrintWriter
     * @description Return the instance of the fileOut.
     */
    public PrintWriter getFileOut() {
        return fileOut;
    }
}
