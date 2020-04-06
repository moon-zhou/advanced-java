package org.moonzhou.advancedprogramming.tryautoclose.demo002exceptionfinallyeaten;

/**
 * 验证finally的异常覆盖之前的异常
 *
 * 即此处的readLine被finally里的close覆盖了
 * Exception in thread "main" java.lang.Exception: close
 * 	at org.moonzhou.advancedprogramming.tryautoclose.demo002.MyFinallyReadLineThrow.close(MyFinallyReadLineThrow.java:13)
 * 	at org.moonzhou.advancedprogramming.tryautoclose.demo002.App.main(App.java:21)
 *
 * @author moon-zhou <ayimin1989@163.com>
 * @version V1.0.0
 * @description
 * @date 2020/4/5 20:58
 * @since 1.0
 */
public class ExceptionEatenTest {
    public static void main(String[] args) throws Exception {
        MyFinallyReadLineThrow myFinallyReadLineThrow = null;
        try {
            myFinallyReadLineThrow = new MyFinallyReadLineThrow();
            myFinallyReadLineThrow.readLine();
        } catch (Exception e) {
            throw e;
        } finally {
            myFinallyReadLineThrow.close();
        }
    }
}
