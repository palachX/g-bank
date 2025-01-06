package app.bank.gbank.web.dto.mapper;

import app.bank.gbank.domain.model.Transaction;
import app.bank.gbank.web.dto.TransactionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends Mappable<Transaction, TransactionDto> {
}
