package pl.kluczewski.currency_converter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kluczewski.currency_converter.model.entity.ConverterHistory;
import pl.kluczewski.currency_converter.service.ConverterHistoryService;
import pl.kluczewski.currency_converter.webclient.dto.ConverterHistoryDto;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/history")
public class ConverterHistoryController {

    private final ConverterHistoryService converterHistoryService;

    @GetMapping("/all/{userId}")
    public List<ConverterHistoryDto> getAllHistory(@PathVariable Long userId) {
        return ConverterHistoryDtoMapper.mapToConverterHistoryDtos(converterHistoryService.getAllValue(userId));
    }

    @PostMapping
    public ConverterHistory addHistory(@RequestBody ConverterHistory converterHistory) {
        return converterHistoryService.addHistory(converterHistory);
    }

    @DeleteMapping("{id}")
    public void deleteHistory(@PathVariable Long id) {
        converterHistoryService.deleteHistory(id);
    }
}
