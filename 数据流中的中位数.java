/*
��Ŀ����
��εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ������ʹ��Insert()������ȡ��������ʹ��GetMedian()������ȡ��ǰ��ȡ���ݵ���λ����
*/

import java.util.*;
public class Solution {

    LinkedList<Integer> a = new LinkedList();
    public void Insert(Integer num) {
        for( int i=0; i<a.size(); ++i ){
            if( a.get(i)>num ){
                a.add(i, num);
                return;
            }
        }
        a.add(num);
    }

    public Double GetMedian() {
        int size = a.size();
        if( (size&1)==1 ){
            //������
            return Double.parseDouble(String.valueOf(a.get(size / 2)));
        }else{
            Double temp = (a.get(size / 2) + a.get(size / 2 - 1))/2.0;
            return temp;
        }
    }


}