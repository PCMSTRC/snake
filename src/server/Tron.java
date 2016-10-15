package server;


import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Clase principal del juego.
 *
 *
 *
 * @author Fabian Montero , Emer Castro
 * */
public class Tron implements ActionListener , KeyListener{

    public static Tron tron;

    public static JFrame tronGame;
    public JFrame tronLauncher;


    public Show show;
    public static final int SIZE = 10;

    public Timer timer = new Timer(20 , this);
    public int ticks = 0;
    public static boolean paused;

    public static final int UP = 0 , DOWN = 1 , LEFT = 2 , RIGHT = 3;
    public static final int HIGH = 2 , LOW = 4;

    public static int score = 0;

    public Random random;

    public static User user1 = new User(0 , -1 , new ArrayList<Point>() , 8 , DOWN , false , 2 , "" , false , 100);
    public static User user2 = new User(17 , -1 , new ArrayList<Point>() , 8 , DOWN , false , 2 , "" , false , 100);
    public static User user3 = new User(34 , -1 , new ArrayList<Point>() , 8 , DOWN , false , 2 , "" , false , 100);
    public static User user4 = new User(70 , -1 , new ArrayList<Point>() , 8 , DOWN , false , 2 , "" , false , 100);

    public static Bot bot1=new Bot(80 , -1, new ArrayList<Point>() , 8 , DOWN , false , 2 , "" , false , 100);

    Item trailExtender;
    Item bomb;
    Item fuelCell;

    PowerUp trailReducer;
    PowerUp shield;


    /**
     * Constructor de la calse Tron
     *
     *
     */
    public Tron() {

        ClientLogin clientLogin = new ClientLogin();
        clientLogin.setSize(400 , 300);
        clientLogin.setTitle("TRON Launcher");



    }

    /**
     * Inicia/resetea el juego
     *
     *
     */
    public void deploy(){


        tronGame = new JFrame("TRON");
        tronGame.setVisible(true);
        tronGame.setSize(1920 , 1080);
        tronGame.setResizable(false);
        tronGame.add(show = new Show());
        tronGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tronGame.addKeyListener(this);

        System.out.println("Tron OK");


        user1.reset(0 , -1);
        user2.reset(17 , -1);
        user3.reset(34 , -1);
        user4.reset(70 , -1);

        bot1.reset(80 , -1);

        paused = false;
        ticks = 0;

        random = new Random();


        trailExtender = new Item(random.nextInt(79) , random.nextInt(66));
        bomb = new Item(random.nextInt(79) , random.nextInt(66));
        fuelCell = new Item(random.nextInt(79) , random.nextInt(66));

        trailReducer = new PowerUp(random.nextInt(79) , random.nextInt(66));
        shield = new PowerUp(random.nextInt(79) , random.nextInt(66));

        System.out.println("Deploy OK");

        timer.start();
    }

    /**
     * Lee lo que los usuarios escriben en su teclado
     *
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {

        int player1_key = e.getKeyCode();
        int player2_key = e.getKeyCode();
        int player3_key = e.getKeyCode();
        int player4_key = e.getKeyCode();
        int key = e.getKeyCode();


        if (player1_key == KeyEvent.VK_A && user1.getDirection() != RIGHT){
            user1.setDirection(LEFT);
        }
        if (player1_key == KeyEvent.VK_D && user1.getDirection() != LEFT){
            user1.setDirection(RIGHT);
        }
        if (player1_key == KeyEvent.VK_W && user1.getDirection() != DOWN){
            user1.setDirection(UP);
        }
        if (player1_key == KeyEvent.VK_S && user1.getDirection() != UP){
            user1.setDirection(DOWN);
        }




        if (player2_key == KeyEvent.VK_F && user2.getDirection() != RIGHT){
            user2.setDirection(LEFT);
        }
        if (player2_key == KeyEvent.VK_H && user2.getDirection() != LEFT){
            user2.setDirection(RIGHT);
        }
        if (player2_key == KeyEvent.VK_T && user2.getDirection() != DOWN){
            user2.setDirection(UP);
        }
        if (player2_key == KeyEvent.VK_G && user2.getDirection() != UP){
            user2.setDirection(DOWN);
        }




        if (player3_key == KeyEvent.VK_J && user3.getDirection() != RIGHT){
            user3.setDirection(LEFT);
        }
        if (player3_key == KeyEvent.VK_L && user3.getDirection() != LEFT){
            user3.setDirection(RIGHT);
        }
        if (player3_key == KeyEvent.VK_I && user3.getDirection() != DOWN){
            user3.setDirection(UP);
        }
        if (player3_key == KeyEvent.VK_K && user3.getDirection() != UP){
            user3.setDirection(DOWN);
        }




        if (player4_key == KeyEvent.VK_LEFT && user4.getDirection() != RIGHT){
            user4.setDirection(LEFT);
        }
        if (player4_key == KeyEvent.VK_RIGHT && user4.getDirection() != LEFT){
            user4.setDirection(RIGHT);
        }
        if (player4_key == KeyEvent.VK_UP && user4.getDirection() != DOWN){
            user4.setDirection(UP);
        }
        if (player4_key == KeyEvent.VK_DOWN && user4.getDirection() != UP){
            user4.setDirection(DOWN);
        }


        int botmovement = random.nextInt(100);

        if (botmovement<=25){
            bot1.setDirection(UP);
        }
        if (botmovement >= 25 && botmovement <= 50) {
            bot1.setDirection(DOWN);
        }
        if (botmovement >= 50 && botmovement <= 75){
            bot1.setDirection(LEFT);}

        if (botmovement >= 75){
            bot1.setDirection(RIGHT);}



        if (key == KeyEvent.VK_SPACE){
            if(user1.isDisabled() && user2.isDisabled() && user3.isDisabled() && user4.isDisabled() && bot1.isDisabled()){
                deploy();
            }else{
                paused = !paused;
            }
        }



    }


    /**
     *
     * Es el loop del juego, aqui se actualizan todos los datos cada 0.25 segundos.
     *
     *
     * @param arg0
     */

    @Override
    public void actionPerformed(ActionEvent arg0) {
        show.repaint();
        ticks++;

        if(ticks % user1.getSpeed() == 0 && user1 != null && !user1.isDisabled() && !paused){

            user1.trail.add(new Point(user1.x , user1.y));

            if (user1.getDirection() == UP) {
                if (user1.y - 1 >= 0 && !crashed(user1.x , user1.y - 1)){
                    user1 = new User(user1.x , user1.y - 1 , user1.getTrail() , user1.getTrailLength() , user1.getDirection() , user1.isDisabled() , user1.getSpeed() , user1.getNickName() , user1.hasShield() , user1.getFuel());
                }else if(!user1.hasShield()){
                    user1.setDisabled(true);
                }
            }
            if (user1.getDirection() == DOWN) {
                if (user1.y + 1 < 105 && !crashed(user1.x , user1.y + 1)) {
                    user1 = new User(user1.x, user1.y + 1 , user1.getTrail() , user1.getTrailLength() , user1.getDirection() , user1.isDisabled() , user1.getSpeed() , user1.getNickName() , user1.hasShield() , user1.getFuel());
                } else if(!user1.hasShield()) {
                    user1.setDisabled(true);
                }
            }
            if (user1.getDirection() == LEFT) {
                if (user1.x - 1 >= 0 && !crashed(user1.x - 1 , user1.y)) {
                    user1 = new User(user1.x - 1, user1.y  , user1.getTrail(), user1.getTrailLength() , user1.getDirection() , user1.isDisabled() , user1.getSpeed() , user1.getNickName() , user1.hasShield() , user1.getFuel());
                } else if(!user1.hasShield()) {
                    user1.setDisabled(true);
                }
            }
            if (user1.getDirection() == RIGHT && !crashed(user1.x + 1 , user1.y)) {
                if (user1.x + 1 < 192) {
                    user1 = new User(user1.x + 1, user1.y  , user1.getTrail(), user1.getTrailLength() , user1.getDirection() , user1.isDisabled() , user1.getSpeed() , user1.getNickName() , user1.hasShield() , user1.getFuel());
                }else if(!user1.hasShield()) {
                    user1.setDisabled(true);
                }
            }

            if (user1.getTrail().size() > user1.getTrailLength()){

                while(user1.getTrail().size() > user1.getTrailLength()){

                    user1.trail.remove(0);
                }

            }

            if (trailExtender != null){

                if (user1.equals(trailExtender)){

                    score += 10;
                    user1.trailLength += 15;
                    trailExtender.setLocation(random.nextInt(79) , random.nextInt(66));
                }

            }

            if(bomb != null){

                if(user1.equals(bomb) && !user1.hasShield()){

                    user1.setDisabled(true);
                    bomb.setLocation(random.nextInt(79) , random.nextInt(66));

                }
            }

            if(fuelCell != null){

                if(user1.equals(fuelCell)){

                    user1.setFuel(user1.getFuel() + 15);
                    fuelCell.setLocation(random.nextInt(79) , random.nextInt(66));

                }

            }


            if(trailReducer != null) {

                if (user1.equals(trailReducer)) {

                    if (!user2.hasShield()){

                        user2.setTrailLength(user2.getTrailLength() - 7);

                    }

                    if (!user3.hasShield()){

                        user3.setTrailLength(user3.getTrailLength() - 7);

                    }

                    if (!user4.hasShield()){

                        user4.setTrailLength(user4.getTrailLength() - 7);

                    }
                }
            }


            if(shield != null) {

                if (user1.equals(shield)) {

                    user1.setShield(true);
                    shield.setLocation(random.nextInt(79) , random.nextInt(66));

                }
            }

            if(user1.hasShield() && ticks%210 == 0){

                user1.setShield(false);

            }

            if(user1.getFuel() > 0 && ticks%100 == 0){

                user1.fuel -= 10;

            }

            if(user1.getFuel() <= 0){

                user1.setDisabled(true);

            }

        }


        if(ticks % user2.getSpeed() == 0 && user2 != null && !user2.isDisabled() && !paused){

            user2.trail.add(new Point(user2.x , user2.y));

            if (user2.getDirection() == UP) {
                if (user2.y - 1 >= 0 && !crashed(user2.x , user2.y - 1)){
                    user2 = new User(user2.x , user2.y - 1 , user2.getTrail() , user2.getTrailLength() , user2.getDirection() , user2.isDisabled() , user2.getSpeed() , user2.getNickName() , user2.hasShield() , user2.getFuel());
                }else if(!user2.hasShield()){
                    user2.setDisabled(true);
                }
            }
            if (user2.getDirection() == DOWN) {
                if (user2.y + 1 < 105 && !crashed(user2.x , user2.y + 1)) {
                    user2 = new User(user2.x, user2.y + 1 , user2.getTrail() , user2.getTrailLength() , user2.getDirection() , user2.isDisabled() , user2.getSpeed() , user2.getNickName() , user2.hasShield() , user2.getFuel());
                } else if(!user2.hasShield()) {
                    user2.setDisabled(true);
                }
            }
            if (user2.getDirection() == LEFT) {
                if (user2.x - 1 >= 0 && !crashed(user2.x - 1 , user2.y)) {
                    user2 = new User(user2.x - 1, user2.y  , user2.getTrail(), user2.getTrailLength() , user2.getDirection() , user2.isDisabled() , user2.getSpeed() , user2.getNickName() , user2.hasShield() , user2.getFuel());
                } else if(!user2.hasShield()) {
                    user2.setDisabled(true);
                }
            }
            if (user2.getDirection() == RIGHT && !crashed(user2.x + 1 , user2.y)) {
                if (user2.x + 1 < 192) {
                    user2 = new User(user2.x + 1, user2.y  , user2.getTrail(), user2.getTrailLength() , user2.getDirection() , user2.isDisabled() , user2.getSpeed() , user2.getNickName() , user2.hasShield() , user2.getFuel());
                }else if(!user2.hasShield()) {
                    user2.setDisabled(true);
                }
            }

            if (user2.getTrail().size() > user2.getTrailLength()){

                while(user2.getTrail().size() > user2.getTrailLength()){

                    user2.trail.remove(0);
                }

            }

            if (trailExtender != null){

                if (user2.equals(trailExtender)){

                    score += 10;
                    user2.trailLength += 15;
                    trailExtender.setLocation(random.nextInt(79) , random.nextInt(66));
                }

            }

            if(bomb != null){

                if(user2.equals(bomb) && !user2.hasShield()){

                    user2.setDisabled(true);

                }
            }

            if(fuelCell != null){

                if(user2.equals(fuelCell)){

                    user2.setFuel(user2.getFuel() + 15);
                    fuelCell.setLocation(random.nextInt(79) , random.nextInt(66));

                }

            }

            if(trailReducer != null) {

                if (user2.equals(trailReducer)) {

                    if (!user1.hasShield()){

                        user1.setTrailLength(user1.getTrailLength() - 7);

                    }

                    if (!user3.hasShield()){
                        user3.setTrailLength(user3.getTrailLength() - 7);

                    }

                    if (!user4.hasShield()){

                        user4.setTrailLength(user4.getTrailLength() - 7);

                    }
                }
            }

            if(shield != null) {

                if (user2.equals(shield)) {

                    user2.setShield(true);
                    shield.setLocation(random.nextInt(79) , random.nextInt(66));

                }
            }

            if(user2.hasShield() && ticks%210 == 0){

                user2.setShield(false);

            }

            if(user2.getFuel() > 0 && ticks%100 == 0){

                user2.fuel -= 10;

            }

            if(user2.getFuel() <= 0){

                user2.setDisabled(true);

            }


        }

        if(ticks % user3.getSpeed() == 0 && user3 != null && !user3.isDisabled() && !paused){

            user3.trail.add(new Point(user3.x , user3.y));

            if (user3.getDirection() == UP) {
                if (user3.y - 1 >= 0 && !crashed(user3.x , user3.y - 1)){
                    user3 = new User(user3.x , user3.y - 1 , user3.getTrail() , user3.getTrailLength() , user3.getDirection() , user3.isDisabled() , user3.getSpeed() , user3.getNickName() , user3.hasShield() , user3.getFuel());
                }else if(!user3.hasShield()){
                    user3.setDisabled(true);
                }
            }
            if (user3.getDirection() == DOWN) {
                if (user3.y + 1 < 105 && !crashed(user3.x , user3.y + 1)) {
                    user3 = new User(user3.x, user3.y + 1 , user3.getTrail() , user3.getTrailLength() , user3.getDirection() , user3.isDisabled() , user3.getSpeed() , user3.getNickName() , user3.hasShield() , user3.getFuel());
                } else if(!user3.hasShield()) {
                    user3.setDisabled(true);
                }
            }
            if (user3.getDirection() == LEFT) {
                if (user3.x - 1 >= 0 && !crashed(user3.x - 1 , user3.y)) {
                    user3 = new User(user3.x - 1, user3.y  , user3.getTrail(), user3.getTrailLength() , user3.getDirection() , user3.isDisabled() , user3.getSpeed() , user3.getNickName() , user3.hasShield() , user3.getFuel());
                } else if(!user3.hasShield()) {
                    user3.setDisabled(true);
                }
            }
            if (user3.getDirection() == RIGHT && !crashed(user3.x + 1 , user3.y)) {
                if (user3.x + 1 < 192) {
                    user3 = new User(user3.x + 1, user3.y  , user3.getTrail(), user3.getTrailLength() , user3.getDirection() , user3.isDisabled() , user3.getSpeed() , user3.getNickName() , user3.hasShield() , user3.getFuel());
                }else if(!user3.hasShield()) {
                    user3.setDisabled(true);
                }
            }

            if (user3.getTrail().size() > user3.getTrailLength()){

                while(user3.getTrail().size() > user3.getTrailLength()){

                    user3.trail.remove(0);
                }

            }

            if (trailExtender != null){

                if (user3.equals(trailExtender)){

                    score += 10;
                    user3.trailLength += 15;
                    trailExtender.setLocation(random.nextInt(79) , random.nextInt(66));
                }

            }

            if(bomb != null){

                if(user3.equals(bomb) && !user3.hasShield()){

                    user3.setDisabled(true);

                }
            }

            if(fuelCell != null){

                if(user3.equals(fuelCell)){

                    user3.setFuel(user3.getFuel() + 15);
                    fuelCell.setLocation(random.nextInt(79) , random.nextInt(66));

                }

            }

            if(trailReducer != null) {

                if (user3.equals(trailReducer)) {

                    if (!user1.hasShield()){

                        user1.setTrailLength(user1.getTrailLength() - 7);

                    }

                    if (!user2.hasShield()){
                        user2.setTrailLength(user2.getTrailLength() - 7);

                    }

                    if (!user4.hasShield()){

                        user4.setTrailLength(user4.getTrailLength() - 7);

                    }
                }
            }


            if(shield != null) {

                if (user3.equals(shield)) {

                    user3.setShield(true);
                    shield.setLocation(random.nextInt(79) , random.nextInt(66));

                }
            }

            if(user3.hasShield() && ticks%210 == 0){

                user3.setShield(false);

            }

            if(user3.getFuel() > 0 && ticks%100 == 0){

                user3.fuel -= 10;

            }

            if(user3.getFuel() <= 0){

                user3.setDisabled(true);

            }


        }

        if(ticks % user4.getSpeed() == 0 && user4 != null && !user4.isDisabled() && !paused){

            user4.trail.add(new Point(user4.x , user4.y));

            if (user4.getDirection() == UP) {
                if (user4.y - 1 >= 0 && !crashed(user4.x , user4.y - 1)){
                    user4 = new User(user4.x , user4.y - 1 , user4.getTrail() , user4.getTrailLength() , user4.getDirection() , user4.isDisabled() , user4.getSpeed() , user4.getNickName() , user4.hasShield() , user4.getFuel());
                }else if(!user4.hasShield()){
                    user4.setDisabled(true);
                }
            }
            if (user4.getDirection() == DOWN) {
                if (user4.y + 1 < 105 && !crashed(user4.x , user4.y + 1)) {
                    user4 = new User(user4.x, user4.y + 1 , user4.getTrail() , user4.getTrailLength() , user4.getDirection() , user4.isDisabled() , user4.getSpeed() , user4.getNickName() , user4.hasShield() , user4.getFuel());
                } else if(!user4.hasShield()) {
                    user4.setDisabled(true);
                }
            }
            if (user4.getDirection() == LEFT) {
                if (user4.x - 1 >= 0 && !crashed(user4.x - 1 , user4.y)) {
                    user4 = new User(user4.x - 1, user4.y  , user4.getTrail(), user4.getTrailLength() , user4.getDirection() , user4.isDisabled() , user4.getSpeed() , user4.getNickName() , user4.hasShield() , user4.getFuel());
                } else if(!user4.hasShield()) {
                    user4.setDisabled(true);
                }
            }
            if (user4.getDirection() == RIGHT && !crashed(user4.x + 1 , user4.y)) {
                if (user4.x + 1 < 192) {
                    user4 = new User(user4.x + 1, user4.y  , user4.getTrail(), user4.getTrailLength() , user4.getDirection() , user4.isDisabled() , user4.getSpeed() , user4.getNickName() , user4.hasShield() , user4.getFuel());
                }else if(!user4.hasShield()) {
                    user4.setDisabled(true);
                }
            }

            if (user4.getTrail().size() > user4.getTrailLength()){

                while(user4.getTrail().size() > user4.getTrailLength()){

                    user4.trail.remove(0);
                }
            }

            if (trailExtender != null){

                if (user4.equals(trailExtender)){

                    score += 10;
                    user4.trailLength += 15;
                    trailExtender.setLocation(random.nextInt(79) , random.nextInt(66));
                }
            }

            if(bomb != null){

                if(user4.equals(bomb) && !user4.hasShield()){

                    user4.setDisabled(true);

                }
            }

            if(fuelCell != null){

                if(user4.equals(fuelCell)){

                    user4.setFuel(user4.getFuel() + 15);
                    fuelCell.setLocation(random.nextInt(79) , random.nextInt(66));

                }

            }

            if(trailReducer != null) {

                if (user4.equals(trailReducer)) {

                    if (!user1.hasShield()){

                        user1.setTrailLength(user1.getTrailLength() - 7);

                    }

                    if (!user2.hasShield()){
                        user2.setTrailLength(user2.getTrailLength() - 7);

                    }

                    if (!user3.hasShield()){

                        user3.setTrailLength(user3.getTrailLength() - 7);

                    }
                }
            }

            if(shield != null) {

                if (user4.equals(shield)) {

                    user4.setShield(true);
                    shield.setLocation(random.nextInt(79) , random.nextInt(66));

                }
            }

            if(user4.hasShield() && ticks%210 == 0){

                user4.setShield(false);


            }

            if(user4.getFuel() > 0 && ticks%100 == 0){

                user4.fuel -= 10;

            }

            if(user4.getFuel() <= 0){

                user4.setDisabled(true);

            }
        }

        if(ticks % bot1.getSpeed() == 0 && bot1 != null && !bot1.isDisabled() && !paused){

            bot1.trail.add(new Point(bot1.x , bot1.y));

            if (bot1.getDirection() == UP) {
                if (bot1.y - 1 >= 0 && !crashed(bot1.x , bot1.y - 1)){
                    bot1 = new Bot(bot1.x , bot1.y - 1 , bot1.getTrail() , bot1.getTrailLength() , bot1.getDirection() , bot1.isDisabled() , bot1.getSpeed() , bot1.getNickName() , bot1.hasShield() , 100);
                }else if(!bot1.hasShield()){
                    bot1.setDisabled(true);
                }
            }
            if (bot1.getDirection() == DOWN) {
                if (bot1.y + 1 < 105 && !crashed(bot1.x , bot1.y + 1)) {
                    bot1 = new Bot(bot1.x, bot1.y + 1 , bot1.getTrail() , bot1.getTrailLength() , bot1.getDirection() , bot1.isDisabled() , bot1.getSpeed() , bot1.getNickName() , bot1.hasShield() , 100);
                } else if(!bot1.hasShield()) {
                    bot1.setDisabled(true);
                }
            }
            if (bot1.getDirection() == LEFT) {
                if (bot1.x - 1 >= 0 && !crashed(bot1.x - 1 , bot1.y)) {
                    bot1 = new Bot(bot1.x - 1, bot1.y  , bot1.getTrail(), bot1.getTrailLength() , bot1.getDirection() , bot1.isDisabled() , bot1.getSpeed() , bot1.getNickName() , bot1.hasShield() , 100);
                } else if(!bot1.hasShield()) {
                    bot1.setDisabled(true);
                }
            }
            if (bot1.getDirection() == RIGHT && !crashed(bot1.x + 1 , bot1.y)) {
                if (bot1.x + 1 < 192) {
                    bot1 = new Bot(bot1.x + 1, bot1.y  , bot1.getTrail(), bot1.getTrailLength() , bot1.getDirection() , bot1.isDisabled() , bot1.getSpeed() , bot1.getNickName() , bot1.hasShield() , 100);
                }else if(!bot1.hasShield()) {
                    bot1.setDisabled(true);
                }
            }

            if (bot1.getTrail().size() > bot1.getTrailLength()){

                while(bot1.getTrail().size() > bot1.getTrailLength()){

                    bot1.trail.remove(0);
                }

            }

            if (trailExtender != null){

                if (bot1.equals(trailExtender)){

                    score += 10;
                    bot1.trailLength += 15;
                    trailExtender.setLocation(random.nextInt(79) , random.nextInt(66));
                }

            }

            if(bomb != null){
                if(bot1.equals(bomb) && !bot1.hasShield()){
                    bot1.setDisabled(true);
                    bomb.setLocation(random.nextInt(79) , random.nextInt(66));
                }
            }
            if(trailReducer != null) {
                if (bot1.equals(trailReducer)) {
                    if (!user2.hasShield()){

                        user2.setTrailLength(user2.getTrailLength() - 7);

                    }

                    if (!user3.hasShield()){

                        user3.setTrailLength(user3.getTrailLength() - 7);

                    }

                    if (!user4.hasShield()){

                        user4.setTrailLength(user4.getTrailLength() - 7);

                    }
                }
            }


            if(shield != null) {

                if (bot1.equals(shield)) {

                    bot1.setShield(true);
                    shield.setLocation(random.nextInt(79) , random.nextInt(66));

                }
            }

            if(bot1.hasShield() && ticks%210 == 0){

                bot1.setShield(false);

            }
        }



    }

    /**
     * Determina si una moto chocó. Si lo hizo, la desactiva.
     *
     *
     * @param x
     * @param y
     * @return
     */

    public boolean crashed(int x, int y) {


        ArrayList<Point> allTails = new ArrayList<Point>();

        allTails.addAll(user1.getTrail());
        allTails.addAll(user2.getTrail());
        allTails.addAll(user3.getTrail());
        allTails.addAll(user4.getTrail());
        allTails.addAll(bot1.getTrail());

        Point checker1 = new Point(x , y);


        for (Point trail : allTails) {

            if (trail.equals(checker1)) {
                return true;
            }
        }
        return false;
    }


    /**
     * El metodo Main de tron.
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        tron = new Tron();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}









