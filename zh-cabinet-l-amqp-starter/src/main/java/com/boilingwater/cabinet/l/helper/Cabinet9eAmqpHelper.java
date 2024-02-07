package com.boilingwater.cabinet.l.helper;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 中辉L系列帮助类
 *
 * @author Benana
 * @since 2024-02-07
 */
@Component
public class Cabinet9eAmqpHelper implements BeanFactoryPostProcessor {

    /**
     * Spring应用上下文环境
     */
    private static ConfigurableListableBeanFactory beanFactory;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Cabinet9eAmqpHelper.beanFactory = beanFactory;
    }

    /**
     * 获取对象
     *
     * @param name Bean名称
     * @param <T>  Bean类型
     * @return Object 一个以所给名字注册的bean的实例
     * @throws BeansException org.springframework.beans.BeansException
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) throws BeansException {
        return (T) beanFactory.getBean(name);
    }

    /**
     * 获取类型为requiredType的对象
     *
     * @param clz Bean类型
     * @param <T> Bean类型
     * @return Bean
     * @throws BeansException org.springframework.beans.BeansException
     */
    public static <T> T getBean(Class<T> clz) throws BeansException {
        return (T) beanFactory.getBean(clz);
    }

}
