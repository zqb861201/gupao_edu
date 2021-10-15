package cn.enjoy;

import cn.enjoy.dubbospi.ActivateApi;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

/**
 * @Classname SpiTest
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/13 20:55
 * Version 1.0
 */
public class SpiTest {

    @Test
    public void adaptive() {
        ActivateApi adaptiveExtension = ExtensionLoader.getExtensionLoader(ActivateApi.class).getAdaptiveExtension();
        System.out.println(adaptiveExtension.getClass());

        System.out.println(ExtensionLoader.getExtensionLoader(ActivateApi.class).getDefaultExtension());
    }

    @Test
    public void getExtension() {
        ActivateApi adaptiveExtension = ExtensionLoader.getExtensionLoader(ActivateApi.class).getExtension("mybatis");
        System.out.println(adaptiveExtension);
    }
}
