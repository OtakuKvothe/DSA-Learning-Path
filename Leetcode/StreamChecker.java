class StreamChecker {

    private String words[];
    
    TrieNode head;
    
    public StreamChecker(String[] words) {
        this.words = new String[words.length];
        for(int i=0; i<words.length; i++){
            this.words[i]=words[i];
        }
    }
    
    public boolean query(char letter) {
        if(head==null){
            head = new TrieNode(letter);
        }else{
            TrieNode t = new TrieNode(letter);
            t.prev = head;
            head = t;
        }
        return checkSuffix();
    }
    
    public boolean checkSuffix(){
        for(int i=0; i<words.length; i++){
            String s=words[i];
            String f=getString(s.length());
            if(s.equals(f)) return true;
        }
        return false;
    }

    public String getString(int n){
        String res="";
        TrieNode t=head;
        for(int i=0; i<n; i++){
            if(t==null) return res;
            res+=t.c;
            t=t.prev;
        }
        return res;
    }

    public static void main(String[] args) {
        
    }
}

class TrieNode{
    char c;
    TrieNode prev;
    
    public TrieNode(char c){
        this.c = c;
    }
}