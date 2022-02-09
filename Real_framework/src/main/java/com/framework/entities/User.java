/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.framework.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabricio
 */
public class User {

    private Integer id;
    private String name;
    private String login;
    private String password;
    private String token;
    private String at_update;
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private ArrayList users;

    public void connect() throws SQLException, ClassNotFoundException {
        Connection_database connect = new Connection_database();
        this.conn = connect.Connect();
    }

    public void close() throws SQLException, ClassNotFoundException {
        this.conn.close();
    }

    public void setAll(User user) throws SQLException {
        user.id = this.rs.getInt("id");
        user.name = this.rs.getString("name");
        user.login = this.rs.getString("login");
    }

    public boolean login(String login, String password) throws SQLException, ClassNotFoundException {
        this.users = new ArrayList();
        User user = new User();
        this.connect();
        this.pstm = this.conn.prepareStatement("SELECT * FROM users"
                + "WHERE name = "
                + login
                + " AND password = "
                + password);
        this.rs = this.pstm.executeQuery();

        if (this.rs.next()) {
            return true;
        }
        else{
            return false;
        }
        close();
}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAt_update() {
        return at_update;
    }

    public void setAt_update(String at_update) {
        this.at_update = at_update;
    }

}
