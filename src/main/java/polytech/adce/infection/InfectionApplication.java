package polytech.adce.infection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import polytech.adce.infection.Services.DeInfectionService;

@SpringBootApplication
@RestController
public class InfectionApplication {

	public static void main(String[] args) {
		ApplicationContext app = SpringApplication.run(InfectionApplication.class, args);
		DeInfectionService service = app.getBean(DeInfectionService.class);
		service.cleanInfection();
	}


}
