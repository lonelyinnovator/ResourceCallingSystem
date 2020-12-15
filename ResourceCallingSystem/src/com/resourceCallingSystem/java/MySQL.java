//package com.milkSystem.java;
//
//import javax.swing.*;
//import java.sql.*;
//import java.util.Date;
//
//public class MySQL {
//    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost:3306/test_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
//    static final String USER = "root";
//    static final String PASS = "root";
//    public MySQL(String start){
//        MySQL mySQL = new MySQL();
//        ProductCatalog productCatalog = new ProductCatalog();
//        UserList userList = new UserList();
//        mySQL.getJellyData(productCatalog);
//        mySQL.getYogurtData(productCatalog);
//        mySQL.getPureMilkData(productCatalog);
//        mySQL.getMilkDrinkData(productCatalog);
//        mySQL.getUserList(userList);
//        LogFrame logFrame = new LogFrame(userList, productCatalog);
//        logFrame.setVisible(true);
//        logFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//    }
//    public MySQL(){
//    }
//    public  void  addUserData(String addUserName, String addPassword, String addEmail) {
//        Connection conn = null;
//        try {
//            // 注册 JDBC 驱动
//            Class.forName(JDBC_DRIVER);
//            // 打开链接
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            PreparedStatement psql;
//            //预处理添加数据，其中有两个参数--“？”
//            psql = conn.prepareStatement("insert into userList (userName,password,email) " + "value(?,?,?)");
//            psql.setString(1, addUserName);
//            psql.setString(2, addPassword);
//            psql.setString(3, addEmail);
//            psql.executeUpdate();           //执行更新
//            conn.close();
//        } catch (SQLException se) {
//            // 处理 JDBC 错误
//            se.printStackTrace();
//        } catch (Exception e) {
//            // 处理 Class.forName 错误
//            e.printStackTrace();
//        } finally {
//            // 关闭资源
//            try {
//                if (conn != null) conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
//        }
//    }
//
//    public void getJellyData(ProductCatalog productCatalog){
//        Date date = new Date();
//        Connection conn = null;
//        Statement stmt = null;
//        try{
//            // 注册 JDBC 驱动
//            Class.forName(JDBC_DRIVER);
//
//            // 打开链接
//            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//
//            // 执行查询
//            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT code, description, price, shelfLife, flavor FROM jerry";
//            ResultSet rs = stmt.executeQuery(sql);
//
//            // 展开结果集数据库
//            while(rs.next()){
//                String code = rs.getString("code");
//                String description = rs.getString("description");
//                float price = rs.getFloat("price");
//                String shelfLife = rs.getString("shelfLife");
//                String flavor = rs.getString("flavor");
//                Jelly jelly = new Jelly(code, description, price, date, shelfLife, flavor);
//                SaleItem saleItem = new SaleItem(jelly, 1);
//                productCatalog.addProduct(saleItem.getProduct());
//            }
//            rs.close();
//            stmt.close();
//            conn.close();
//        }catch(SQLException se){
//            // 处理 JDBC 错误
//            se.printStackTrace();
//        }catch(Exception e){
//            // 处理 Class.forName 错误
//            e.printStackTrace();
//        }finally{
//            // 关闭资源
//            try{
//                if(stmt!=null) stmt.close();
//            }catch(SQLException se2){
//            }// 什么都不做
//            try{
//                if(conn!=null) conn.close();
//            }catch(SQLException se){
//                se.printStackTrace();
//            }
//        }
//    }
//
//
//
//    public void getYogurtData(ProductCatalog productCatalog){
//        Date date = new Date();
//        Connection conn = null;
//        Statement stmt = null;
//        try{
//            // 注册 JDBC 驱动
//            Class.forName(JDBC_DRIVER);
//
//            // 打开链接
//            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//
//            // 执行查询
//            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT code, description, price, shelfLife, type, diluteConcentration  FROM yogurt";
//            ResultSet rs = stmt.executeQuery(sql);
//
//            // 展开结果集数据库
//            while(rs.next()){
//                String code = rs.getString("code");
//                String description = rs.getString("description");
//                float price = rs.getFloat("price");
//                String shelfLife = rs.getString("shelfLife");
//                String type = rs.getString("type");
//                String diluteConcentration = rs.getString("diluteConcentration");
//                Yogurt yogurt = new Yogurt(code, description, price, date, shelfLife, type, diluteConcentration);
//                SaleItem saleItem = new SaleItem(yogurt, 1);
//                productCatalog.addProduct(saleItem.getProduct());
//            }
//            rs.close();
//            stmt.close();
//            conn.close();
//        }catch(SQLException se){
//            se.printStackTrace();
//        }catch(Exception e){
//            // 处理 Class.forName 错误
//            e.printStackTrace();
//        }finally{
//            // 关闭资源
//            try{
//                if(stmt!=null) stmt.close();
//            }catch(SQLException se2){
//            }// 什么都不做
//            try{
//                if(conn!=null) conn.close();
//            }catch(SQLException se){
//                se.printStackTrace();
//            }
//        }
//    }
//
//    public void getPureMilkData(ProductCatalog productCatalog){
//        Date date = new Date();
//        Connection conn = null;
//        Statement stmt = null;
//        try{
//            // 注册 JDBC 驱动
//            Class.forName(JDBC_DRIVER);
//
//            // 打开链接
//            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//
//            // 执行查询
//            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT code, description, price, shelfLife, countryOfOrigin, butterfat, protein  FROM pureMilk";
//            ResultSet rs = stmt.executeQuery(sql);
//
//            // 展开结果集数据库
//            while(rs.next()){
//                String code = rs.getString("code");
//                String description = rs.getString("description");
//                float price = rs.getFloat("price");
//                String shelfLife = rs.getString("shelfLife");
//                String countryOfOrigin = rs.getString("countryOfOrigin");
//                String butterfat = rs.getString("butterfat");
//                String protein = rs.getString("protein");
//                PureMilk pureMilk = new PureMilk(code, description, price, date, shelfLife, countryOfOrigin, butterfat, protein);
//                SaleItem saleItem = new SaleItem(pureMilk, 1);
//                productCatalog.addProduct(saleItem.getProduct());
//            }
//            rs.close();
//            stmt.close();
//            conn.close();
//        }catch(SQLException se){
//            // 处理 JDBC 错误
//            se.printStackTrace();
//        }catch(Exception e){
//            // 处理 Class.forName 错误
//            e.printStackTrace();
//        }finally{
//            // 关闭资源
//            try{
//                if(stmt!=null) stmt.close();
//            }catch(SQLException se2){
//            }// 什么都不做
//            try{
//                if(conn!=null) conn.close();
//            }catch(SQLException se){
//                se.printStackTrace();
//            }
//        }
//    }
//
//    public void getMilkDrinkData(ProductCatalog productCatalog){
//        Date date = new Date();
//        Connection conn = null;
//        Statement stmt = null;
//        try{
//            // 注册 JDBC 驱动
//            Class.forName(JDBC_DRIVER);
//
//            // 打开链接
//            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//
//            // 执行查询
//            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT code, description, price, shelfLife, flavor, sugar FROM milkDrink";
//            ResultSet rs = stmt.executeQuery(sql);
//
//            // 展开结果集数据库
//            while(rs.next()){
//                String code = rs.getString("code");
//                String description = rs.getString("description");
//                float price = rs.getFloat("price");
//                String shelfLife = rs.getString("shelfLife");
//                String flavor = rs.getString("flavor");
//                String sugar = rs.getString("sugar");
//                MilkDrink milkDrink = new MilkDrink(code, description, price, date, shelfLife, flavor, sugar);
//                SaleItem saleItem = new SaleItem(milkDrink, 1);
//                productCatalog.addProduct(saleItem.getProduct());
//            }
//            rs.close();
//            stmt.close();
//            conn.close();
//        }catch(SQLException se){
//            // 处理 JDBC 错误
//            se.printStackTrace();
//        }catch(Exception e){
//            // 处理 Class.forName 错误
//            e.printStackTrace();
//        }finally{
//            // 关闭资源
//            try{
//                if(stmt!=null) stmt.close();
//            }catch(SQLException se2){
//            }// 什么都不做
//            try{
//                if(conn!=null) conn.close();
//            }catch(SQLException se){
//                se.printStackTrace();
//            }
//        }
//    }
//
//    private void getUserList(UserList userList){
//        Connection conn = null;
//        Statement stmt = null;
//        try{
//            // 注册 JDBC 驱动
//            Class.forName(JDBC_DRIVER);
//
//            // 打开链接
//            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//
//            // 执行查询
//            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT userName, password, email FROM userList";
//            ResultSet rs = stmt.executeQuery(sql);
//
//            // 展开结果集数据库
//            while(rs.next()){
//                String userName = rs.getString("userName");
//                String password = rs.getString("password");
//                String email = rs.getString("email");
//                User user = new User(userName, password, email, null);
//                userList.addUser(user);
//            }
//            rs.close();
//            stmt.close();
//            conn.close();
//        }catch(SQLException se){
//            // 处理 JDBC 错误
//            se.printStackTrace();
//        }catch(Exception e){
//            // 处理 Class.forName 错误
//            e.printStackTrace();
//        }finally{
//            // 关闭资源
//            try{
//                if(stmt!=null) stmt.close();
//            }catch(SQLException se2){
//            }// 什么都不做
//            try{
//                if(conn!=null) conn.close();
//            }catch(SQLException se){
//                se.printStackTrace();
//            }
//        }
//    }
//}
