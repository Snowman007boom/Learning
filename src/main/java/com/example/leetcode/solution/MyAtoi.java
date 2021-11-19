package com.example.leetcode.solution;


import java.util.HashMap;
import java.util.Map;

/*  https://leetcode-cn.com/problems/string-to-integer-atoi/
请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。

函数 myAtoi(string s) 的算法如下：

读入字符串并丢弃无用的前导空格
检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
如果整数数超过 32 位有符号整数范围 [−2^31,  2^31 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2^31 的整数应该被固定为 −2^31 ，大于 2^31 − 1 的整数应该被固定为 2^31 − 1 。
返回整数作为最终结果。
注意：

本题中的空白字符只包括空格字符 ' ' 。
除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 */
public class MyAtoi {
    public static void main(String[] args) {
        String str = "+42-51";
        //垃圾解法一：
        System.out.println(myAtoi("+-42"));

        //高级解法
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        System.out.println((automaton.sign * automaton.ans));

    }

    public static int myAtoi(String s) {
        s = s.trim();
        double resDb = 0;
        int resInt = 0;
        if (s != null && s.length() > 0) {
            int length = 0;//为了判断是不是第一个字符，取正负号
            boolean haschar = false;//用来判断是否有符号
            StringBuffer sb = new StringBuffer();
            char[] ArrayS = s.toCharArray();
            for (char temp : ArrayS) {
                length++;
                if ((temp == '-' || temp == '+') && length == 1) {//取第一个字符是不是符号
                    sb.append(temp);
                    haschar = true;
                    continue;
                } else if (temp >= '0' && temp <= '9') {//该字符为数字
                    sb.append(temp);
                    continue;
                } else {//非数字
                    break;
                }
            }
            if (haschar) {//有符号
                if (sb.length() > 1) {
                    resDb = Double.valueOf(sb.toString());
                }
            } else {
                if (sb.length() > 0) {
                    resDb = Double.valueOf(sb.toString());
                }
            }


            if (resDb >= Math.pow(2, 31) - 1) {
                resDb = Math.pow(2, 31) - 1;
            } else if (resDb <= -Math.pow(2, 31)) {
                resDb = -Math.pow(2, 31);
            }
            resInt = (int) resDb;
        } else {
            return resInt;
        }

        return resInt;
    }

    public static void myAtoiAd() {

    }

}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}

