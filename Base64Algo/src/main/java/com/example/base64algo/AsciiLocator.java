package com.example.base64algo;
import java.util.HashMap;
public class AsciiLocator {

    private HashMap<String, Integer> binaryDecimalMap = new HashMap<>();
    private HashMap<Integer, Character> decimalLetterMap = new HashMap<>();


    public AsciiLocator() {
        generateDecimalMap();
        generateLetterMap();
    }

    private void generateLetterMap() {
        for (int i = 0; i < 64; i++) {
            char character;
            if (i < 26) {
                character = (char) ('A' + i);
            } else if (i < 52) {
                character = (char) ('a' + i - 26);
            } else if (i < 62) {
                character = (char) ('0' + i - 52);
            } else if (i == 62) {
                character = '+';
            } else {
                character = '/';
            }
            decimalLetterMap.put(i, character);
        }
    }

    private void generateDecimalMap() {
        for (int i = 0; i < 128; i++) {
            String binaryValue = String.format("%8s", Integer.toBinaryString(i)).replace(' ', '0');
            binaryDecimalMap.put(binaryValue, i);
        }
    }

    public int getAsciiDecimal(String binaryToFind) {
        return binaryDecimalMap.get(binaryToFind);
    }

    public char getAsciiLetter(int letterToFind) {
        return decimalLetterMap.get(letterToFind);
    }

}