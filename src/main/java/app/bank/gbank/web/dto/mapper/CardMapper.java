package app.bank.gbank.web.dto.mapper;

import app.bank.gbank.domain.model.Card;
import app.bank.gbank.web.dto.CardDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper extends Mappable<Card, CardDto> {
}
