package com.converter.currencyconverter.service;

import com.converter.currencyconverter.dto.HistoryResponse;
import com.converter.currencyconverter.entity.StoryOperation;
import com.converter.currencyconverter.repository.UserOperationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryQuoteService {

    private final UserOperationRepository userOperationRepository;

    public HistoryQuoteService(UserOperationRepository userOperationRepository) {
        this.userOperationRepository = userOperationRepository;
    }


    public List<StoryOperation> getHistoryQuotes(String login) {
        return userOperationRepository.findAllByLogin(login);
    }
}
