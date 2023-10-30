package com.example.base64algo;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static String encode(String aString) {
        ArrayList<String> arr = convertToBinary(parseOutString(aString));
        AsciiLocator al = new AsciiLocator();
        String finalEncoding = "";
        for (String each : addZerosInFront(regroup(concatBinaryStrings(arr)))) {
            finalEncoding += al.getAsciiLetter(al.getAsciiDecimal(each));
        }

        return finalEncoding;
    }

    private static char[] parseOutString(String aString) {
        return aString.toCharArray();
    }

    private static ArrayList<String> addZerosInFront(ArrayList<String> sixGroupArray) {
        ArrayList<String> newBinaryList = new ArrayList<>();
        for (String each : sixGroupArray) {
            while (each.length() < 8) {
                each = "0" + each;
            }
            newBinaryList.add(each);
        }
        return newBinaryList;
    }

    private static ArrayList<String> regroup(String binaryString) {
        ArrayList<String> groupsOfSix = new ArrayList<>();

        for (int i = 0; i < binaryString.length(); i += 6) {
            int endIndex = Math.min(i + 6, binaryString.length());
            String group = binaryString.substring(i, endIndex);
            if (group.length() < 6) {
                while (group.length() < 6) {
                    group = group.concat("0");
                }
            }
            groupsOfSix.add(group);
        }
        return groupsOfSix;
    }

    private static String concatBinaryStrings(ArrayList<String> binaryArray) {
        String binaryString = "";
        for (String each : binaryArray) {
            binaryString = binaryString.concat(each);
        }
        return binaryString;
    }

    private static ArrayList<String> convertToBinary(char[] charArray) {
        ArrayList<String> binaryArray = new ArrayList<>();
        for(int i = 0; i < charArray.length; i++) {
            binaryArray.add(String.format("%8s", Integer.toBinaryString(charArray[i])).replace(' ', '0'));
        }

        return binaryArray;
    }
}