import java.util.LinkedList;

public class WordSearch2 {

    class TrieNode{
        TrieNode[] children;
        boolean terminating;

        public TrieNode(){
            terminating = false;
            children = new TrieNode[26];
            for(int i = 0; i<26; i++){
                children[i]=null;
            }
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new LinkedList<>();
        
    }

    public TrieNode makeTrie(char[][] board){
        TrieNode root = new TrieNode();

        for

        return root;
    }
}