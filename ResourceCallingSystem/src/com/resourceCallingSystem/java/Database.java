package com.resourceCallingSystem.java;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 沈佳军
 * @description A database has many data. It can add data and print data to the file.
 * @date 2020/11/14
 */
public class Database {
    private UserList userList = new UserList();
    private ResourceCatalog resourceCatalog;

    /**
     * @param
     * @return
     * @description The constructor of the database.
     */
    public Database() {
        addData();
        printData();
    }

    /**
     * @param
     * @return UserList
     * @description Get the userList in the database.
     */
    public UserList getUserList() {
        return this.userList;
    }

    /**
     * @param
     * @return ResourceCatalog
     * @description Get the resourceCatalog in the database.
     */
    public ResourceCatalog getResourceCatalog() {
        return this.resourceCatalog;
    }

    /**
     * @param
     * @return void
     * @description Get data from the file and add them to the database.
     */
    public void addData() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateFormat = simpleDateFormat.format(date);
        try {
            String[][] str = FileIn.getSingletonInstance().fileInput("data/dataIn/picture_data.txt");
            int i = 0;
            int j = 0;
            Picture p1 = new Picture(str[i][j++], str[i][j++], Float.parseFloat(str[i][j++]),
                    dateFormat, str[i][j++], str[i][j++], str[i++][j++]);
            j = 0;
            Picture p2 = new Picture(str[i][j++], str[i][j++], Float.parseFloat(str[i][j++]),
                    dateFormat, str[i][j++], str[i][j++], str[i++][j++]);
            str = FileIn.getSingletonInstance().fileInput("data/dataIn/music_data.txt");
            i = 0;
            j = 0;
            Music m1 = new Music(str[i][j++], str[i][j++], Float.parseFloat(str[i][j++]),
                    dateFormat, str[i][j++], str[i][j++], str[i][j++], str[i++][j++]);
            j = 0;
            Music m2 = new Music(str[i][j++], str[i][j++], Float.parseFloat(str[i][j++]),
                    dateFormat, str[i][j++], str[i][j++], str[i][j++], str[i++][j++]);
            j = 0;
            Music m3 = new Music(str[i][j++], str[i][j++], Float.parseFloat(str[i][j++]),
                    dateFormat, str[i][j++], str[i][j++], str[i][j++], str[i++][j++]);
            j = 0;
            str = FileIn.getSingletonInstance().fileInput("data/dataIn/document_data.txt");
            i = 0;
            j = 0;
            Document d1 = new Document(str[i][j++], str[i][j++], Float.parseFloat(str[i][j++]),
                    dateFormat, str[i][j++], str[i][j++], Integer.parseInt(str[i++][j++]));
            j = 0;
            Document d2 = new Document(str[i][j++], str[i][j++], Float.parseFloat(str[i][j++]),
                    dateFormat, str[i][j++], str[i][j++], Integer.parseInt(str[i++][j++]));
            str = FileIn.getSingletonInstance().fileInput("data/dataIn/video_data.txt");
            i = 0;
            j = 0;
            Video v1 = new Video(str[i][j++], str[i][j++], Float.parseFloat(str[i][j++]),
                    dateFormat, str[i][j++], str[i][j++], str[i][j++], Float.parseFloat(str[i++][j++]));
            j = 0;
            Video v2 = new Video(str[i][j++], str[i][j++], Float.parseFloat(str[i][j++]),
                    dateFormat, str[i][j++], str[i][j++], str[i][j++], Float.parseFloat(str[i++][j++]));
            j = 0;
            Video v3 = new Video(str[i][j++], str[i][j++], Float.parseFloat(str[i][j++]),
                    dateFormat, str[i][j++], str[i][j++], str[i][j++], Float.parseFloat(str[i++][j++]));
            Display display1 = new Display(p1, 1);
            Display display2 = new Display(m1, 1);
            Display display3 = new Display(p2, 1);
            Display display4 = new Display(v1, 1);
            Display display5 = new Display(v3, 1);
            Display display6 = new Display(d2, 1);
            Display display7 = new Display(v2, 1);
            Display display8 = new Display(m2, 1);
            Display display9 = new Display(d1, 1);
            Display display10 = new Display(m3, 1);
            this.resourceCatalog = new ResourceCatalog();
            this.resourceCatalog.addResource(display1.getResource());
            this.resourceCatalog.addResource(display2.getResource());
            this.resourceCatalog.addResource(display3.getResource());
            this.resourceCatalog.addResource(display4.getResource());
            this.resourceCatalog.addResource(display5.getResource());
            this.resourceCatalog.addResource(display6.getResource());
            this.resourceCatalog.addResource(display7.getResource());
            this.resourceCatalog.addResource(display8.getResource());
            this.resourceCatalog.addResource(display9.getResource());
            this.resourceCatalog.addResource(display10.getResource());
            str = FileIn.getSingletonInstance().fileInput("data/dataIn/user_data.txt");
            i = 0;
            j = 0;
            User user1 = new User(str[i][j++], str[i][j++], str[i++][j++], (Calling) null);
            this.userList.addUser(user1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param
     * @return void
     * @description Print data from the database to the file.
     */
    public void printData() {
        try {
            FileOut fileOut = new FileOut("data/dataOut/resource_data.txt");
            for (Resource resource : resourceCatalog) {
                fileOut.dataOutput(resource.toString());
            }
            fileOut.getFileOut().close();
            fileOut = new FileOut("data/dataOut/user_data.txt");
            for (User user : userList) {
                fileOut.dataOutput(user.toString());
            }
            fileOut.getFileOut().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
