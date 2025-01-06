package app.bank.gbank.service;

public interface CommandService<T> {

    void create(T object);


}
