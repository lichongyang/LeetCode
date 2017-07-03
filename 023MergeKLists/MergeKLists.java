import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并K个有序数组
 * @author lz
 * 类似于归并排序，将数组分为多个子任务，依次求解合并
 */

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
        	return null;
        }
        return sort(lists, 0, lists.length - 1);
    }
    public ListNode sort(ListNode[] lists, int left, int right){
    	if (left < right){
    		int mid = (left + right) / 2;
    		return mergeTwoLists(sort(lists, left, mid), sort(lists, mid + 1, right));
    	}
    	return lists[left];
    }
    
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode head = null; //新链表指针
		ListNode p = null;   //新链表指示指针
		ListNode p1 = l1, p2 = l2;   //其他两个链表的指针
		if (l1.val <= l2.val){
			head = l1;
			p = head;
			p1 = p1.next;
		}else {
			head = l2;
			p = head;
			p2 = p2.next;
		}
		while ((p1 != null) && (p2 != null)){
			if (p1.val <= p2.val){
				p.next = p1;
				p = p.next;
				p1 = p1.next;
			}else{
				p.next = p2;
				p = p.next;
				p2 = p2.next;
			}
		}
		if (p1 != null){
			//l1链表还有剩余
			p.next = p1;
		}
		if (p2 != null){
			p.next = p2;
		}
		return head;
    }
    
	
	/**
	 * 维护一个大小为k的堆，每次取堆顶的最小元素放到结果中，然后读取该元素的下一个元素放入堆中，重新维护好。
	 * @param lists
	 * @return
	 */
	public ListNode AnotherMergeKLists(ListNode[] lists){
		PriorityQueue<ListNode> heap = new PriorityQueue<>(10, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val;
			}
		});
		//构建初始堆
		for (int i = 0; i < lists.length; i++){
			if (lists[i] != null){
				heap.offer(lists[i]);
			}
		}
		ListNode head = null;
		ListNode pre = head;
		while (heap.size() > 0){
			ListNode cur = heap.poll(); //获取并删除队首元素
			if (head == null){
				head = cur;
				pre = head;
			}else{
				pre.next = cur;
			}
			pre = cur;
			if (cur.next != null){
				heap.offer(cur.next);
			}
		}
		return head;
	}
	
    public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}

}
