
/**
��Ŀ����
����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ�����磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3����ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}�� �������{2,3,4,2,6,2,5,1}�Ļ�������������6���� {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}�� {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
*/

import java.util.ArrayList;

/**
 * {4,4,6,6,6,5}
 */
public class Main {


    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> a = new ArrayList();
        int len = num.length;
        if( len==0 || size<=0 ) return a;

        for( int s=0, e=size-1; e<len; ++s, ++e ){
            int index = 0;
            int[] array = new int[size];
            for( int i=s; i<=e; ++i ){
                array[index++] = num[i];
            }
            a.add(findMax(array, size));
        }

        return a;
    }

    private int findMax(int[] a, int size){
        int max = Integer.MIN_VALUE;
        for( int i=0; i<size; i++){
            if( a[i]>max ){
                max = a[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
	// write your code here

        int[] num = {0,0,0,1};
        System.out.println(new Main().maxInWindows(num, 3));
    }
}
