package com.asistencia;

import com.asistencia.Entity.Users;
import com.asistencia.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AsistenciaSpringbootIntellijApplication {

	public static void main(String[] args) { SpringApplication.run(AsistenciaSpringbootIntellijApplication.class, args);}

	@Bean
	CommandLineRunner runner(UserRepository UserRepository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				List<Users> users = Arrays.asList(
						new Users("Miguel", "Limpias", "miguel.limpias@gmail.com", LocalDateTime.now() ),
						new Users("Aldo", "Justiniano", "aldo.justiniano@hotmail.com", LocalDateTime.now()),
						new Users("Ysela", "Caballero", "ysela.caballero@outlook.com", LocalDateTime.now()),
						new Users("Herman", "Hinojosa", "herman.hinojosa@gmail.com", LocalDateTime.now()),
						new Users("Tomas", "Valdelomar", "tomas.valdelomar@gmail.com", LocalDateTime.now())
				);
				UserRepository.saveAll(users);
			}
		};
	};


}
