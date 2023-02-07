package encryptions.impls;

import encryptions.interf.Encryption;

import java.util.Scanner;

public class Caesar implements Encryption {

    private int key;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public StringBuilder encoder(String message) {
        StringBuilder result = new StringBuilder();
        System.out.println("������� ����� ����:");
        key = scanner.nextInt();
        for (char character : message.toCharArray()) {
            if(character >= 'a' && character <= 'z'){
                int position = character - 'a';
                int newPosition = (position + key) % 26;
                char newCharacter = (char) ('a' + newPosition);
                result.append(newCharacter);
            } else if(character >= 'A' && character <= 'Z') {
                int position = character - 'A';
                int newPosition = (position + key) % 26;
                char newCharacter = (char) ('A' + newPosition);
                result.append(newCharacter);
            } else if(character >= '�' && character <= '�') {
                int position = character - '�';
                int newPosition = (position + key) % 32;
                char newCharacter = (char) ('�' + newPosition);
                result.append(newCharacter);
            } else if(character >= '�' && character <= '�') {
                int position = character - '�';
                int newPosition = (position + key) % 32;
                char newCharacter = (char) ('�' + newPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result;
    }

    @Override
    public StringBuilder decoder(String message) {
        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (character >= 'a' && character <= 'z') {
                int position = character - 'a';
                int newPosition = ((position - key) % 26);
                if (newPosition < 0) newPosition += 26;
                char newCharacter = (char) ('a' + newPosition);
                result.append(newCharacter);
            }else if (character >= 'A' && character <= 'Z') {
                int position = character - 'A';
                int newPosition = ((position - key) % 26);
                if (newPosition < 0) newPosition += 26;
                char newCharacter = (char) ('A' + newPosition);
                result.append(newCharacter);
            } else if (character >= '�' && character <= '�') {
                int position = character - '�';
                int newPosition = ((position - key) % 32);
                if (newPosition < 0) newPosition += 32;
                char newCharacter = (char) ('�' + newPosition);
                result.append(newCharacter);
            } else if (character >= '�' && character <= '�') {
                int position = character - '�';
                int newPosition = ((position - key) % 32);
                if (newPosition < 0) newPosition += 32;
                char newCharacter = (char) ('�' + newPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result;
    }
}
