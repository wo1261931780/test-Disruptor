package wo1261931780.testDisruptor.config;

/**
 * Created by Intellij IDEA.
 * Project:test-Disruptor
 * Package:wo1261931780.testDisruptor.config
 *
 * @author liujiajun_junw
 * @Date 2023-10-11-07  星期五
 * @Description
 */

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取实例化对象
 *
 * @author 64234
 */
@Component
public class BeanManager implements ApplicationContextAware {

	private static ApplicationContext applicationContext = null;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}

	public static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}
}
