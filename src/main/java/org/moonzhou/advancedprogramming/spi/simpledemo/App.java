package org.moonzhou.advancedprogramming.spi.simpledemo;

import org.moonzhou.advancedprogramming.spi.service.SPIService;
import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Description 测试SPIService
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/11
 */
public class App {

    public static void main(String[] args) {

        // 测试加载方式一
        ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);
        Iterator<SPIService> loadSpiService = load.iterator();
        while (loadSpiService.hasNext()) {
            SPIService spiService = loadSpiService.next();
            spiService.execute();
        }

        load.forEach(spiService -> {
            System.out.println(spiService.getClass().getName() + ".execute():");
            spiService.execute();
        });

        System.out.println();

        // 测试加载方式二
        Iterator<SPIService> providers = Service.providers(SPIService.class);

        while (providers.hasNext()) {
            SPIService service = providers.next();
            service.execute();
        }
    }
}
