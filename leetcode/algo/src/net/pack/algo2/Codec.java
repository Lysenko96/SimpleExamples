package net.pack.algo2;

import java.util.Base64;

public class Codec {

    public static void main(String[] args) {
        Codec codec = new Codec();
        System.out.println(codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl")));
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        return Base64.getEncoder().encodeToString(longUrl.getBytes());
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return new String(Base64.getDecoder().decode(shortUrl));
    }


}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));