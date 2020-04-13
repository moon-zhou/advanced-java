package org.moonzhou.advancedprogramming.annotation.demo001json;

/**
 * 注解使用封装类<br>
 *
 * @author moon-zhou
 * @date: 2020/4/13 17:36
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Writer {

    private int age;

    @JsonField("writerName")
    private String name;

    @JsonField
    private String bookName;

    public Writer(int age, String name, String bookName) {
        this.age = age;
        this.name = name;
        this.bookName = bookName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Writer{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}

