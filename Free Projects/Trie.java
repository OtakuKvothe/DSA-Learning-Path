import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Trie {
    
    public class TrieNode{
        TrieNode[] childern;
        boolean terminating;

        public TrieNode(){
            terminating = false;
            childern = new TrieNode[26];
            for(int i=0; i<26; i++){
                childern[i]=null;
            }
        }
    }

    static TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode tmp = root;
        for(char ch: word.toCharArray()){
            if(tmp.childern[ch-'a']==null){
                tmp.childern[ch-'a']=new TrieNode();
            }
            tmp = tmp.childern[ch-'a'];
        }
        tmp.terminating = true;
    }
    
    public boolean search(String word) {
        TrieNode tmp = root;
        for(char ch: word.toCharArray()){
            if(tmp.childern[ch-'a']==null){
                return false;
            }
            tmp = tmp.childern[ch-'a'];
        }
        return tmp.terminating;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        for(char ch: prefix.toCharArray()){
            if(tmp.childern[ch-'a']==null){
                return false;
            }
            tmp = tmp.childern[ch-'a'];
        }
        return true;
    }
}


/*
class Trie {
    
    
    
    

    public class TrieNode{
        HashMap<Character, TrieNode> map;
        boolean terminating;

        public TrieNode(){
            map = new HashMap<>();
            terminating = false;
        }
    }

    static TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode tmp = root;
        for(char ch: word.toCharArray()){
            if(!tmp.map.containsKey(ch)){
                tmp.map.put(ch, new TrieNode());
            }
            tmp = tmp.map.get(ch);
        }
        tmp.terminating = true;
    }
    
    public boolean search(String word) {
        TrieNode tmp = root;
        for(char ch: word.toCharArray()){
            if(!tmp.map.containsKey(ch)){
                return false;
            }
            tmp = tmp.map.get(ch);
        }
        return tmp.terminating;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        for(char ch: prefix.toCharArray()){
            if(!tmp.map.containsKey(ch)){
                return false;
            }
            tmp = tmp.map.get(ch);
        }
        return true;
    }
}
*/