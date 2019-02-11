package Theme_1.Obstacles;

import Theme_1.Animals.*;
import Theme_1.Participants.Participant;

public class Cross extends Obstacle {

    private final String type = "Cross";
    private int distance;

    public Cross(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
    public String getType() {
        return this.type;
    }

    @Override
    public void isGoThrough() {

           }
}
