// https://leetcode.com/problems/prefix-and-suffix-search/

public class PrefixAndSuffixSearch {
    private class Trie {
        Trie[] next;
        int index;
        
        public Trie() {
            next = new Trie[27];
            Arrays.fill(next, null);
            index = -1;
        }
    }
    
    private Trie prefix;

    public WordFilter(String[] words) {
        prefix = new Trie();
        for(int i=0; i<words.length; i++) {
            insert(prefix, words[i], i);
        }
    }
    
    private void insert(Trie root, String str, int index) {
        str += "{";
        for(int i=0; i<str.length(); i++) {
            Trie curr = root;
            curr.index = index;
            for(int j=i; j<str.length()*2-1; j++) {
                int ch = str.charAt(j%str.length()) - 'a';
                if(curr.next[ch] == null)
                    curr.next[ch] = new Trie();
                curr = curr.next[ch];
                curr.index = index;
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        String q = (new StringBuilder(suffix)).append("{").append(prefix).toString();
        Trie curr = this.prefix;
        for(int i=0; i<q.length(); i++) {
            int ch = q.charAt(i) - 'a';
            if(curr.next[ch] == null) {
                return -1;
            }
            curr = curr.next[ch];
        }
        return curr.index;
    }
}