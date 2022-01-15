package pl.kluczewski.currency_converter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.kluczewski.currency_converter.model.entity.Customer;

import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface UserRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}
