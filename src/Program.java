import encryptions.factory.Manager;
import encryptions.interf.Encryption;
import logic.InputLogic;
import logic.OutputLogic;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        OutputLogic out = new OutputLogic();
        InputLogic in = new InputLogic();
        Scanner scanner = new Scanner(System.in);

        StringBuilder result;
        String message;
        while (true) {
            message = in.input();
            Encryption encryption = Manager.getEncryption();
            result = encryption.encoder(message);
            out.view(message, result);
            System.out.println("Дешифровать?(y/n)");
            String choice = scanner.nextLine();
            if (choice.equals("y")){
                message = String.valueOf(result);
                result = encryption.decoder(message);
                out.view(message, result);
            }
        }

    }
}
