package org.moonzhou.advancedprogramming.spi.springspi;

import org.moonzhou.advancedprogramming.spi.service.SPIService;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

/**
 * Spring spi测试<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @Date: 2020/1/15 17:49
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class App {

    public static void main(String[] args) {
        List<String> spiServiceNames = SpringFactoriesLoader.loadFactoryNames(SPIService.class, Thread.currentThread().getContextClassLoader());
        spiServiceNames.forEach(System.out::println);


        System.out.println("spring spi---------------");
        List<SPIService> spiServices = SpringFactoriesLoader.loadFactories(SPIService.class, Thread.currentThread().getContextClassLoader());
        spiServices.forEach(spiService -> {
            System.out.println(spiService.getClass().getName() + ".execute():");
            spiService.execute();
        });
    }
}
