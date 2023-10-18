package com.example.lab5.Repository;

import java.util.List;

public interface Repository<T> {
    T add(T a);
    List<T> getAll();


}
