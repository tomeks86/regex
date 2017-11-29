package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AHrefTags {

    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        LinkedList<String> lines = new LinkedList<>();

        String pattern = "<a.*?href=\"(.*?)\".*?>(.*?)</a>";
        Pattern myPattern = Pattern.compile(pattern);

        try {
            br = new BufferedReader(new FileReader(new File(AHrefTags.class.getResource("test5.txt").getFile())));
            bw = new BufferedWriter(new FileWriter(new File("test.out")));
            String line;
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                line = br.readLine();
                Matcher match = myPattern.matcher(line);
                while (match.find()) {
                    bw.write(match.group(1) + "," + match.group(2).trim().replaceAll("<.*?>", "") + "\n");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
                if (bw != null) bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String patt = "(\\d+)";
        List<String> allMatches = new ArrayList<>();
        Pattern myPatt = Pattern.compile("(\\d+)");
        Matcher match = myPatt.matcher("324324dsrwf23fwe32fw");
        while(match.find()) {
            allMatches.add(match.group());
        }
        System.out.println(allMatches.toString());
        System.out.println("<b>abc</b>".replaceAll("<.*?>", ""));
    }
}
