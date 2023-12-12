package ls_12_23.ls_12_12_23.truck_driver.service;

import ls_12_23.ls_12_12_23.truck_driver.dao.CrudDAO;
import ls_12_23.ls_12_12_23.truck_driver.domain.Truck;

import java.util.List;

public interface TruckService extends CrudDAO<Truck> {
    List<Truck> findAllByDriverId(int id);
}
