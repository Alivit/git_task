package encryptions.factory;

import encryptions.impls.Caesar;
import encryptions.impls.RailFence;
import encryptions.impls.Vigenere;
import encryptions.interf.Encryption;

import java.util.Scanner;

public class Manager {

    public static Encryption getEncryption(){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите Алгоритм Шифрования:");
            System.out.println("1)Цезарь");
            System.out.println("2)Железная изгородь");
            System.out.println("3)Виженер");
            System.out.println("0)Выход");
            System.out.println("Введите число:");
            int answer = scanner.nextInt();
            switch (answer) {
                case 1:
                    return new Caesar();
                case 2:
                    return new RailFence();
                case 3:
                    return new Vigenere();
                case 0:
                    System.out.println("Программа окончена!");
                    System.exit(0);
                default:
                    System.out.println("Шифровщик не найден!!");

            }
        }
    }
}
