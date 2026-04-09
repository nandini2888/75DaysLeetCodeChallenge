class Solution {
    static final long MOD = 1_000_000_007L;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int B = Math.max(1, (int) Math.sqrt(n));

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = nums[i];

        // sparse: for each k, store only modified positions
        Map<Integer, Map<Integer, Long>> diffMap = new HashMap<>();

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2];
            long v = q[3] % MOD;

            if (k > B) {
                for (int idx = l; idx <= r; idx += k)
                    arr[idx] = arr[idx] * v % MOD;
            } else {
                Map<Integer, Long> d = diffMap.computeIfAbsent(k, x -> new HashMap<>());
                int last = l + ((r - l) / k) * k;
                d.merge(l, v, (a, b) -> a * b % MOD);
                int cancelAt = last + k;
                if (cancelAt < n) {
                    long inv = modPow(v, MOD - 2, MOD);
                    d.merge(cancelAt, inv, (a, b) -> a * b % MOD);
                }
            }
        }

        for (Map.Entry<Integer, Map<Integer, Long>> e : diffMap.entrySet()) {
            int k = e.getKey();
            Map<Integer, Long> d = e.getValue();
            for (int start = 0; start < k && start < n; start++) {
                long cur = 1L;
                for (int i = start; i < n; i += k) {
                    Long val = d.get(i);
                    if (val != null) cur = cur * val % MOD;
                    if (cur != 1L) arr[i] = arr[i] * cur % MOD;
                }
            }
        }

        int xor = 0;
        for (long x : arr) xor ^= (int) x;
        return xor;
    }

    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }
}