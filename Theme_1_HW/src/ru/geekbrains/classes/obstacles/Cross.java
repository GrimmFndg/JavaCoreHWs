package ru.geekbrains.classes.obstacles;

import ru.geekbrains.classes.Participant;
import ru.geekbrains.classes.animals.Animal;

public class Cross extends Obstacle {

    private int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Participant animal) {
        animal.run(length);
    }

    @Override
    public  void doIt(Participant[] team){
        for (int i = 0; i < team.length; i++){
           team[i].run(length);
        }
    }
}
