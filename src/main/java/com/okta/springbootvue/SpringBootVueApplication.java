package com.okta.springbootvue;

import com.okta.springbootvue.model.Todo;
import com.okta.springbootvue.repository.TodoRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.TimeZone;
import java.util.stream.Stream;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackageClasses = {
		SpringBootVueApplication.class,
		Jsr310Converters.class
})
public class SpringBootVueApplication {

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootVueApplication.class, args);
	}

	// Bootstrap some test data into in-memory database, just enable it on first starting of the app
//	@Bean
//	ApplicationRunner init(TodoRepository repository) {
//		return args -> {
//			Stream.of("Buy milk", "Eat pizza", "Write tutorial", "Study Vue.js", "GO kayaking").forEach(name -> {
//				Todo todo = new Todo();
//				todo.setTitle(name);
//				repository.save(todo);
//			});
//			repository.findAll().forEach(System.out::println);
//		};
//	}

	// Fix the CORS errors
	@Bean
	public FilterRegistrationBean simpleCorsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		/**
		 * URL below needs to match the Vue client URL and port
		 */
		config.setAllowedOrigins(Collections.singletonList("http://localhost:8080"));
		config.setAllowedMethods(Collections.singletonList("*"));
		config.setAllowedHeaders(Collections.singletonList("*"));
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

}

