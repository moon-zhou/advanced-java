package org.moonzhou.advancedprogramming.classload.demo001parentsub;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println("new Student() 完毕，开始调用getStudentId()方法");
        // 打印出来的值是100
        System.out.println("#推测~~打印出来的值是100");
        student.getStudentId();
    }
}