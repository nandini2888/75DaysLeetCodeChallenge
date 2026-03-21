class WordDictionary {
    // 1. Define the TrieNode structure
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // 2. Add word: Standard Trie insertion
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }

    // 3. Search: Uses a helper function for DFS recursion
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        // Base case: we've reached the end of the word
        if (index == word.length()) {
            return node.isEndOfWord;
        }

        char c = word.charAt(index);
        
        if (c == '.') {
            // Wildcard: Try all 26 possible children
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    if (dfs(word, index + 1, node.children[i])) {
                        return true;
                    }
                }
            }
            return false; // None of the paths matched
        } else {
            // Standard search: Follow the specific character path
            int charIdx = c - 'a';
            if (node.children[charIdx] == null) {
                return false;
            }
            return dfs(word, index + 1, node.children[charIdx]);
        }
    }
}