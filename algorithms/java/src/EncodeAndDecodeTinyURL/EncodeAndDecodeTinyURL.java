//https://leetcode-cn.com/problems/encode-and-decode-tinyurl/

package EncodeAndDecodeTinyURL;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Note: This is a companion problem to the System Design problem:
 * Design TinyURL.
 * TinyURL is a URL shortening service where you enter a URL such
 * as https://leetcode.com/problems/design-tinyurl and it returns
 * a short URL such as http://tinyurl.com/4e9iAk.
 * <p>
 * Design the encode and decode methods for the TinyURL service.
 * There is no restriction on how your encode/decode algorithm
 * should work. You just need to ensure that a URL can be encoded
 * to a tiny URL and the tiny URL can be decoded to the original
 * URL.
 */
public class EncodeAndDecodeTinyURL {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println((int) (Math.random() * 10));
        }
    }

}


/**
 * use index  1、2...
 * THIS IS A BAD METHOD, The tinyURL should be random
 */

class Codec {

    Long index = new Long(1);

    Map<Long, String> url = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        index++;
        url.put(index, longUrl);
        return String.valueOf(index);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String longUrl = url.get(Long.valueOf(shortUrl));
        return longUrl;
    }


}

class TinyURL {

    //62^6 =56,800,235,584
    private static String[] chars = new String[]{"a", "b", "c", "d", "e", "f", "g", "h",
            "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"
    };

    private static Map<String, String> urlMappingMap = new HashMap<>(2048);

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuilder shortUrl = new StringBuilder();
        for (; ; ) {
            for (int i = 0; i < 6; i++) {
                shortUrl = shortUrl.append(chars[(int) (Math.random() * 62)]);
            }
            if (!urlMappingMap.containsKey(shortUrl)) {
                urlMappingMap.put(shortUrl.toString(), longUrl);
                return shortUrl.toString();
            }
        }
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String longUrl = urlMappingMap.get(shortUrl);
        return longUrl;
    }


}


//TODO
//洗牌算法
//散列算法
//图形旋转算法