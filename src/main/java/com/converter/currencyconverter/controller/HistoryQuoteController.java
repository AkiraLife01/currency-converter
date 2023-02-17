package com.converter.currencyconverter.controller;

import com.converter.currencyconverter.entity.StoryOperation;
import com.converter.currencyconverter.service.HistoryQuoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryQuoteController {

    private final HistoryQuoteService historyQuoteService;

    public HistoryQuoteController(HistoryQuoteService historyQuoteService) {
        this.historyQuoteService = historyQuoteService;
    }

    @GetMapping
    public List<StoryOperation> getHistoryQuotes(@RequestParam String login) {
        return historyQuoteService.getHistoryQuotes(login);
    }
}
