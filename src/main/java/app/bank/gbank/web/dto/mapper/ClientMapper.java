package app.bank.gbank.web.dto.mapper;

import app.bank.gbank.domain.model.Client;
import app.bank.gbank.web.dto.ClientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper extends Mappable<Client, ClientDto> {
}
