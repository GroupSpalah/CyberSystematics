package ls_12_23.ls_12_12_23.truck_driver.service.impl;

import ls_12_23.ls_12_12_23.truck_driver.dao.CrudDAO;
import ls_12_23.ls_12_12_23.truck_driver.dao.impl.DriverDaoImpl;
import ls_12_23.ls_12_12_23.truck_driver.domain.Driver;
import ls_12_23.ls_12_12_23.truck_driver.service.CrudService;


import java.util.List;

public class DriverServiceImpl implements CrudService<Driver> {

    private CrudDAO<Driver> dao;

    public DriverServiceImpl() {
        dao = new DriverDaoImpl();
    }

    @Override
    public void create(Driver driver) {
        dao.create(driver);
    }

    @Override
    public void update(Driver driver) {
        dao.update(driver);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public Driver findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Driver> findAll() {
        return dao.findAll();
    }
}
