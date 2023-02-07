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
        System.out.println("������� ����� ����(�����):");
        key = scanner.nextLine();

        int index = 0;
        //����
        int bias = 0;
        Map<Integer, Integer> numKey = new TreeMap<>();
        for (int i = 0; i < key.length(); i++) {
            //���������� ������ �� ��������� ������� ������ ������
            int position = key.charAt(i);
            //���������� ���������� �������� true, ���� ���������� ������� �������� �������� value
            int asciiWithBias = numKey.containsValue(position + bias)
                    ? position + ++bias : position + bias;
            //���������� ����� ���� � Map
            numKey.put(i, asciiWithBias);
//            System.out.print(i+"");
//            System.out.print(asciiWithBias);
        }

        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < message.length() / key.length() + message.length() % key.length(); i++) {
            Map<Integer, Character> charPos = new TreeMap<>();
            //���������� ���������(Set) ������� �����-��������
            //entrySet(), ����������� ����������� Map, ���������� Set, ���������� ������ Map. ������ �� ���� ��������� �������� �������� Map
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
    public StringBuilder decoder(String message) {
        StringBuilder result = new StringBuilder();
        char[] output = new char[message.length()];

        int bias = 0;
        Map<Integer, Integer> numKey = new TreeMap<>();
        for (int i = 0; i < key.length(); i++) {
            //���������� ������ �� ��������� ������� ������ ������
            int position = key.charAt(i);
            //���������� ���������� �������� true, ���� ���������� ������� �������� �������� value
            int asciiWithBias = numKey.containsValue(position + bias)
                    ? position + ++bias : position + bias;
            //���������� ����� ���� � Map
            numKey.put(i, asciiWithBias);
        }

        Map<Integer, Integer> indexesByAscii = new TreeMap<>();
        numKey.forEach((key, value) -> indexesByAscii.put(value, key));

        int messageIndex = 0;
        int step = 0;

        for (int i = 0; i < message.length() / key.length() + message.length() % key.length(); i++) {
            //�������� ������ � ������� �� �����
            //entrySet ���������� Set, ���������� ������ Map. ������ �� ���� ��������� �������� �������� Map
            for (Map.Entry<Integer, Integer> indexByAscii : indexesByAscii.entrySet()) {
                if (messageIndex > message.length() - 1) {
                    break;
                }
                if (indexByAscii.getValue() + step >= message.length()) {
                    continue;
                }
                //������, ������������� �� ���������� ������� ������
                output[indexByAscii.getValue() + step] = message.charAt(messageIndex++);
            }
            step += key.length();
        }
        result =new StringBuilder(String.valueOf(output));
        return result;
    }
}
