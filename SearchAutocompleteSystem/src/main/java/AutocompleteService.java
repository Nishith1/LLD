import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AutocompleteService {
    private final TrieNode root = new TrieNode();

    public void insert(String word, int frequency) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        node.isEndOfWord = true;
        node.word = word;
        node.frequency = frequency;
    }

    public List<String> getSuggestions(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            node = node.children.get(ch);
            if (node == null) return new ArrayList<>();
        }
        PriorityQueue<TrieNode> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.frequency, a.frequency));
        collectSuggestions(node, pq);

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty() && result.size() < 5) {
            result.add(pq.poll().word);
        }
        return result;
    }

    private void collectSuggestions(TrieNode node, PriorityQueue<TrieNode> pq) {
        if (node.isEndOfWord) pq.offer(node);
        for (TrieNode child : node.children.values()) {
            collectSuggestions(child, pq);
        }
    }
}
