package encryptions.impls;

import encryptions.interf.Encryption;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Vigenere implements Encryption {

    private String key;
    private Scanner scanner = new Scanner(System.in);


    @Override
    public StringBuilder encoder(String message) {

        StringBuilder result = new StringBuilder();
        System.out.println("Введите новый ключ(слово):");
        key = scanner.nextLine();

        int index = 0;
        //смещ
        int bias = 0;
        Map<Integer, Integer> numKey = new TreeMap<>();
        for (int i = 0; i < key.length(); i++) {
            //возвращает символ по заданному индексу внутри строки
            int position = key.charAt(i);
            //Возвращает логическое значение true, если вызывающий словарь содержит значение value
            int asciiWithBias = numKey.containsValue(position + bias)
                    ? position + ++bias : position + bias;
            //Добавление новой пары в Map
            numKey.put(i, asciiWithBias);
//            System.out.print(i+"");
//            System.out.print(asciiWithBias);
        }

        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < message.length() / key.length() + message.length() % key.length(); i++) {
            Map<Integer, Character> charPos = new TreeMap<>();
            //возвращает множество(Set) наборов “ключ-значение”
            //entrySet(), объявленный интерфейсом Map, возвращает Set, содержащий записи Map. Каждый из этих элементов является объектом Map
            for (Map.Entry<Integer, Integer> asciiByIndex : numKey.entrySet()) {
                if (index == message.length()) {
                    break;
                }
                charPos.put(asciiByIndex.getValue(), message.charAt(index++));
//                System.out.print(asciiByIndex.getValue());
            }
            charPos.forEach((keyVal, value) -> list.add(value));

        }

        for (char character : list){
            result.append(character);
        }
        return result;
    }

    @Override
    public StringBuilder decoder(String str) {
        return null;
    }
}
