package polytech.adce.infection.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import polytech.adce.infection.Models.Infected;

public interface InfectedRepository extends JpaRepository<Infected, Long> {



}
