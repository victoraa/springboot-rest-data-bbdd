package es.viewnext.servdatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ServerDatosRestApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ServerDatosRestApplication.class, args);

//		String [] beanNames = ctx.getBeanDefinitionNames();
//		
//		Arrays.sort(beanNames);
//		
//		for (String beanName : beanNames) {
//			System.out.println(beanName);
//		}
		System.out.println("Arrancada aplicacion");
	}

}
