package com.company;

public class FindAllSubwords {
    public static void main(String[] args) {
        String line = "existing pessimist optimist this is";
        System.out.println(line.split("(?<=\\w)is(?=\\w)").length - 1);
    }
}
