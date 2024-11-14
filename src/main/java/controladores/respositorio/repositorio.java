package controladores.respositorio;

import java.util.List;

public interface repositorio <T>{
    void create(T t);
    void delete(T t);
    T read(int i);
    void update(T t);
}
