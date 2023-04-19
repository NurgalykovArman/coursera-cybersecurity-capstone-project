package com.example.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    public static final String url = "jdbc:postgresql://localhost/aralasu";
    public static final String user = "postgres";
    public static final String password = "admin";
    public static Connection connection;

    public static void connect(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Success!!!");
        }catch (Exception e){
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }
    public  static User getUser(Long idd){
        User user = new User();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * " +
                    "FROM public.users " +
                    "WHERE user_id = ?");
            statement.setLong(1, idd);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                long id = resultSet.getLong("user_id");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String full_name = resultSet.getString("full_name");
                String birth_date = resultSet.getString("birth_date");
                String picture_url = resultSet.getString("picture_url");
                user = new User(id, email, password, full_name, birth_date, picture_url);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public  static ArrayList<User> getAllUsers(){
        ArrayList<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM public.users " +
                    "ORDER BY user_id ASC ");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                long id = resultSet.getLong("user_id");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String full_name = resultSet.getString("full_name");
                String birth_date = resultSet.getString("birth_date");
                String picture_url = resultSet.getString("picture_url");
                users.add(new User(id, email, password, full_name, birth_date, picture_url));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }
    public static void addUser(User user){
        try {
            PreparedStatement statement = connection.prepareStatement(""+
                    "INSERT INTO public.users (email, password, full_name, birth_date) " +
                    "VALUES (?, ?, ?, ?) ");
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFull_name());
            statement.setString(4, user.getBirth_date());
            int rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void updatePicture(String url, Long id){
        try {
            PreparedStatement statement = connection.prepareStatement(""+
                    "UPDATE public.users SET " +
                    "picture_url = ? " +
                    "WHERE user_id = ?");
            statement.setString(1, url);
            statement.setLong(2, id);

            int rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  static ArrayList<Post> getAllPosts(){
        ArrayList<Post> posts = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT posts.post_id, posts.user_id, users.full_name, posts.title, posts.content, posts.post_date " +
                    "FROM posts " +
                    "JOIN users ON posts.user_id = users.user_id " +
                    "ORDER BY post_id DESC ");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                long post_id = resultSet.getLong("post_id");
                long user_id = resultSet.getLong("user_id");
                String full_name = resultSet.getString("full_name");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String post_date = resultSet.getString("post_date");
                posts.add(new Post(post_id, user_id, full_name, title, content, post_date));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return posts;
    }

    public static void addPost(Post post){
        try {
            PreparedStatement statement = connection.prepareStatement(""+
                    "INSERT INTO public.posts (user_id, title, content, post_date) " +
                    "VALUES (?, ?, ?, ?) ");
            statement.setLong(1, post.getAuthod_id());
            statement.setString(2, post.getTitle());
            statement.setString(3, post.getContent());
            statement.setString(4, post.getPost_date());
            int rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
