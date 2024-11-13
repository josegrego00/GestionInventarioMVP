package controladores.respositorio;

import java.util.List;

public interface repositorio <T>{
    void create(T t);
    void delete(T t);
    T read();
    void update(T t);
}
