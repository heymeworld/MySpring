package com.fastcampus.ch3;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

public class ApplicationContextTest {
	public static void main(String args[]) {
		ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
		System.out.println("ac="+ac);
		Car car  = (Car) ac.getBean("car"); // 이름으로 빈 검색(수동 찾기)
        Car car2 = (Car) ac.getBean(Car.class);   // 타입으로 빈 검색(수동 찾기)
        System.out.println("car = " + car);
        System.out.println("car2 = " + car2);
//        car.engine = (Engine)ac.getBean("engine"); // 수동으로 찾기
//        car.door = ac.getBean("door", Door.class); // by Name, by Type
        System.out.println("car.engine = " + car.engine);	
        System.out.println("car.door = " + car.door);
//      toString()  
        System.out.println("car = " + car);
//      @Scope("prototype") -> clone <> @Scope("singlton" -> 캐싱, 재사용)
        System.out.println("door = " + ac.getBean("door"));
        System.out.println("door = " + ac.getBean("door"));
        System.out.println("door = " + ac.getBean("door"));
        
        System.out.println(Arrays.toString(ac.getBeanDefinitionNames()));
/*      등록 여부 확인
 		[car, 
        door, 
        engine, 
        org.springframework.context.annotation.internalConfigurationAnnotationProcessor, 
        org.springframework.context.annotation.internalAutowiredAnnotationProcessor, 
        org.springframework.context.annotation.internalRequiredAnnotationProcessor, 
        org.springframework.context.annotation.ConfigurationClassPostProcessor$ImportAwareBeanPostProcessor#0]
*/
	}
}

//<bean id="car" class="com.fastcampus.ch3.Car"/>
@Component // AC에 Car를 빈으로 자동 등록
class Car {
	@Autowired Engine engine; // 자동으로 찾기
	@Autowired Door door;
	@Override
	public String toString() {
		return "Car [engine=" + engine + ", door=" + door + "]";
	}
	
}

@Component
class Engine {}

@Component
@Scope("prototype")
class Door {}