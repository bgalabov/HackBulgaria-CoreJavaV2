package com.hackbulgaria.corejava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebsiteCrawler {

    public static void search(String str, String needle) throws IOException {
        URL url = new URL(str);
        String domain = url.toString();
        StringBuilder strBldr = new StringBuilder();
        String s;
        List<String> visited = new LinkedList<String>();
        List<String> links = new LinkedList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        do {
            s = br.readLine();
            strBldr.append(s);
        } while (s != null);
        s = strBldr.toString();
        links = getAllLinks(s);
        for (String next : links) {
            if (next.contains("http")) {
                if (!next.contains(domain)) {
                    continue;
                }
            }
            if (next.contains("/")) {
                next = next.substring(next.lastIndexOf("/") + 1);
            }

            URL nextUrl = new URL(domain + next);

            if (!visited.contains(nextUrl.toString())) {
                visited.add(nextUrl.toString());
                searchInLink(nextUrl, needle);
            }

        }
    }

    private static List<String> getAllLinks(String content) {
        ArrayList<String> resultList = new ArrayList<>();
        String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            resultList.add(matcher.group(1));
        }
        return resultList;
    }

    private static void searchInLink(URL url, String needle) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
        String s;
        StringBuilder strBldr = new StringBuilder();
        do {
            s = br.readLine();
            strBldr.append(s);
        } while (s != null);
        br.close();
        s = strBldr.toString();
        if (s.contains(needle)) {
            System.out.println(url.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        WebsiteCrawler.search("http://ebusiness.free.bg/", ".");
    }

}
