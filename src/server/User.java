package server;

import java.awt.Point;
import java.util.ArrayList;


/**
 * Class User. Define a cada usuario.
 *
 *
 * @author Fabian Montero
 */
public class User extends java.awt.Point{

    public ArrayList<Point> trail;
    public int trailLength;
    public int direction;
    public boolean disabled;
    public int speed;
    public String nickName;
    public boolean shield;
    public int fuel;


    public static final int UP = 0 , DOWN = 1 , LEFT = 2 , RIGHT = 3;


    public User(int x, int y , ArrayList<Point> trail , int trailLength , int direction , boolean disabled , int speed , String nickName , boolean shield , int fuel) {

        super(x , y);

        this.trail = trail;
        this.trailLength = trailLength;
        this.direction = direction;
        this.disabled = disabled;
        this.speed = speed;
        this.nickName = nickName;
        this.shield = shield;
        this.fuel = fuel;
    }

    public void reset(int x , int y){

        this.x = x;
        this.y = y;
        this.trail = new ArrayList<Point>();
        this.trailLength = 8;
        this.direction = DOWN;
        this.disabled = false;
        this.setFuel(100);

    }

    //GETTERS AND SETTERS//
    public int getTrailLength() {
        return trailLength;
    }

    public void setTrailLength(int trailLength) {
        this.trailLength = trailLength;
    }

    public ArrayList<Point> getTrail() {
        return trail;
    }

    public void setTrail(ArrayList<Point> trail) {
        this.trail = trail;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean hasShield() {
        return shield;
    }

    public void setShield(boolean shield) {
        this.shield = shield;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

}
