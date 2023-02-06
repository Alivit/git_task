package encryptions.impls;

import encryptions.interf.Encryption;

import java.util.Scanner;

public class RailFence implements Encryption {

    private int key;
    private Scanner scanner = new Scanner(System.in);
    char storage[][];

    @Override
    public StringBuilder encoder(String message) {
        StringBuilder result = new StringBuilder();

        boolean trend = false;
        int row = 0, col = 0;

        System.out.println("¬ведите новый ключ:");
        key = scanner.nextInt();
        storage = new char[key][message.length()];

        for (char character : message.toCharArray()){
            if (row == 0 || row == key-1)
                trend = !trend;
            storage[row][col++] = character;
            row = trend ? row + 1 : row - 1;
        }

        for (int i = 0; i < key; i++)
            for (int j = 0; j < message.length(); j++){
                if (storage[i][j] != '\u0000')
                    result.append(storage[i][j]);
            }
        return result;
    }

    @Override
    public StringBuilder decoder(String str) {
        return null;
    }
}
