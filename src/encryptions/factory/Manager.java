package encryptions.factory;

import encryptions.impls.Caesar;
import encryptions.interf.Encryption;

import java.util.Scanner;

public class Manager {

    public static Encryption getEncryption(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("�������� �������� ����������:");
        System.out.println("1)������");
        System.out.println("2)�������� ����������");
        System.out.println("0)�����");
        System.out.println("������� �����:");
        int answer = scanner.nextInt();
        switch (answer){
            case 1:
                return new Caesar();
            case 0:
                System.out.println("��������� ��������!");
                System.exit(0);
            default:
                System.out.println("��������� �� ������!!");
                return null;

        }
    }
}
