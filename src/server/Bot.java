package server;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Fabian Montero on 08-Oct-16.
 */
public class Bot extends User{

    public Bot(int x, int y, ArrayList<Point> trail, int trailLength, int direction, boolean disabled, int speed , String nickName , boolean shield , int fuel) {
        super(x, y, trail, trailLength, direction, disabled, speed , nickName , shield , fuel);
    }


    public void reset(int x , int y){

        this.x = x;
        this.y = y;
        this.trail = new ArrayList<Point>();
        this.trailLength = 8;
        this.direction = DOWN;
        this.disabled = false;
        this.fuel = 100;

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

}


