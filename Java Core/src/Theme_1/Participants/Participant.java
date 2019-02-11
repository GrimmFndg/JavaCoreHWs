package Theme_1.Participants;
import Theme_1.Obstacles.*;

public interface Participant {

    boolean isOnDistance();

    void runThroughCross(Cross cross);

    void jumpOverObstacle (int Height);

    void swimThroughWaterPool (int Distance);

    void getName();


}
