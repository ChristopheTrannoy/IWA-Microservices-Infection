package polytech.adce.infection.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import polytech.adce.infection.Models.Infected;
import polytech.adce.infection.Repositories.InfectedRepository;

import java.util.Date;
import java.util.List;

@Service
public class DeInfectionService {
    @Autowired
    private InfectedRepository infectedRepository;

    public void cleanInfection() {
        while (true) {
            List<Infected> infectedList = infectedRepository.findAll();
            Date currentDate = new Date(System.currentTimeMillis());
            for (Infected infected : infectedList) {
                if (infected.getDate_end_infected().before(currentDate)) {
                    infectedRepository.delete(infected);
                }
            }
        }
    }

}
