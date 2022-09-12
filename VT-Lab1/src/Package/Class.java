package Package;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Class {
    /**
     * Перевод из десятичной в двоичную систему;
     */
    public static void perevod(int n) {
        String temp = "";         //строка для ответа;
        int b;
        int g = n;
        while (n != 0) {          //по формуле в двоичную систему;
            b = n % 2;            //b присваеваем остаток;
            n = n / 2;            //n делим на 2;
            temp = b + temp;      //складываю в строку;
        }
        System.out.println(temp);  //вывожу перевернутую строку;

        /**
         * Загрузка во внешний файл входных значений (сериализация);
         */
        try {
            FileOutputStream fos = new FileOutputStream("src/Package/input.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject("input: " + g);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * Загрузка во внешний файл выходных значений (сериализация);
         */
        try {
            FileOutputStream fos = new FileOutputStream("src/Package/output.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject("output" + temp);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Семенов Егор АТ-212\n P10: ");
        int a = new Scanner(System.in).nextInt(); //Ввод десятичного числа;
        if (a > 99999) {             //Разрядность должна быть 5 (длина числа);
            System.out.println("Число не 5-го разряда");
        } if (a < 10000) {
            System.out.println("Число не 5-го разряда");
        } else {
            System.out.println("P2 = ");
            perevod(a);             //Вывод ответа;
        }
    }
}

