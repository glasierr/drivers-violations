package vlasenko.violations.drivers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vlasenko.violations.drivers.domain.Driver;

import java.util.Optional;

@Repository
public interface DriversRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findById(Long id);
}
