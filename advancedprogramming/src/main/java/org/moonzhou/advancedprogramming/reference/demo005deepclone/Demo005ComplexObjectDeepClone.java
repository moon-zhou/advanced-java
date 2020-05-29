package org.moonzhou.advancedprogramming.reference.demo005deepclone;

/**
 * 复杂对象深拷贝示例<br>
 *
 * @author moon-zhou
 * @date 2020/5/28 12:10
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo005ComplexObjectDeepClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person("zhangsan", 21);
        p1.setAddress("湖北省", "武汉市");
        Person p2 = (Person) p1.clone();
        System.out.println("p1:" + p1);
        System.out.println("p1.getPname:" + p1.getPname().hashCode());

        System.out.println("p2:" + p2);
        System.out.println("p2.getPname:" + p2.getPname().hashCode());


        System.out.println();
        System.out.println("未修改值时：");
        System.out.println("修改前各值对应的栈内存地址比较，pname：" + (p1.getPname() == p2.getPname())
                + "    page:" + (p1.getPage() == p2.getPage()) + "    address:" + (p1.getAddress() == p2.getAddress()));
        p1.display("p1");
        p2.display("p2");

        System.out.println();
        System.out.println("将复制之后的对象地址修改：");
        p2.setPname("fawaikuangtu");
        p2.setAddress("湖北省", "荆州市");

        System.out.println("修改前各值对应的栈内存地址比较，pname：" + (p1.getPname() == p2.getPname())
                + "    page:" + (p1.getPage() == p2.getPage()) + "    address:" + (p1.getAddress() == p2.getAddress()));
        p1.display("p1");
        p2.display("p2");
    }
}
