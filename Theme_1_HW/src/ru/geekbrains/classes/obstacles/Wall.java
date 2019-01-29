package ru.geekbrains.classes.obstacles;

import ru.geekbrains.classes.Participant;
import ru.geekbrains.classes.animals.Animal;

public class Wall extends Obstacle {

    private int height;

    public Wall(int height) {
        super();
        this.height = height;
    }

    @Override
    public void doIt(Participant participant) {
        participant.jump(height);
    }

    @Override
    public  void doIt(Participant[] team){
        for (int i = 0; i < team.length; i++){
            team[i].jump(height);
        }
    }
}
