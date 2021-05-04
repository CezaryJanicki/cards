package com.kodilla.cards.controller;

import com.kodilla.cards.domain.CardDto;
import com.kodilla.cards.domain.GetCardsResponse;
import com.kodilla.cards.mapper.CardMapper;
import com.kodilla.cards.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@Slf4j
@RestController
@RequestMapping(value = "/v1/cards", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class CardController {

    @Autowired
    private CardService cardService;

    @Autowired
    private CardMapper cardMapper;

    @GetMapping
    public GetCardsResponse getCards(@RequestParam("customerId") Long customerId) {
        List<CardDto> cards = cardService.getCardsForCustomer((customerId));
        return GetCardsResponse.of(cards);
    }
}
