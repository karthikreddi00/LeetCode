/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode temp = head;
        int val = -1;
        int count = 1;
        List<Integer> list = new ArrayList<>();
        while(temp.next != null){
            if(val == -1){
                val = temp.val;
                continue;
            }
            if(val > temp.val && temp.val < temp.next.val){
                list.add(count);
            }
            if(val < temp.val && temp.val > temp.next.val){
                list.add(count);
            }
            val = temp.val;
            temp = temp.next;
            count++;
        }
        if(list.size() <= 1){
             return new int[]{-1,-1};
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < list.size(); i++){
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return new int[] {
             min,
             list.get(list.size() - 1) - list.get(0)
        };
    }
}