package org.moonzhou.advancedprogramming.generics.ginterface;

/**
 * @Description 泛型接口显性类型显示
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/13
 */
public class GenericInterfaceImplDominantTypeImpl<T> implements GenericInterface<T> {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public T next() {
        return getData();
    }
}
