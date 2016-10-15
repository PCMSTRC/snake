package server;

import client.Cliente;
import server.Tron;

import javax.swing.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Fabian Montero on 08-Oct-16.
 */
public class ClientLogin extends JFrame{
    private JPanel clientLogin;
    private JButton DEPLOYButton;
    private JTextField socket;
    private JTextField nickName;




    public ClientLogin(){

        super("ClientLogin");

        setContentPane(clientLogin);

        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        setVisible(true);




        DEPLOYButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);


                String nickNameText = nickName.getText();
                String socketText = socket.getText();

                Cliente.nickNameText = nickNameText;
                Cliente.socketText = socketText;

                Tron.tron.deploy();




            }
        });
    }


    public void setData(ClientLogin data) {
    }

    public void getData(ClientLogin data) {
    }

    public boolean isModified(ClientLogin data) {
        return false;
    }
}


