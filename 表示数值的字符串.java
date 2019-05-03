/*
    ��Ŀ����
��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
���磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ�� 
����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
*/


public class Solution {
    public boolean isNumeric(char[] str) {
        int len = str.length;
        if( len==0 ) return false;
        boolean flag = true;
        boolean[] flags = new boolean[3]; // 0 -- +/- 1--.  2 -- e
        
        for( int i=1; i<len; ++i ){
            //��e/E�Ļ�������һ��������
            if( str[i]=='E' || str[i]=='e' ){
                if( i==len-1 ) return false;
                if( flags[2] ){
                    return false;
                }
                flags[2] = true;
            }else if( str[i]=='+' || str[i]=='-' ){
                //����+/-���ţ������ڿ�ͷ�������e֮��
                if( flags[0] && str[i-1]!='E' && str[i-1]!='e'){
                    //����ڶ��γ��֣��Ҳ���e��,false
                    return false;
                }
                if( !flags[0] && i>0 && str[i-1]!='E' && str[i-1]!='e' ){
                    //�����һ�γ���,�Ҳ���e�󣬲��ڿ�ͷ��false
                    return false;
                }
                flags[0] = true;
            }else if( str[i]=='.' ){
                //����.���ţ�������e��,���ܳ�������
                if( flags[1] || flags[2]){
                    return false;
                }
                flags[1] = true;
            }else if( str[i]<'0' || str[i]>'9' ){
                return false;
            }
        }
        return true;
    }
}