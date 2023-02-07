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
            System.out.println("�������� �������� ����������:");
            System.out.println("1)������");
            System.out.println("2)�������� ��������");
            System.out.println("3)�������");
            System.out.println("0)�����");
            System.out.println("������� �����:");
            int answer = scanner.nextInt();
            switch (answer) {
                case 1:
                    return new Caesar();
                case 2:
                    return new RailFence();
                case 3:
                    return new Vigenere();
                case 0:
                    System.out.println("��������� ��������!");
                    System.exit(0);
                default:
                    System.out.println("��������� �� ������!!");

            }
        }
    }
}
