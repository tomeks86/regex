package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlienUsername {
    public static void main(String[] args) {
        String name = "_0898989811abced_";
        Pattern pattern = Pattern.compile("[._]\\d+[a-zA-Z]*_?");
        Matcher matcher = pattern.matcher(name);
        System.out.println(matcher.matches());
    }
}
