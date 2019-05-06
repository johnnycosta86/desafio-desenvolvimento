package br.com.cresol.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author johnny
 *
 */
@SpringBootApplication
public class EmprestimoApplication extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EmprestimoApplication.class);
    }

	/**
	 * SpringBoot Application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(EmprestimoApplication.class, args);
	}
}
