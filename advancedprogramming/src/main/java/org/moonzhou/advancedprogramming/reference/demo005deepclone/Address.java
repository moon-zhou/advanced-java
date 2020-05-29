package org.moonzhou.advancedprogramming.reference.demo005deepclone;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date 2020/5/29 17:51
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Address {
    private String provices;
    private String city;

    public void setAddress(String provices, String city) {
        this.provices = provices;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address [provices=" + provices + ", city=" + city + "]";
    }

}
