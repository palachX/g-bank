package app.bank.common.service;

public interface CommandService<T> {

    void create(T object);

}
