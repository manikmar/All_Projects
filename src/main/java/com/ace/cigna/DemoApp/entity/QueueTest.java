package com.ace.cigna.DemoApp.entity;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

    public static void main(String[] args) {

        Queue<String> q = new LinkedList<String>();
        q.add("abc -s data");
        q.add("def");
        q.add("ghi");
        q.add("jkl");
        q.add("mno");
        q.add("pqr");
        q.add("stu");
        q.add("vwx");
        System.out.println("Queue head = " + q.element());
        System.out.println("Removing element from queue = " + q.poll());
        /*System.out.println("Queue head now = " + q.element());
        System.out.println("Removing element from queue = " + q.poll());
        System.out.println("Queue head now = " + q.element());
        System.out.println("Remaining Queue elements...");*/
        Object ob;
        while ((ob = q.poll()) != null) {
            System.out.println(ob);
        }
    }
}
