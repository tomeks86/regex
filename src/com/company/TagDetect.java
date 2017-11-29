package com.company;

import java.io.*;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagDetect {
    public static void main(String[] args) {
        TreeSet<String> tags = new TreeSet<>();
        Pattern tag = Pattern.compile("<[ \t/]*?(\\w+).*?>");
        Matcher matcher = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line = null;

        try {
            br = new BufferedReader(new FileReader(TagDetect.class.getResource("tags1.txt").getFile()));
            bw = new BufferedWriter(new FileWriter(new File("tag.out")));
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                line = br.readLine();
                matcher = tag.matcher(line);
                while (matcher.find()) {
                    tags.add(matcher.group(1));
                }
            }
            if (br != null) br.close();
            if (bw != null) bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(String.join(";", tags));
    }
}
