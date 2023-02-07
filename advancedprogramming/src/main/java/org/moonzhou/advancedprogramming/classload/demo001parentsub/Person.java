package org.moonzhou.advancedprogramming.classload.demo001parentsub;

public class Person {

    private int personId;

    /**
     * 第一步，走父类无参构造函数
     */
    public Person() {
        // 1、第一步，走父类无参构造函数
        System.out.println("第一步，走父类无参构造函数");
        System.out.println("");
        setId(100);
    }

    /**
     * 第三步，通过super.setId(id);走父类发方法
     * @param id
     */
    public void setId(int id) {
        System.out.println("第三步，通过super.setId(id);走父类发方法~~~id="+id);
        personId = id;
        System.out.println("在父类：studentId 被赋值为 " + personId);
        System.out.println("");
    }
}