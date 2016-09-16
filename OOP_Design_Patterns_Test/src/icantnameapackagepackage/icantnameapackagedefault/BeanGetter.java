package icantnameapackagepackage.icantnameapackagedefault;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanGetter {
	private static ApplicationContext context = new ClassPathXmlApplicationContext(
			"beans.xml");

	public static Object getBean(String beanName) {
		return context.getBean(beanName);
	}
}
