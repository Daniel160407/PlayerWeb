package com.playerweb.playerweb.model;

import com.playerweb.playerweb.music.Music;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLController implements JDBCController {
    private Connection con;

    @Override
    public void createSchema() {
        con = MySQLConnector.getConnection("jdbc:mysql://localhost:3306", "root", "17042007");

        try {
            Statement statement = con.createStatement();
            statement.executeUpdate("create schema if not exists musicplayer");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createTable() {
        con = MySQLConnector.getConnection("jdbc:mysql://localhost:3306/musicplayer", "root", "17042007");

        try {
            Statement statement = con.createStatement();
            statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS `music` (
                      `id` INT NOT NULL AUTO_INCREMENT,
                      `name` VARCHAR(45) NOT NULL,
                      `url` VARCHAR(45) NOT NULL,
                      PRIMARY KEY (`id`));
                    """);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void addMusic(Music music) {
        con = MySQLConnector.getConnection("jdbc:mysql://localhost:3306/musicplayer", "root", "17042007");

        try {
            PreparedStatement preparedStatement = con.prepareStatement("insert into musicplayer (name,url) values (?,?)");
            preparedStatement.setString(1, music.name());
            preparedStatement.setString(2, music.url());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Music> getMusics() {
        con = MySQLConnector.getConnection("jdbc:mysql://localhost:3306/musicplayer", "root", "17042007");

        List<Music> music = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from music");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println();
                music.add(new Music(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return music;
    }
}
