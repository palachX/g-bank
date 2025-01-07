package app.bank.core.web.dto.mapper;

import app.bank.common.domain.model.Account;
import app.bank.core.web.dto.AccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends Mappable<Account, AccountDto> {
}
