package pl.kluczewski.currency_converter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kluczewski.currency_converter.model.entity.ConverterHistory;
import pl.kluczewski.currency_converter.repository.ConverterHistoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConverterHistoryService {

    private final ConverterHistoryRepository converterHistoryRepository;

    public List<ConverterHistory> getAllValue(Long id) {
        return converterHistoryRepository.findAllByUserId(id);
    }

    public ConverterHistory addHistory(ConverterHistory converterHistory) {
        return converterHistoryRepository.save(converterHistory);
    }

    public void deleteHistory(Long id) {
        converterHistoryRepository.deleteById(id);
    }
}
