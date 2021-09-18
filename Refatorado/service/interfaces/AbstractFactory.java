package service.interfaces;

public interface AbstractFactory<T> {

    T create(String tipoMenu);
} 