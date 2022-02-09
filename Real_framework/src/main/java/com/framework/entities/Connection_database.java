/*
 * Conexao.java
 *
 * Created on January 23, 2007, 7:27 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.framework.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fabricio
 */
public class Connection_database {
    
    /** Creates a new instance of Conexao */
    public Connection_database() {
    }
    public Connection Connect() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost/home?user=fabricio&password=Devanon1");
        //Connection Conn = DriverManager.getConnection("jdbc:mysql://mysql.fabricioweb.com.br/epsilonconsult?user=epsilonconsult&password=suzako");
        return Conn;
    }
}
