package logic;

import java.util.Scanner;

public class InputLogic {
    private String str = null;

    public String input(){
        Scanner scanner = new Scanner(System.in);
        if(str == null){
            System.out.println("������� �����: ");
            str = scanner.nextLine();}
        else{
            System.out.println("������ ����� �����?(y/n)");
            String choice = scanner.nextLine();
            if (choice.equals("y")){
                System.out.println("������� �����: ");
                str = scanner.nextLine();
            }
        }
        return str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
