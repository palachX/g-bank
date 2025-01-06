package app.bank.gbank.web.dto.mapper;

import java.util.List;

public interface Mappable<E, D> {

    D toDto(E entity);

    E toEntity(D dto);

    List<D> toDto(List<E> entities);

}
