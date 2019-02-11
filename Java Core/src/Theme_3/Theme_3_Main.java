//Created by Grimm
//GrimmFndg@gmail.com


//TODO: 2. Реализовать поиск и запись однофамильцев.

package Theme_3;

import java.util.ArrayList;

public class Theme_3_Main {
    public static void main(String[] args) {

        String [] wordbook = {"walls","coach","inside","farm","me",
                              "walls","coach","inside","farm","me"};
       // foundUniqeWords(wordbook);


        PhoneBook book = new PhoneBook();
        book.addNumber("Бабахин",161498441);
        book.addNumber("Бабахин",161498442);
        book.addNumber("Бабахин",161498443);
        book.foundNumber("Бабахин");

    }
    public static void foundUniqeWords(String[] words){
        ArrayList<String> uniqeWords = new ArrayList<>();
        int uniqeWordsCounter = 0;

        for (int i = 0; i < words.length; i++){
            if (!uniqeWords.contains(words[i])){
                uniqeWords.add(words[i]);
                uniqeWordsCounter++;
            }
        }

        System.out.println("Количество уникальных слов: " + uniqeWordsCounter);

        for (int i = 0; i < uniqeWordsCounter; i++){
            System.out.println(uniqeWords.get(i));
        }
    }

}
