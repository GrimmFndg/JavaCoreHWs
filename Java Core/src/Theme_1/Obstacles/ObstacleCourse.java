package Theme_1.Obstacles;

public class ObstacleCourse  {

    private Obstacle [] course;

    public ObstacleCourse(Obstacle [] obstacles ) {
        course = obstacles;
       // difficulty = calculateDifficultyLvl(cross,wall,waterPool);
    }

    private int calculateDifficultyLvl(Cross cross,Wall wall,WaterPool waterPool){

        int difficultyLvl = cross.getDistance() + wall.getHeight() + waterPool.getDistance()/3;
        return difficultyLvl;
    }

    private void showCourseInfo (Obstacle [] course){
     //   System.out.println("Course's difficulty lvl is " + this.difficulty);
        for (int i = 0; i < course.length; i++){
            System.out.printf("%d obstacle - %s // meters height", i, course[i].getType());
        }
    }

}
