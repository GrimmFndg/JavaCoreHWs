public class Main {

    public static void main(String[] args) {

        String  [][] arr1 = new String[4][4];
        arr1 [0][0] = "1";
        arr1 [0][1] = "2";

//3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и
// MyArrayDataException и вывести результат расчета.

        try{
            catchArrayBounds(arr1);
        }catch (MyArraySizeException ex){
            System.out.println("Массив не соотвтствует условиям.");
        }

        try{
            catchDataException(arr1);
        }catch (MyArrayDataException ex){
            System.out.println("Преобразовать данные не удалось");
        }

        catchArrayBounds (arr1);

        catchDataException(arr1);


        System.out.println(arr1[0][0]);
    }


//1.Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
// При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
    public static void catchArrayBounds  (String a [][]) throws MyArraySizeException {
        int resultI = 0;
        int resultJ = 0;

        for (int i = 0; i < a.length; i++) {
            resultI = (i+1);
            for (int j = 0; j < a[i].length; j++) {     //Проверяем границы массива
                resultJ = (j+1);
            }
        }

        if ((resultI == 4)&&(resultJ == 4)){
            System.out.println("Массив соответствует условиям");
        }else{
            throw new MyArraySizeException ();
        }

    }

//2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
// должно быть брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.

    public static int catchDataException (String a [][]) throws MyArrayDataException{

        int sum = 0;

        for (int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){


                try {
                    sum += Integer.parseInt(a[i][j]);
                }catch (NumberFormatException ex){
                    System.out.println("Координаты ошибочного преобразования " + i + " " + j);
                    sum += 0;
                    throw new MyArrayDataException();

                }

            }
        }

        return sum;

    }

}


