package app.bank.core.web.dto.mapper;

import app.bank.common.domain.model.Card;
import app.bank.core.web.dto.CardDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper extends Mappable<Card, CardDto> {
}
