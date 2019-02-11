package Theme_1.Participants;
import Theme_1.Animals.*;

public class Team {

    public String name;
    Participant [] team;

    public Team(String name, Participant[] team) {
        this.name = name;
        this.team = team;
    }

    public void getResults(){
        System.out.printf("Итоги для команды %s:%n", name);
        for(Participant participant : team){
            System.out.println(participant);
        }
    }

}
