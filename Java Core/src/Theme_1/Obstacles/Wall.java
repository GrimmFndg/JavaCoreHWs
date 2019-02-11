package Theme_1.Obstacles;

public class Wall extends Obstacle {

    private final String type = "Wall";
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
    public String getType() {
        return this.type;
    }

    @Override
    public void isGoThrough() {

    }
}
