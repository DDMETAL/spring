package first;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpring {

	public static void main(String[] args) {
		String config="applicationContext.xml";
		/*
		 * ApplocationContext是一个接口
		 * ClassPathXmlApplicationContext是一个具体类实现了上述接口
		 * 该类依据类路径来查找配置文件，并启动容器。
		 */
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		System.out.println("启动:"+ac);
		//通过容器，获得一个对象
		/*
		 * Apple.class：方法区中的Aoole类对应的class对象。
		 */
		Apple apple=ac.getBean("apple",Apple.class);
		System.out.println("apple :"+apple);
		
		Date date=ac.getBean("date",Date.class);
		System.out.println("date :"+date);
		
		Calendar cal=ac.getBean("cal",Calendar.class);
		System.out.println("cal :"+cal);
		
		Date time=ac.getBean("time",Date.class);
		System.out.println("time :"+time);
	}

}
