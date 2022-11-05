package hello.post_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PostCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostCrudApplication.class, args);
	}

}
