/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        ListNode previous = null;
        boolean first = true;
        while(true) {
            boolean kComplete = true;
            Stack<ListNode> s = new Stack<ListNode>();
            ListNode startOfK = current;
            for(int i=0;i<k;i++) {
                if(current == null) {
                    kComplete = false;
                    break;
                }
                s.push(current);
                current = current.next;
            }
            if(!kComplete) {
                if(previous != null) previous.next = startOfK;
                return head;
            }
            ListNode top = s.pop();
            if(first) {
                head = top;
                first = false;
            }
            if(previous != null) previous.next = top;
            while(!s.empty()) {
                top.next = s.pop();
                top = top.next;
            }
            previous = top;
        }
    }
}