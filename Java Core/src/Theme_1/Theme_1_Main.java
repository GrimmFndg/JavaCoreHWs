//Created by Grimm
//GrimmFndg@gmail.com

//TODO: 1. Обьяъвить классы Cat, Dog, AnimalMechBot
//      2. Объявить классы Wall, Cross, WaterPool
//      3. Обьеденить участников в команды
//      4. Реализовать командные состязания по полосам препятствий.
//      5. Реализовать методы для вывода информации об участниках команды, победителях.

//TODO: 1. Реализовать способ получения информации о полосе препятствий и участниках
//      2. Реализовать проведение состязаний.

package Theme_1;

import Theme_1.Animals.*;
import Theme_1.Participants.*;
import Theme_1.Obstacles.*;

public class Theme_1_Main {

    public static void main(String[] args) {

        Participant [] tmA = new Participant[]{
                new Dog("dog1",15,7,8),
                new Cat("cat1",10,15,0),
                new AnimalMechBot("alpha",20, 20, 20),
        };
        Team teamA = new Team("Team A",tmA);


        Cross cross = new Cross(9);
        Wall wall = new Wall(9);
        WaterPool pool = new WaterPool(10);

        Obstacle [] course1 = {cross,wall,pool};

        ObstacleCourse c1 = new ObstacleCourse(course1);

        //------------------------------------------------------------------------------------------------------------





       //Реализовать получение информации об участниках и маршруте.

        System.out.println();
    }

}
