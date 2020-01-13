package org.moonzhou.advancedprogramming.generics.ginterface;

/**
 * @Description 隐式实现泛型接口
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/13
 */
public class GenericInterfaceSpecificTypeImpl implements GenericInterface<String> {

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String next() {
        return getData();
    }
}
