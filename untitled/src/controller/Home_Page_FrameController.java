package controller;

import viewer.home_page;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Home_Page_FrameController {
    private home_page home_page;
    private JButton button_register;
    private JButton button_log;
    private RegisterController Register;
    private LoginFrameController LOGIN;


    public Home_Page_FrameController() {
        InitComponent();
        InitListeners();
    }

    private void InitComponent() {
        home_page = new home_page();
        button_log= home_page.getButton_log();
        button_register=home_page.getButton_register();
    }

    public void showHomeFrame()
{
    home_page.setVisible(true);
}

    private void InitListeners() {
        button_log.addActionListener(new button_logListener());
        button_register.addActionListener(new button_regListener());
    }

    private class button_regListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("pressed");
            try {
                Register=new RegisterController();
            } catch (IOException exception) {
                exception.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }

        }

    }

        private class button_logListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e)

            {
                try {
                    LOGIN=new LoginFrameController();
                } catch (IOException exception) {
                    exception.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
    }
}



