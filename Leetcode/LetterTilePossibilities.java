//https://leetcode.com/problems/letter-tile-possibilities
public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        int[] c = new int[26];
        for(char ch: tiles.toCharArray()){
            c[ch - 'A']++;
        }
        return helper(c);
    }
    
    public int helper(int[] c){
        int s=0;
        for(int i=0; i<26; i++){
            if(c[i]==0) continue;
            s++;
            c[i]--;
            s+=helper(c);
            c[i]++;
        }
        return s;
    }
}
