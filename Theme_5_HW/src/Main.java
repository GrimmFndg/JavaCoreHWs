import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        method1();
        method2();

    }


    public static void method1 (){

        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];

        for (int i = 0; i < size; i++){
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        System.out.println("method 1 a: " + a);
        //--------------------------------------

        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("method 1 full time: " + System.currentTimeMillis());
        System.out.println("method 1 refilling time: " + (System.currentTimeMillis() - a));
        System.out.println("---------------------");
    }

    public static void method2 () throws InterruptedException {

        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        float[] timedArr1 = new float[h];
        float[] timedArr2 = new float[h];


        for (int i = 0; i < size; i++){
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        System.out.println("method 2 a: " + a);
        //----------------------------------------

        System.arraycopy(arr, 0, timedArr1, 0, h);
        System.arraycopy(arr, h, timedArr2, 0, h);

        Thread thr1 = new Thread(new Runnable() {
            @Override
            public void run() {                       //Первый поток
                for (int i = 0; i < h; i++) {
                    timedArr1[i] = (float) (timedArr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println("Thread completed");
            }
        });
        thr1.start();

        Thread thr2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < h; i++) {
                    timedArr2[i] = (float) (timedArr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println("Thread completed");
            }

        });
        thr2.start();


        thr1.join();
        thr2.join();
        System.arraycopy(timedArr1, 0, arr, 0, h);
        System.arraycopy(timedArr2, 0, arr, h, h);
        System.out.println("method 2 full time: " + System.currentTimeMillis());
        System.out.println("method 2 refilling time: " + (System.currentTimeMillis() - a));
        System.out.println("---------------------");

    }
}
