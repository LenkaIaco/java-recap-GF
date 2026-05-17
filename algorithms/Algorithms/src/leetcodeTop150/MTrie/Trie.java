package leetcodeTop150.MTrie;

public class Trie {
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        TrieNode[] currArr = curr.letters;
        for (char c : word.toCharArray()){
            int index = c -'a';
            if (currArr[index]==null) {
                TrieNode newCurr = new TrieNode();
                currArr[index] = newCurr;
            }
            curr = currArr[index];
            currArr = curr.letters;
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        TrieNode[] currArr = curr.letters;

        for (char c: word.toCharArray()){
            int index = c - 'a';
            if (currArr[index]==null){
                return false;
            }
            curr = currArr[index];
            currArr = curr.letters;
        }

        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        TrieNode[] currArr = curr.letters;
        for (char c: prefix.toCharArray()){
            int index = c - 'a';
            if (currArr[index] == null){
                return false;
            }
            curr = currArr[index];
            currArr = curr.letters;
        }
        return true;
    }
}
