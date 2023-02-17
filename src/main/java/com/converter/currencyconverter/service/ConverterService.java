package com.converter.currencyconverter.service;

import com.converter.currencyconverter.dto.AvailableQuotes;
import com.converter.currencyconverter.dto.Quote;
import com.converter.currencyconverter.dto.ConverterRequest;
import com.converter.currencyconverter.dto.ConverterResponse;
import com.converter.currencyconverter.entity.StoryOperation;
import com.converter.currencyconverter.repository.UserOperationRepository;

import com.converter.currencyconverter.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ConverterService {

    private final UserOperationRepository userOperationRepository;

    public ConverterService(UserOperationRepository userOperationRepository) {
        this.userOperationRepository = userOperationRepository;

    }


    public ConverterResponse getConvertedQuote(ConverterRequest converterRequest) throws JsonProcessingException {
        //todo конвертировать(+) -> сохранить в таблицу "История операций(+)"

//        if (!userRepository.existsByLogin(converterRequest.getLogin())) {
//            throw new LoginNotFoundException();
//        }

        // проверка на валидные катировки(USD  а не юзд)

        String charCodeOnInput = converterRequest.getCharCodeOnInput();
        String charCodeOnOutput = converterRequest.getCharCodeOnOutput();
        AvailableQuotes availableQuotes = getAvailableQuotes(converterRequest);
        String stringValueOfQuote = null;
        String stringValueOfQuote2 = null;

        for (Quote quote : availableQuotes.getQuotes()) {
            if (quote.getCharCode().equals(charCodeOnInput)) {
                stringValueOfQuote = quote.getValue();
            } else if (quote.getCharCode().equals(charCodeOnOutput)) {
                stringValueOfQuote2 = quote.getValue();
            }
        }


        char c = '.';

        // todo убедиться что не будет Null (-)
        assert stringValueOfQuote != null;
        int index = stringValueOfQuote.indexOf(',');

        assert stringValueOfQuote2 != null;
        int index2 = stringValueOfQuote2.indexOf(',');

        StringBuilder sb = new StringBuilder(stringValueOfQuote);
        StringBuilder sb2 = new StringBuilder(stringValueOfQuote2);

        sb.setCharAt(index, c);
        sb2.setCharAt(index2, c);

        stringValueOfQuote = sb.toString();
        stringValueOfQuote2 = sb2.toString();

        Double valueOfInputValute = getValueOfInputValute(stringValueOfQuote, availableQuotes);
        Double valueOfOutputValute = getValueOfInputValute(stringValueOfQuote2, availableQuotes);
        double resultTemp = (valueOfInputValute / valueOfOutputValute) * converterRequest.getAmountOnInput();
        BigDecimal y = BigDecimal.valueOf(resultTemp);
        double rs = y.setScale(2, RoundingMode.HALF_UP).doubleValue();
        StoryOperation storyOperation =
                new StoryOperation(charCodeOnInput, charCodeOnOutput,
                        valueOfInputValute, rs, availableQuotes.getDate(),
                        converterRequest.getLogin());

        userOperationRepository.save(storyOperation);

        return new ConverterResponse(rs);
    }

    private Double getValueOfInputValute(String stringValueOfQuote, AvailableQuotes availableQuotes) {
        return Double.parseDouble(stringValueOfQuote);
    }

    private AvailableQuotes getAvailableQuotes(ConverterRequest converterRequest) throws JsonProcessingException {
        String localDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String URI = "https://cbr.ru/scripts/XML_daily.asp?date_req=" + localDate;

        RestTemplate restTemplate = new RestTemplate();
        String quoteXml = restTemplate.getForObject(URI, String.class);

        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);


        XmlMapper xmlMapper = new XmlMapper(module);

        return xmlMapper.readValue(quoteXml, AvailableQuotes.class);
    }
}
