package com.revature.HelloSpring;

import com.revature.models.Pizza;
import com.revature.models.Topping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);

		//Create an ApplicationContext object based off our applicationContext.xml file
		//This object will serve as our Spring IoC container, and manage our beans + dependency container

//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		ApplicationContext ac = new ClassPathXmlApplicationContext("annotationDrivenApplicationContext.xml");

		//We can now use our ApplicationContext (our Spring Container) to do a bunch of stuff with beans
		String[] beanNames = ac.getBeanDefinitionNames();
		for(String bean: beanNames) {
			System.out.println(bean);
		}

		//Ask for a Topping bean and print it out

		Topping t = ac.getBean(Topping.class);
		System.out.println(t);

		//Ask for a pizza bean and print it out

		Pizza p = ac.getBean(Pizza.class);
		System.out.println(p);

		//WOW: We have a Pizza object with a Topping object DEPENDENCY INJECTED for us!
			//We have a whole Topping object instead of a null value right after instantiation
		//It was instantiated and set for us by Spring, since we made Topping a dependency

		//Give some values to the pizza bean
		p.setPizza_id(1);
		p.setCheeseType("Mozzarella");
		p.getTopping().setTopping_id(1);
		p.getTopping().setTopping_name("Pepperoni");
		System.out.println(p);

		System.out.println("============================(Bean Scopes)");

		//Let's get a new pizza and print it out
		Pizza p2 = ac.getBean(Pizza.class);
		System.out.println(p2);

		//Beans by default are something called SINGLETONS (they're singleton scoped)
		//If a class is a singleton, that means that there can only be one instance of it at a time
		//So, p and p2 are the same object with the same values

		//We can change the bean scope to be "prototype" instead of "singleton"
		//This will let us have multiple instances of the Pizza bean

		//Singleton - (Everything is shared but it is literally the same object)
		//Prototype - We get a new instance every time we declare a bean

		//Notice the topping is the same, we never changed it off Singleton scope


	}

}
