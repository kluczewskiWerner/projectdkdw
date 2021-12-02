package pl.kluczewski.currency_converter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kluczewski.currency_converter.model.entity.ConverterHistory;

import java.util.List;

@Repository
public interface ConverterHistoryRepository extends JpaRepository<ConverterHistory, String> {
    List<ConverterHistory> findAllByUserEmail(String userEmail);
}
