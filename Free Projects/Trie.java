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
        for(int i = 0; i < word.length(); i++){
            if(tmp.childern[word.charAt(i)-'a']==null){
                tmp.childern[word.charAt(i)-'a']=new TrieNode();
            }
            tmp = tmp.childern[word.charAt(i)-'a'];
        }
        tmp.terminating = true;
    }
    
    public boolean search(String word) {
        TrieNode tmp = root;
        for(int i = 0; i< word.length(); i++){
            if(tmp.childern[word.charAt(i)-'a']==null){
                return false;
            }
            tmp = tmp.childern[word.charAt(i)-'a'];
        }
        return tmp.terminating;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        for(int i = 0; i< prefix.length(); i++){
            if(tmp.childern[prefix.charAt(i)-'a']==null){
                return false;
            }
            tmp = tmp.childern[prefix.charAt(i)-'a'];
        }
        return !tmp.terminating;
    }
}