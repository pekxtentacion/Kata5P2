/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p2.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author adrir
 */
public class MailListReaderBD {
    public static List<String> read (String fileName) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        Connection cm= DriverManager.getConnection("jdbc:sqlite:KATA5.db");
        Statement st = cm.createStatement();
        ResultSet rs = st.executeQuery("select Mail from Mail");

        List<String> mailList = new ArrayList<>();
        String leido;
        while(rs.next()){
            if((leido=rs.getString("Mail")).contains("@")){
                mailList.add(leido);
            }
        }
        return mailList;
    }
}
