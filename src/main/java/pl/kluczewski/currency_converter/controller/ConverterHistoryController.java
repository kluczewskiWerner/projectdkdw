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

    @GetMapping("/all/")
    public List<ConverterHistoryDto> getAllHistory() {
        return ConverterHistoryDtoMapper.mapToConverterHistoryDtos(converterHistoryService.getAllHistory());
    }

    @PostMapping
    public ConverterHistory addHistory(@RequestBody ConverterHistory converterHistory) {
        return converterHistoryService.addHistory(converterHistory);
    }

    @DeleteMapping("/{userEmail}/")
    public void clearAllHistory(@PathVariable String userEmail) {
        converterHistoryService.deleteHistory(userEmail);
    }
}
