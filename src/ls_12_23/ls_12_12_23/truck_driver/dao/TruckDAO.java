package ls_12_23.ls_12_12_23.truck_driver.dao;

import ls_12_23.ls_12_12_23.truck_driver.domain.Truck;

import java.util.List;

public interface TruckDAO extends CrudDAO<Truck> {
    List<Truck> findAllByDriverId(int id);
}
