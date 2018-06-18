package first;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpring {

	public static void main(String[] args) {
		String config="applicationContext.xml";
		/*
		 * ApplocationContext��һ���ӿ�
		 * ClassPathXmlApplicationContext��һ��������ʵ���������ӿ�
		 * ����������·�������������ļ���������������
		 */
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		System.out.println("����:"+ac);
		//ͨ�����������һ������
		/*
		 * Apple.class���������е�Aoole���Ӧ��class����
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
