/*
* 学习使用Java List
*/
package com.example.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List 和 Map 遍历方法
 * @author xukai
 */
public class ListApp {
    public static void main(String[] args) {
        List<String> list  =new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("security");

        // 第一种遍历方法使用foreach遍历List
        // 也可以改写for(int i=0;i<list.size();i++)这种形式
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println();

        // 第二种遍历，把链表变为数组相关的内容进行遍历
        String[] strArray = new String[list.size()];
        list.toArray(strArray);
        // 这里也可以改写为  foreach(String str:strArray)这种形式
        for (int i = 0; i < strArray.length ;i++)
        {
            System.out.println(strArray[i]);
        }
        System.out.println();

        // 第三种遍历 使用迭代器进行相关遍历
        Iterator<String> iter = list.iterator();
        // 判断下一个元素之后有值
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println();
    }
}
