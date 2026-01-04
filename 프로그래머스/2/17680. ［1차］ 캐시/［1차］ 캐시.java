import java.util.*;
class Solution {
    
    class Node {
        String key;
        Node prev, next;
    }
    
    Node head, tail;
    Map<String, Node> map = new HashMap<>();

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if (cacheSize == 0) 
            return cities.length * 5;
        
        // 더미 노드 생성
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        
        for (String city : cities){
            city = city.toLowerCase();
            
            // 캐시 미스
            if (!map.containsKey(city)){
                answer += 5;
                
                // 캐시가 꽉 찼으면 LRU 제거
                if (map.size() == cacheSize) {
                    Node lru = head.next;
                    remove(lru);
                    map.remove(lru.key);
                }
                
                // 새 노드 추가
                Node node = new Node();
                node.key = city;
                addToTail(node);
                map.put(city, node);

            } 
            // 캐시 히트
            else {
                answer += 1;
                Node node = map.get(city);
                remove(node);
                addToTail(node);                
            }
        }
        
        return answer;
    }
    
    void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    void addToTail(Node node){
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }
}