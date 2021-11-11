package com.LC;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> vals = new PriorityQueue<>();
        for(ListNode head : lists){
            while(head!=null){
                vals.add(head.val);
                head = head.next;
            }
        }
        ListNode head = null;
        ListNode focus = head;
        while(!vals.isEmpty()){
            if(head == null){
                head = new ListNode(vals.poll());
                focus = head;
            }else{
                focus.next = new ListNode(vals.poll());
                focus = focus.next;
            }
        }
        return head;
    }
}
