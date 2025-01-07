package app.bank.core.web.dto.mapper;

import app.bank.common.domain.model.Transaction;
import app.bank.core.web.dto.TransactionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends Mappable<Transaction, TransactionDto> {
}
