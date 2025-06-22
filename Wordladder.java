class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (int j = 0; j < word.length(); j++) {
                    char[] wordChars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChars[j] = c;
                        String newWord = new String(wordChars);
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord); // Avoid visiting again
                        }
                    }
                }
            }
            level++;
        }

        return 0;  
    }
}
