package br.com.chocode.apiWeb.services;

import java.util.List;

public interface LojaChocodeService <T> {
    T save(T t);
    T findById(Long id);
    List<T> findAll();
    void deleter(Long id);
    T update(T t);
}
