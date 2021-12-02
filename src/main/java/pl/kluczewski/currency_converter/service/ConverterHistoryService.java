package pl.kluczewski.currency_converter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.kluczewski.currency_converter.model.entity.ConverterHistory;
import pl.kluczewski.currency_converter.repository.ConverterHistoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConverterHistoryService {

    private final ConverterHistoryRepository converterHistoryRepository;

    public List<ConverterHistory> getAllHistory() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return converterHistoryRepository.findAllByUserEmail(auth.getName());
    }

    public ConverterHistory addHistory(ConverterHistory converterHistory) {
        return converterHistoryRepository.save(converterHistory);
    }

    public void deleteHistory(String userEmail) {
        converterHistoryRepository.deleteById(userEmail);
    }
}
