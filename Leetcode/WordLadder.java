//https://leetcode.com/problems/word-ladder
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)) return 0;
        
        HashSet<String> vis = new HashSet<>();
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        
        int res = 0;
        
        while(!q.isEmpty()){
            int n = q.size();
            for(int k=0; k<n; k++){
                String word = q.poll();
                if(word.equals(endWord)) return res+1;
                for(int i=0; i<word.length(); i++){
                    char[] ch = word.toCharArray();
                    for(int j=0; j<26; j++){
                        ch[i] = (char)(j+'a');
                        String st = new String(ch);
                        if(!vis.contains(st)&&words.contains(st)){
                            q.add(st);
                            vis.add(st);
                        }
                    }
                }
            }
            res++;
        }
        
        return 0;
    }
}
