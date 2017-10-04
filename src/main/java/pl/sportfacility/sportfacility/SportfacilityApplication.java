package pl.sportfacility.sportfacility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import pl.sportfacility.sportfacility.config.PersistenceConfig;

@SpringBootApplication
@Import(value = {PersistenceConfig.class})
public class SportfacilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportfacilityApplication.class, args);
	}
}
