import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 删除倒数第n个
 * @author lz
 * 将倒数变为正数
 */

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if (head == null)
    		return head;
    	ListNode p = head;
    	int count = 1;
    	while (p.next != null){
    		count++;
    		p = p.next;
    	}
    	n = count - n;
    	ListNode now = head, pre = head;
     	if (n == 0){
     		return head.next;
     	}else{
     		while(n > 0){
     			pre = now;
     			now = now.next;
     			n--;
     		}
     		pre.next = now.next;
     		return head;
     	}
    }
    /**
     * 最优解
     * @param head
     * @param n
     * @return
     * 首先先让faster从起始点往后跑n步。
     * 然后再让slower和faster一起跑，直到faster==null时候，slower所指向的node就是需要删除的节点。
     */
    public ListNode bestRemoveNthFromEnd(ListNode head, int n) {
    	//删除头结点时单独操作
    	if(head==null || head.next==null) 
    		return null;
    	ListNode faster = head;
    	ListNode slower = new ListNode(0);
    	slower.next = head;   //这样，当faster为null时，slower刚好指在被删除结点的前一个结点
    	
    	for (int i = 0; i < n; i++){
    		faster = faster.next;
    	}
    	if (faster == null){
    		head = head.next;
    		return head;
    	}
    	while (faster != null){
    		faster = faster.next;
    		slower = slower.next;
    	}
    	slower.next = slower.next.next;
    	return head;
        
    }
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { val = x; }
   }
}
