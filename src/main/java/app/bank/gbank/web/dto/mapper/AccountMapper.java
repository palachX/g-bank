package app.bank.gbank.web.dto.mapper;

import app.bank.gbank.domain.model.Account;
import app.bank.gbank.web.dto.AccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends Mappable<Account, AccountDto> {
}
