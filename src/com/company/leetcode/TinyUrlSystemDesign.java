package com.company.leetcode;

/**
 * http://blog.gainlo.co/index.php/2016/03/08/system-design-interview-question-create-tinyurl-system/
 * https://leetcode.com/discuss/interview-question/124658/Design-a-URL-Shortener-(-TinyURL-)-System/
 */

import java.util.HashMap;
import java.util.Map;

public class TinyUrlSystemDesign {
    public static void main(String[] args) {
        TinyUrlSystemDesign tinyUrlSystemDesign = new TinyUrlSystemDesign();
        System.out.println(tinyUrlSystemDesign.encode("google"));
        System.out.println(tinyUrlSystemDesign.encode("linkedin"));
        System.out.println(tinyUrlSystemDesign.decode("c"));
        System.out.println(tinyUrlSystemDesign.decode("b"));

    }

    private static final String urlGuid = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private Map<String, String> map;
    private int i ;

    public TinyUrlSystemDesign() {
        map=new HashMap<>();
        i = 0;
    }

    public String encode(String longUrl) {
        i++;
        String shortUrl = base62_encode(i);
        map.put(shortUrl,longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

    public static String base62_encode( int id){
        StringBuilder sb = new StringBuilder();
         while (id > 0){
             sb.insert(0,urlGuid.charAt(id%62));
             id=id/62;
         }
        return sb.toString();
    }
}
