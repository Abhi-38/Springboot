package com.abhi.prj;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.WishMessageGenerator;

public class SetterInjectionTest {
	public static void main(String[] args) {
		//create IOC container
		//ApplicationContext ctx = new AnnotationConfigApplicationContext("src/main/java/com/nt/cfgs/applicationContext.xml");
		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory((BeanFactory) new FileSystemResource("src/main/java/com/abhi/prj/applicationContext.xml"));
		//get target bean class obj
		Object obj = dlbf.getBean("god");
		//typecast
		WishMessageGenerator generator = (WishMessageGenerator)obj;
		//invoke b.method
		String result = generator.generateMessage("raja");
		System.out.println("wish message is: "+result);
		
	}//main
}//class
