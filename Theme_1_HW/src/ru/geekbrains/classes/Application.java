package ru.geekbrains.classes;

import ru.geekbrains.classes.animals.*;
import ru.geekbrains.classes.obstacles.*;
public class Application {

    public static void main(String[] args) {
        Participant [] participants = new Participant[]{
                new Cat("cat1" , 10,10,0),
                new Dog("dog1",20,7,20),
                new Cat("cat2",8,8,0),
                new Robot("robot",50,50,50)
        };

        Obstacle[] obstacles = new Obstacle[]{
                new Cross(5),
                new Wall(8),
                new Water(10)
        };

        Course course = new Course(obstacles);
        Team team = new Team ("Team A",participants);
        course.doIt(team);

        team.getResults();

    }

}
