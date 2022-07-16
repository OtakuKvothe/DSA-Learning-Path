import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/search-suggestions-system/

public class SearchSuggestionSystem {
    private class Trie {
        Trie next[];
        List<String> sugg;
        
        public Trie() {
            next = new Trie[26];
            sugg = new ArrayList<String>();
        }
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Trie root = new Trie();
        for(String word: products) {
            insert(root, word);
        }
        List<List<String>> res = new ArrayList<>();
        for(int i=0; i<searchWord.length(); i++) {
            res.add(new ArrayList<String>());
        }
        find(root, searchWord, res);
        return res;
    }
    
    private void insert(Trie root, String word) {
        Trie curr = root;
        for(int i=0; i<word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            
            if(curr.next[ch] == null)
                curr.next[ch] = new Trie();
            
            curr = curr.next[ch];
            
            if(curr.sugg.size() < 3) 
                curr.sugg.add(word);
        }
    }
    
    private void find(Trie root, String word, List<List<String>> res) {
        Trie curr = root;
        for(int i=0; i<word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if(curr.next[ch] == null)
                return;
            curr = curr.next[ch];
            res.set(i, (new ArrayList<>(curr.sugg)));
        }
    }
}
