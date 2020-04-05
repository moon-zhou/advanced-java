package org.moonzhou.advancedprogramming.generics.ginterface;

/**
 * @Description 泛型接口测试类
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/13
 */
public class App {

    public static void main(String[] args) {
        // 泛型接口非固定类型测试之String
        GenericInterfaceImplDominantTypeImpl<String> stringGenericInterfaceImplDominantType = new GenericInterfaceImplDominantTypeImpl<String>();
        stringGenericInterfaceImplDominantType.setData("hello generic interface...");
        String s = stringGenericInterfaceImplDominantType.next();
        System.out.println(s);

        // 泛型接口非固定类型测试之int
        GenericInterfaceImplDominantTypeImpl intGenericInterfaceImplDominantType = new GenericInterfaceImplDominantTypeImpl();
        intGenericInterfaceImplDominantType.setData(111);
        // 非显示获取值，就需要进行强转
        int i = (int) intGenericInterfaceImplDominantType.next();
        System.out.println(i);

        System.out.println();

        // 泛型接口固定类型测试之String
        GenericInterfaceSpecificTypeImpl genericInterfaceSpecificType = new GenericInterfaceSpecificTypeImpl();
        genericInterfaceSpecificType.setData("hello specific type generic interface...");
        String result = genericInterfaceSpecificType.next();
        System.out.println(result);
    }
}
