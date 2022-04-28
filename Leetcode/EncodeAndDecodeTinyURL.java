import java.util.HashMap;

//https://leetcode.com/problems/encode-and-decode-tinyurl/

public class EncodeAndDecodeTinyURL {
    HashMap<String, String> map = new HashMap<>();
    HashMap<String, String> revMap = new HashMap<>();
    
    String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    String baseUrl = "http://tinyurl.com/";
    
    public String code(String url) {
        String sho = "";
        for(int i=0; i<7; i++) {
            sho += charSet.charAt((int)(Math.random()*100)%charSet.length());
        }
        return sho;
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(revMap.containsKey(longUrl)) {
            return baseUrl + revMap.get(longUrl);
        }
        String coded = code(longUrl);
        map.put(coded, longUrl);
        revMap.put(longUrl, coded);
        return baseUrl + coded;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.substring(shortUrl.lastIndexOf('/')+1, shortUrl.length()));
    }
}
