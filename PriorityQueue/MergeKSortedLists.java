/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        boolean first = true;
        ListNode head = null;
        ListNode iterator = null;
        PriorityQueue<ListNode> pq = new PriorityQueue(2, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return new Integer(o1.val).compareTo(new Integer(o2.val));
            }
        });
        for(int i = 0; i < lists.length;i++) {
            if(lists[i] == null) continue;
            pq.add(lists[i]);
        }
        while(true) {
            ListNode minimum = pq.poll();
            if(minimum==null) break;
            if(first) {
                head = minimum;
                iterator = minimum;
                first = false;
            }
            else{
                iterator.next = minimum;
                iterator = minimum;
            }
            if(minimum.next!=null) pq.add(minimum.next);
        }
        return head;
    }
}