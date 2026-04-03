class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (k == len) return "0";
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char digit : num.toCharArray()) {
            // While the current digit is smaller than the last digit in stack,
            // and we still need to remove digits, pop the stack.
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > digit) {
                stack.removeLast();
                k--;
            }
            stack.addLast(digit);
        }
        
        // If we still have k left (e.g., the number was 1234), 
        // remove from the end.
        while (k > 0) {
            stack.removeLast();
            k--;
        }
        
        // Build the string and remove leading zeros
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char curr = stack.removeFirst();
            // Skip leading zeros
            if (sb.length() == 0 && curr == '0') continue;
            sb.append(curr);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}