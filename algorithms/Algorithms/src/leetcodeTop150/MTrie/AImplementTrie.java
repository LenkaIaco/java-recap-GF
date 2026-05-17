package leetcodeTop150.MTrie;

import java.util.*;

public class AImplementTrie {
    public static void main(String[] args) {
//        ["Trie","insert","startsWith"]
        Trie testTrie = new Trie();
        testTrie.insert("hotdog");
        System.out.println(testTrie.startsWith("dog"));
    }
}
