package Theme_1.Obstacles;

import Theme_1.Participants.Participant;

public abstract class Obstacle {

    String type;

    public String getType() {
        return type;
    }

    public abstract void isGoThrough();
    private void showCourseInfo (Obstacle [] course){

        for (int i = 0; i < course.length; i++){
            System.out.printf("%d obstacle - %s // meters height", i, course[i].getType());
        }
    }
}
