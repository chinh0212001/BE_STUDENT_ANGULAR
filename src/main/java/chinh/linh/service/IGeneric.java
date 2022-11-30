package chinh.linh.service;

import java.util.List;
import java.util.Optional;

public interface IGeneric <T>{
    List<T>findAll();
    Optional<T>findById(Long id);
    T save(T t);
    void deleteById(Long id);
}
