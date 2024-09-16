package controller;

import viewer.LogInViewer;
import viewer.Register_page;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginFrameController {
    private JButton button_register;
    private JButton button_log;
    private LogInViewer logInViewer;
    Register_page Register_page;

    public LoginFrameController() {
        InitComponent();
        InitListeners();
    }

    private void InitComponent() {
        logInViewer = new LogInViewer();
        button_log= logInViewer.getLogIn();
        button_register= logInViewer.getRegister();

    }



    private void InitListeners() {
        button_log.addActionListener(new button_logListener());
        button_register.addActionListener(new button_regListener());
    }
    private class button_regListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Register_page=new Register_page();
            Register_page.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }

    }

    private class button_logListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String userName = logInViewer.getUsername();
            String pass = logInViewer.getPassword();
            try
            {
                ValidateLoginRequest(userName,pass);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        public Boolean ValidateLoginRequest (String Username, String pass) throws SQLException
        {
            try
            {
                System.out.println("Connecting to a selected database...");
                Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\hagai\\IdeaProjects\\Software-engineer-final-project\\untitled\\src\\DButills\\account.db");
                System.out.println("Connected database successfully...");
                String sqlQuary = "SELECT username FROM accounts WHERE username = '"+Username+"' AND pass = '"+pass+"'";
                PreparedStatement ps = connection.prepareStatement(sqlQuary);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    System.out.println("you have successfully logged in to " + rs.getString("username") + "\n");
                    ps.close();
                    connection.close();
                    return true;
                }
                else
                    {
                    System.out.println("The user or the password doesn't match!");
                    ps.close();
                    connection.close();
                    return false;
                    }
            }
            catch (SQLException e)
            {
                System.out.println("שם המשתמש או הסיסמה אינם מתאימים" + e.getMessage());
                return false;
            }
        }
    }
}