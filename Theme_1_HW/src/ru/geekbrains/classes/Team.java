package ru.geekbrains.classes;
import ru.geekbrains.classes.animals.*;

public class Team {

    private final String  name;
    private final Participant [] participants;

    Team (String _name, Participant [] _participants){
        this.name = _name;
        this.participants = _participants;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public void getResults(){
        System.out.printf("Итоги для команды %s:%n", name);
        for(Participant participant : participants){
            System.out.println(participant);
        }
    }
}
