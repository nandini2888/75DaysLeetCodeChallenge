import java.util.*;

class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int size = n + m - 1;

        char[] ans = new char[size];
        boolean[] modifiable = new boolean[size];
        Arrays.fill(modifiable, true);

        // Step 1: Handle 'T'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    int pos = i + j;
                    if (ans[pos] != 0 && ans[pos] != str2.charAt(j)) {
                        return "";
                    }
                    ans[pos] = str2.charAt(j);
                    modifiable[pos] = false;
                }
            }
        }

        // Step 2: Fill remaining with 'a'
        for (int i = 0; i < size; i++) {
            if (ans[i] == 0) {
                ans[i] = 'a';
            }
        }

        // Step 3: Handle 'F'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F' && match(ans, i, str2)) {
                int pos = lastModifiable(i, m, modifiable);
                if (pos == -1) return "";

                ans[pos] = 'b'; // break match
                modifiable[pos] = false;
            }
        }

        return new String(ans);
    }

    private boolean match(char[] ans, int i, String str2) {
        for (int j = 0; j < str2.length(); j++) {
            if (ans[i + j] != str2.charAt(j)) return false;
        }
        return true;
    }

    private int lastModifiable(int i, int m, boolean[] modifiable) {
        int pos = -1;
        for (int j = 0; j < m; j++) {
            if (modifiable[i + j]) {
                pos = i + j;
            }
        }
        return pos;
    }
}