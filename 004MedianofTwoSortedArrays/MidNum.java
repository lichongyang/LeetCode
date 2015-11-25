import java.awt.List;
import java.util.HashMap;

/***********************************************************
 * Median of Two Sorted Arrays �����������������λ��
 * �õķ���ʱ�临�Ӷ�ΪO��n����֪��ΪʲôLeetCode��ͨ����
 * @author ���� 
 * 004
 ***********************************************************/

public class MidNum {
	public static int findMax(int[] A, int[] B){
		int max = 0;
		for (int i=0;i<A.length;i++){
			if(A[i] > max)
				max = A[i];
		}
		for (int i=0;i<B.length;i++){
			if(B[i] > max)
				max = B[i];
		}
		return max;
	}
	
	public static int Search(int[] C, int k){
		int i;
		for (i=0;i<C.length;i++){
			if (C[i] >= k)
				break;
		}
		return i;
	}
	
	public static double findMid(int[] A, int[] B){
		double mid = 0;
		int k = findMax(A, B)+1;
		if (k == 1)
			return 0.0;
		int c[] = new int[k];
		for (int i = 0;i < k;i++){
			c[i] = 0;
		}
		for (int i = 0;i < A.length;i++){
			c[A[i]] += 1;
		}
		for (int i = 0;i < A.length;i++){
			c[B[i]] += 1;
		}
		for (int i = 1;i < k; i++){
			c[i] = c[i] + c[i-1];
		}
		for (int i = 0;i<k;i++){
			System.out.println(c[i]);
		}
		if (((A.length + B.length)%2) == 0){
			int mid1 = (A.length + B.length)/2;
			int mid2 = (A.length + B.length)/2 + 1;
			System.out.println(mid1);
			System.out.println(mid2);
			mid = ((Search(c, mid1)+Search(c, mid2))/2.0);
		}else{
			mid = Search(c, (A.length+B.length+1)/2);
		}
		return mid;
	}
	
	public static void main(String[] args){
		int A[] = {};
		int B[] = {};
		double mid = findMid(A, B);
		System.out.print(mid);
	}

}
