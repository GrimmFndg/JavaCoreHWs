package Theme_3;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

    HashMap<String,Integer> phonebook = new HashMap<>();


    public void addNumber (String _suname, int _number){
       phonebook.put(_suname,_number);
    }

    public void removeNumber(String _suname,int _number){
        phonebook.remove(_suname,_number);
    }

    public void foundNumber (String _suname) {
        int counter = 0;
        ArrayList<Integer> contacts = new ArrayList<>();

        do {
            System.out.println(phonebook.get(_suname));
            contacts.add(phonebook.get(_suname));
            counter++;
            phonebook.remove(_suname);
        } while (phonebook.containsKey(_suname));

        if (counter != 0) {
            System.out.println("Найдены номера под фамилией " + _suname);
            for (int i = 0; i < counter; i++) {
                System.out.println(contacts.get(i));
            }


        }
    }
}
