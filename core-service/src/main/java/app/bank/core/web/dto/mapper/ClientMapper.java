package app.bank.core.web.dto.mapper;

import app.bank.common.domain.model.Client;
import app.bank.core.web.dto.ClientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper extends Mappable<Client, ClientDto> {
}
