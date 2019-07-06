/*
 * 题目描述
牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * */

public class Solution {
        //一个个字符地处理，遇到空格填入，遇到非空格就填入一个完整单词
        //如果采用split方法处理，可能会出现空格被忽略的情况，事实上空格也是要被纳入句子的
        public static String ReverseSentence(String str) {
        int len = str.length();
        if( len == 0 ) return "";
        StringBuilder sb = new StringBuilder();
        for( int i=len-1; i>=0; i-- ){
            if( str.charAt(i)==' ' ){
                sb.append(str.charAt(i));
            }else{
                int j;
                for( j=i-1; j>=0; j-- ){
                    if( str.charAt(j)==' ' ){
                        break;
                    }
                }
                sb.append(str.substring(j + 1, i + 1));
                i = j + 1;
            }
        }
        return sb.toString();
    }
}
