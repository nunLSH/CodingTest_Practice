import java.util.*;

class Solution {

    static class Node {
        String word;
        int depth;

        Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }

    public int cntDifference(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) diff++;
        }
        return diff;
    }

    public int solution(String begin, String target, String[] words) {

        boolean exists = false;
        for (String w : words) {
            if (w.equals(target)) {
                exists = true;
                break;
            }
        }
        if (!exists) return 0;

        Queue<Node> q = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];

        q.offer(new Node(begin, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.word.equals(target)) {
                return cur.depth;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && cntDifference(cur.word, words[i]) == 1) {
                    visited[i] = true;
                    q.offer(new Node(words[i], cur.depth + 1));
                }
            }
        }

        return 0;
    }
}
