//Created by Grimm
//GrimmFndg@gmail.com

package Theme_2;
public class Theme_2_Main {

    static String arr1[][] = {
            {"1", "1", "1", "1"},
            {"1", "1", "1", "1"},
            {"1", "1", "1", "1"},
            {"1", "1", "1", "1"},
    };

    public static void main(String[] args) {

        try {
                catchArrayBounds(arr1);
            } catch (MyArraySizeException ex) {
                System.out.println("Массив не соотвтствует условиям.");
            }

        try {
                catchDataException(arr1);
            } catch (MyArrayDataException ex) {
                System.out.println("Преобразовать данные не удалось");
        }
    }



    public static void catchArrayBounds  (String a [][]) throws MyArraySizeException {
        int resultJ = 0;

        if (a.length != 4){
            throw new MyArraySizeException ();
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                resultJ = (j+1);
            }
            if (resultJ != 4){
                System.out.println("Массив не соответствует требованиям");
                throw new MyArraySizeException ();
            }
            resultJ = 0;
        }
    }
    public static void catchDataException (String a [][]) throws MyArrayDataException{
        int sum = 0;
        for (int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){
                try {
                        sum += Integer.parseInt(a[i][j]);
                    }catch (NumberFormatException ex){
                        System.out.println("Координаты ошибочного преобразования " + i + " " + j);
                        throw new MyArrayDataException();
                    }
            }
        }
        System.out.println("Сумма всех элементов равна: " + sum);
    }
}

