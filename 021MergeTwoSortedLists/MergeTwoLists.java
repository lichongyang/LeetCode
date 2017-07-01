/**
 * �ϲ�������������
 * @author lz
 * ʵ�ʾ���һ����·�鲢����ĺϲ�����
 */
public class MergeTwoLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode head = null; //������ָ��
		ListNode p = null;   //������ָʾָ��
		ListNode p1 = l1, p2 = l2;   //�������������ָ��
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
			//l1������ʣ��
			p.next = p1;
		}
		if (p2 != null){
			p.next = p2;
		}
		return head;
    }
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
}

