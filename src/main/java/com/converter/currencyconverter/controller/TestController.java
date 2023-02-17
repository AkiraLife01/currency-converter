package com.converter.currencyconverter.controller;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class TestController {

//    @GetMapping("/xml")
//    public AvailableQuotes getXML() throws IOException, ParserConfigurationException, URISyntaxException, SAXException {
//////        String localDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
////        String URI = "https://cbr.ru/scripts/XML_daily.asp?date_req=" + localDate;
////
////        RestTemplate restTemplate = new RestTemplate();
////        String quoteXml = restTemplate.getForObject(URI, String.class);
////
////        JacksonXmlModule module = new JacksonXmlModule();
////        module.setDefaultUseWrapper(false);
////
////
////        XmlMapper xmlMapper = new XmlMapper(module);
////        AvailableQuotes availableQuotes = xmlMapper.readValue(quoteXml, AvailableQuotes.class);
////
////
////        return availableQuotes;
//    }
}
