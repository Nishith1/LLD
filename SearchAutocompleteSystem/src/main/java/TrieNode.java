import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord;
    String word;
    int frequency; // to rank suggestions

    public TrieNode() {}
}
