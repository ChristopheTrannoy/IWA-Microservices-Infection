package polytech.adce.infection.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import polytech.adce.infection.Models.Infected;
import polytech.adce.infection.Repositories.InfectedRepository;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class InfectedController {

    @Autowired
    private InfectedRepository infectedRepository;

    @GetMapping
    public List<Infected> infectedList() {
        return infectedRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void infection(@RequestBody final String username){
        Infected infected = new Infected();
        infected.setUsername(username);
        long currentTime = System.currentTimeMillis();
        Date date = new Date(currentTime);
        infected.setDate_start_infected(date);
        long endTime = currentTime + 1814400000;
        date = new Date(endTime);
        infected.setDate_end_infected(date);
        infected.setContact(false);
        infectedRepository.save(infected);
    }

}
