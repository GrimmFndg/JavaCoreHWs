package Theme_5;
import java.util.Arrays;

public class Main {

    static final int SIZE = 10_000_000;
    static float[] ARR = new float[SIZE];

    public static void main(String[] args) throws InterruptedException {

        isUseTreadsWhileRefilling(true);
        isUseTreadsWhileRefilling(false);

    }

    private static void isUseTreadsWhileRefilling (boolean isUsingThreads) throws InterruptedException {
        Arrays.fill(ARR,1);

        if (isUsingThreads){

            long timeStart = System.currentTimeMillis();
            int h = SIZE / 2;

            float[] timedArr1 = new float[h];
            float[] timedArr2 = new float[h];
            System.arraycopy(ARR, 0, timedArr1, 0, h);
            System.arraycopy(ARR, h, timedArr2, 0, h);


            Thread thr1 = new Thread(new Runnable() {
                @Override
                public void run() {                       //Первый поток
                    for (int i = 0; i < h; i++) {
                        timedArr1[i] = (float) (timedArr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    }
                }
            });
            thr1.start();

            Thread thr2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < h; i++) {
                        timedArr2[i] = (float) (timedArr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    }
                }

            });
            thr2.start();


            thr1.join();
            thr2.join();
            System.arraycopy(timedArr1, 0, ARR, 0, h);
            System.arraycopy(timedArr2, 0, ARR, h, h);

            System.out.println("Refilling time with using Threads: " + (System.currentTimeMillis() - timeStart));
        }else{
            long timeStart = System.currentTimeMillis();
            for (int i = 0; i < SIZE; i++) {
                ARR[i] = (float) (ARR[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Refilling time with no using Threads: " + (System.currentTimeMillis() - timeStart));
        }

    }

    /*private static void splitCalculationWithThreads (int threadsCount){
        int

        for (int i = 0; i <= threadsCount; i++){




            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = startPoint; i < endPoint; i++ ){
                        ARR[i] = (float) (ARR[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    }
                }
            })
        }

    }*/

    private void divideArrayParts (int numberOfParts){

        int partLength = ARR.length / numberOfParts;
        int startPoint = 0;
        int endPoint = partLength;

        for (int i = 0; i < numberOfParts; i++){



        }


    }

}

