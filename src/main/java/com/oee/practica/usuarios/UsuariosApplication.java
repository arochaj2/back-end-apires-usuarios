package com.oee.practica.usuarios;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class UsuariosApplication implements CommandLineRunner {

//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder; 
	
	public static void main(String[] args) {
		SpringApplication.run(UsuariosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		String password ="springboot";
//		
//		for (int i = 0; i < 3; i++) {
//			String passwordBcrypt= passwordEncoder.encode(password);
//			System.out.println(passwordBcrypt);
//			
//		}
//		
		
		
	}

}
