package com.gdu.app01.java01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		/*
			@Configuration, @Bean 에너테이션으로 생성한 Bean을 가져올 때 사용하는 스프링 클래스
			AnnotationConfigApplicationContext
		*/
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);			// AppContext.Java 파일에 있는 Bean을 만들어 주세요
		// AbstractApplicationContext ctx = new AnnotationConfigApplicationContext("com.gdu.app01.java01");	// com.gdu.app01.java01 패키지에 있는 모든 bean을 주세요 
		
		User user1 = ctx.getBean("user1", User.class);
		System.out.println(user1.getId());
		System.out.println(user1.getContact().getTel());
		System.out.println(user1.getContact().getFax());
		
		// contact2, user2 빈을 constructor를 이용해서 만들어 보세요 그리고 MainClass에서 확인하세여.
		
		User user2 = ctx.getBean("user2", User.class);
		System.out.println(user2.getId());
		System.out.println(user2.getContact().getTel());
		System.out.println(user2.getContact().getFax());
		
		ctx.close();
		
	}

}
