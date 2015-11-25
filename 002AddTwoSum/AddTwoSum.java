import javax.naming.spi.DirStateFactory.Result;

/*********************************************************************
 * AddTwoSum ���������ж�Ӧ�����ֵ��ӣ�����λ��
 * ����һ�ڵ���Ӳ�����λ������һ�ڵ���ӣ���һ�ڵ�������λ�����ֵ
 * @author ����
 * 002
 *********************************************************************/

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){ val = x; }
}

public class AddTwoSum {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode resultNode = new ListNode(0);
        ListNode result=resultNode;
        int sum = 0;
        while (l1 != null || l2 != null || sum != 0){
            int a = (l1 == null)?0:l1.val;
            int b = (l2 == null)?0:l2.val;
            sum = a + b + sum;
            result.next = new ListNode(sum%10);
            result = result.next;
            sum = sum/10;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return resultNode.next;
    }
	public static void main(String[] args){
		ListNode n1 = new ListNode(5);
		ListNode n2 = new ListNode(5);
		
		ListNode result = addTwoNumbers(n1, n2);
		
	}
}
