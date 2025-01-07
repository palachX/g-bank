package app.bank.core.service;

public interface CommandService<T> {

    void create(T object);

}
