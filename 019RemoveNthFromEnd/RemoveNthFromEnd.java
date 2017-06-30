import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ɾ��������n��
 * @author lz
 * ��������Ϊ����
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
     * ���Ž�
     * @param head
     * @param n
     * @return
     * ��������faster����ʼ��������n����
     * Ȼ������slower��fasterһ���ܣ�ֱ��faster==nullʱ��slower��ָ���node������Ҫɾ���Ľڵ㡣
     */
    public ListNode bestRemoveNthFromEnd(ListNode head, int n) {
    	//ɾ��ͷ���ʱ��������
    	if(head==null || head.next==null) 
    		return null;
    	ListNode faster = head;
    	ListNode slower = new ListNode(0);
    	slower.next = head;   //��������fasterΪnullʱ��slower�պ�ָ�ڱ�ɾ������ǰһ�����
    	
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
