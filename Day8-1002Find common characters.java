import java.util.*;

public class Solution {
    public List<String> commonChars(String[] words) {
        // Initialize frequency array for the first word
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String word : words) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            // Update min frequency across all words
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }

        // Build result list based on min frequencies
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minFreq[i]; j++) {
                result.add(String.valueOf((char)(i + 'a')));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words1 = {"bella","label","roller"};
        System.out.println(sol.commonChars(words1)); // Output: [e, l, l]

        String[] words2 = {"cool","lock","cook"};
        System.out.println(sol.commonChars(words2)); // Output: [c, o]
    }
}
