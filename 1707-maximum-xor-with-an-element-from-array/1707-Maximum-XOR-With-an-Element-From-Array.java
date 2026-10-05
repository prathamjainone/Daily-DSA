class Solution {

    public static class Node {
    Node[] links = new Node[2];

    boolean containsKey(int ind) {
        return links[ind] != null;
    }

    Node get(int ind) {
        return links[ind];
    }

    void put(int ind, Node node) {
        links[ind] = node;
    }
}

    public static class Trie {
    private Node root;

    // Constructor
    Trie() {
        root = new Node();
    }

    // Function to insert a number into the trie
    void insert(int num) {
        // Start traversal
        Node node = root;

        /* Traverse each bit of the number 
           from the most significant bit to the 
           least significant bit */
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            /* If the current node doesn't have 
               a child node at the current bit, 
               create one */
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            /* Move to the child node
               corresponding to the 
               current bit */
            node = node.get(bit);
        }
    }

    int findMax(int num) {
        Node node = root;
        int maxNum = 0;

        /* Traverse each bit of the number from 
           the most significant bit to the least 
           significant bit extract the i-th 
           bit of the number.
           If there exists a different bit 
           in the trie at the current 
           position, choose it to maximize XOR */
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (node.containsKey(1 - bit)) {
                maxNum = maxNum | (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }

        // Return maximum XOR value
        return maxNum;
    }
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];

        // List to store offline queries
        List<int[]> offlineQueries = new ArrayList<>();

        // Sort the array of numbers
        Arrays.sort(nums);

        // Convert queries to offline queries and store them in a list
        for (int i = 0; i < queries.length; i++) {
            offlineQueries.add(new int[]{queries[i][1], queries[i][0], i});
        }

        // Sort queries based on their end points
        offlineQueries.sort(Comparator.comparingInt(a -> a[0]));

        int i = 0;
        Trie trie = new Trie();

        // Process each query
        for (int[] query : offlineQueries) {
            // Insert numbers 
            while (i < nums.length && nums[i] <= query[0]) {
                trie.insert(nums[i]);
                i++;
            }

            /* If there are numbers inserted into the trie, 
               find the maximum XOR value for the query range */
            if (i != 0)
                ans[query[2]] = trie.findMax(query[1]);
            else
                ans[query[2]] = -1;
        }

        return ans;
    }
    }