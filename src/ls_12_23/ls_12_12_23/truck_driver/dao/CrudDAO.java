package ls_12_23.ls_12_12_23.truck_driver.dao;

import ls_12_23.ls_12_12_23.truck_driver.domain.Truck;

import java.util.List;

public interface CrudDAO<T> {
    void create(T t);
    void update(T t);
    void deleteById(int id);
    T findById(int id);
    List<T> findAll();
}
