package encryptions.factory;

import encryptions.impls.Caesar;
import encryptions.interf.Encryption;

import java.util.Scanner;

public class Manager {

    public static Encryption getEncryption(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите Алгоритм Шифрования:");
        System.out.println("1)Цезарь");
        System.out.println("2)Железное огрождение");
        System.out.println("0)Выход");
        System.out.println("Введите число:");
        int answer = scanner.nextInt();
        switch (answer){
            case 1:
                return new Caesar();
            case 0:
                System.out.println("Программа окончена!");
                System.exit(0);
            default:
                System.out.println("Шифровщик не найден!!");
                return null;

        }
    }
}
