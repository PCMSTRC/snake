package server;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

import static server.Tron.*;


/**
 * Class Show, pinta y actualiza el mapa
 *
 *
 * @author Fabian Montero , Emer Castro
 */

@SuppressWarnings("serial")
public class Show extends JPanel {

    public Color color_backround = new Color(0x000000);

    public Color color_item_trail = new Color(0x1100FF);
    public Color color_item_bomb = new Color(0xFF0003);
    public Color color_item_hyperspeed = new Color(0xFAFCEE);
    public Color color_item_shield = new Color(0x81FF1C);
    public Color color_item_cell = new Color(0xB16F14);
    public Color shield_color = new Color(0xFFFFFF);


    public Color color_player1_bike = new Color(0x751000);
    public Color color_player1_trail = new Color(0xFF0000);


    public Color color_player2_bike = new Color(0x6D6D00);
    public Color color_player2_trail = new Color(0xFFFF00);


    public Color color_player3_bike = new Color(0x005A00);
    public Color color_player3_trail = new Color(0x00FF00);


    public Color color_player4_bike = new Color(0x000054);
    public Color color_player4_trail = new Color(0x0000FF);

    public Color color_bot1_bike = new Color(0x802D6F);
    public Color color_bot1_trail = new Color(0xCE26F0);


    public String user1_shield;
    public String user2_shield;
    public String user3_shield;
    public String user4_shield;
    public String bot1_shield;


    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(color_backround);
        g.fillRect(0, 0, 1920, 1080);

        Tron tron = Tron.tron;


        //PLAYER1//
        //TRAIL
        g.setColor(color_player1_bike);

        if (user1.hasShield()) {

            g.setColor(shield_color);

        }

        for (Point point : user1.getTrail()) {

            g.fillRect(point.x * Tron.SIZE, point.y * Tron.SIZE, Tron.SIZE, Tron.SIZE);
        }

        //BIKE
        g.setColor(color_player1_trail);

        if (user1.hasShield()) {

            g.setColor(shield_color);

        }

        g.fillRect(user1.x * Tron.SIZE, user1.y * Tron.SIZE, Tron.SIZE, Tron.SIZE);


        //PLAYER2//
        //TRAIL
        g.setColor(color_player2_bike);

        if (user2.hasShield()) {

            g.setColor(shield_color);

        }

        for (Point point : user2.getTrail()) {

            g.fillRect(point.x * Tron.SIZE, point.y * Tron.SIZE, Tron.SIZE, Tron.SIZE);
        }

        //BIKE
        g.setColor(color_player2_trail);

        if (user2.hasShield()) {

            g.setColor(shield_color);

        }

        g.fillRect(user2.x * Tron.SIZE, user2.y * Tron.SIZE, Tron.SIZE, Tron.SIZE);


        //PLAYER3//
        //TRAIL
        g.setColor(color_player3_bike);

        if (user3.hasShield()) {

            g.setColor(shield_color);

        }

        for (Point point : user3.getTrail()) {

            g.fillRect(point.x * Tron.SIZE, point.y * Tron.SIZE, Tron.SIZE, Tron.SIZE);
        }

        //BIKE
        g.setColor(color_player3_trail);

        if (user3.hasShield()) {

            g.setColor(shield_color);

        }

        g.fillRect(user3.x * Tron.SIZE, user3.y * Tron.SIZE, Tron.SIZE, Tron.SIZE);


        //PLAYER4//
        //TRAIL
        g.setColor(color_player4_bike);

        if (user4.hasShield()) {

            g.setColor(shield_color);

        }

        for (Point point : user4.getTrail()) {

            g.fillRect(point.x * Tron.SIZE, point.y * Tron.SIZE, Tron.SIZE, Tron.SIZE);
        }

        //BIKE
        g.setColor(color_player4_trail);

        if (user4.hasShield()) {

            g.setColor(shield_color);

        }

        g.fillRect(user4.x * Tron.SIZE, user4.y * Tron.SIZE, Tron.SIZE, Tron.SIZE);


        //bot1//
        //TRAIL
        g.setColor(color_bot1_bike);

        if (bot1.hasShield()) {
            g.setColor(shield_color);
        }
        for (Point point : bot1.getTrail()) {
            g.fillRect(point.x * Tron.SIZE, point.y * Tron.SIZE, Tron.SIZE, Tron.SIZE);
        }
        //BIKE
        g.setColor(color_bot1_trail);
        if (bot1.hasShield()) {
            g.setColor(shield_color);
        }
        g.fillRect(bot1.x * Tron.SIZE, bot1.y * Tron.SIZE, Tron.SIZE, Tron.SIZE);


        //ITEMS

        //TRIAL EXTENDER
        g.setColor(color_item_trail);
        g.fillRect(tron.trailExtender.x * Tron.SIZE, tron.trailExtender.y * Tron.SIZE, Tron.SIZE, Tron.SIZE);

        //BOMB
        g.setColor(color_item_bomb);
        g.fillRect(tron.bomb.x * Tron.SIZE, tron.bomb.y * Tron.SIZE, Tron.SIZE, Tron.SIZE);

        g.setColor(color_item_cell);
        g.fillRect(tron.fuelCell.x * Tron.SIZE, tron.fuelCell.y * Tron.SIZE, Tron.SIZE, Tron.SIZE);


        //POWERUPS

        //TRAIL REDUCER
        g.setColor(color_item_hyperspeed);
        g.fillRect(tron.trailReducer.x * Tron.SIZE, tron.trailReducer.y * Tron.SIZE, Tron.SIZE, Tron.SIZE);

        //SHEILD
        g.setColor(color_item_shield);
        g.fillRect(tron.shield.x * Tron.SIZE, tron.shield.y * Tron.SIZE, Tron.SIZE, Tron.SIZE);


        if (user1.hasShield()) {

            user1_shield = "ACTIVE";

        } else {
            user1_shield = "-";
        }

        if (user2.hasShield()) {

            user2_shield = "ACTIVE";

        } else {
            user2_shield = "-";
        }

        if (user3.hasShield()) {

            user3_shield = "ACTIVE";

        } else {
            user3_shield = "-";
        }

        if (user4.hasShield()) {

            user4_shield = "ACTIVE";

        } else {
            user4_shield = "-";
        }

        if (bot1.hasShield()) {

            bot1_shield = "ACTIVE";

        } else {
            bot1_shield = "-";


            //STATS//
            String user1_stats = "USER 1 --  " + "Nickname: " + user1.nickName + ", Trail: " + user1.trailLength + ", Shield: " + user1_shield + "Fuel: " + user1.getFuel();
            String user2_stats = "USER 2 --  " + "Nickname: " + user2.nickName + ", Trail: " + user2.trailLength + ", Shield: " + user2_shield + "Fuel: " + user2.getFuel();
            String user3_stats = "USER 3 --  " + "Nickname: " + user3.nickName + ", Trail: " + user3.trailLength + ", Shield: " + user3_shield + "Fuel: " + user3.getFuel();
            String user4_stats = "USER 4 --  " + "Nickname: " + user4.nickName + ", Trail: " + user4.trailLength + ", Shield: " + user4_shield + "Fuel: " + user4.getFuel();


            g.setColor(Color.white);
            g.drawString(user1_stats, (int) (this.getWidth() / 2 - user1_stats.length() * 2.5f), 15);
            g.drawString(user2_stats, (int) (getWidth() / 2 - user1_stats.length() * 2.5f), 27);
            g.drawString(user3_stats, (int) (getWidth() / 2 - user1_stats.length() * 2.5f), 40);
            g.drawString(user4_stats, (int) (getWidth() / 2 - user1_stats.length() * 2.5f), 52);

        }

    }

}