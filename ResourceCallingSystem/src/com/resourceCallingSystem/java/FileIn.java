package com.resourceCallingSystem.java;
import java.io.*;
/**
 * @author 沈佳军
 * @description Get data from the file. Use the singletonInstance pattern.
 * @date 2020/11/14
 */
public class FileIn {
    private static FileIn singletonInstance;
    /**
     * @param
     * @return
     * @description The constructor of the FileIn.
     */
    private FileIn(){

    }
    /**
     * @param
     * @return FileIn
     * @description Use singletonInstance to only create one instance of the class.
     */
    public static FileIn getSingletonInstance(){
        if(singletonInstance == null){
            singletonInstance = new FileIn();
        }
        return singletonInstance;
    }
    /***
     * @param fileName
     * @return String[][]
     * @description Get data from the file.
     */
    public String[][] fileInput(String fileName) throws IOException {
        String text;
        String [][] str = new String[20][];
        int cnt = 0;
        BufferedReader fileIn = new BufferedReader(new FileReader(fileName));
        while ((text = fileIn.readLine()) != null){
             str[cnt++] = text.split("\\s+");
        }
        fileIn.close();
        return str;
    }
}
