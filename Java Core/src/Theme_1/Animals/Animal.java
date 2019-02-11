package Theme_1.Animals;

import Theme_1.Obstacles.Cross;
import Theme_1.Participants.Participant;

public abstract class Animal implements Participant {

    public static Object runThroughDistance;
    String name;
    private int maxRunDistance;
    private int maxJumpHeight;
    private int maxSwimDistance;
    private boolean onDistance = true;

    public Animal(String name, int maxRunDistance, int maxJumpHeight, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
    }

    public boolean isOnDistance(){
        return onDistance;
    }

    @Override
    public void runThroughCross(Cross cross){
        if (this.maxRunDistance < cross.getDistance()) {
            this.onDistance = false;
        }
    }

    @Override
    public void jumpOverObstacle (int Height){
        if (this.maxJumpHeight < Height){
            this.onDistance = false;
        }
    }

    @Override
    public void swimThroughWaterPool (int Distance){
        if (this.maxSwimDistance < Distance){
            this.onDistance = false;
        }
    }

    public abstract void getName ();

    }
