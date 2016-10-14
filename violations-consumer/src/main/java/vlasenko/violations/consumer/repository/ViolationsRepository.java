package vlasenko.violations.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vlasenko.violations.consumer.domain.Violation;

public interface ViolationsRepository extends JpaRepository<Violation, Integer> {
}
