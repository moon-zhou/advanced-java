package org.moonzhou.advancedprogramming.reference.demo004shallowclone;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date 2020/5/29 17:52
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Person implements Cloneable {
    public String pname;
    public int page;
    public Address address;

    public Person() {
    }

    public Person(String pname, int page) {
        this.pname = pname;
        this.page = page;
        this.address = new Address();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setAddress(String provices, String city) {
        address.setAddress(provices, city);
    }

    public void display(String name) {
        System.out.println(name + ":" + "pname=" + pname + ", page=" + page + "," + address);
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
