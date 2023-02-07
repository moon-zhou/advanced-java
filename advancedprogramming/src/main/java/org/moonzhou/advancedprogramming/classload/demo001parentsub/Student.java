package org.moonzhou.advancedprogramming.classload.demo001parentsub;

public class Student extends Person {

    private int studentId = 1;

    /**
     * 在走子类无参构造函数前，会先执行子类的普通成员变量初始化
     * 第五步，走子类无参构造函数
     */
    public Student() {
        System.out.println("第五步，在走子类无参构造函数前，会先执行子类的普通成员变量初始化");
        System.out.println("第六步，走子类无参构造函数");
        System.out.println("");
    }

    /**
     * 第二步，走子类方法
     *
     * 走完super.setId(id);，第四步，再回此方法
     * @param id
     */
    @Override
    public void setId(int id) {
        System.out.println("第二步，走子类方法~~id="+id);
        // 3、第三步，走子类方法
        super.setId(id);
        studentId = id;
        System.out.println("第四步，再回此方法，在子类：studentId 被赋值为 " + studentId);
        System.out.println("");
    }

    /**
     * 第六步，走getStudentId()
     */
    public void getStudentId() {
        // 4、打印出来的值是100
        System.out.println("第七步，走getStudentId()");
        System.out.println("studentId = " + studentId);
        System.out.println("");
    }
}