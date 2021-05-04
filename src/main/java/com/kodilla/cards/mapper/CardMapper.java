package com.kodilla.cards.mapper;

import com.kodilla.cards.domain.Card;
import com.kodilla.cards.domain.CardDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CardMapper {
    public List<CardDto> mapToCardsDto(List<Card> cards) {
        return cards.stream().map(card -> CardDto.builder()
        .id(card.getId())
        .type(card.getType())
        .nrb(card.getNrb())
        .customerId(card.getCustomerId())
                .build()).collect(Collectors.toList());
    }
}
