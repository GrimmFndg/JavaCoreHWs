package Theme_1.Obstacles;

public class WaterPool extends Obstacle{

    private final String type = "Water Pool";
    private int distance;

    public WaterPool(int distance) {
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
