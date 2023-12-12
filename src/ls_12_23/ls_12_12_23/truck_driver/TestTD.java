package ls_12_23.ls_12_12_23.truck_driver;

import ls_12_23.ls_12_12_23.truck_driver.domain.Driver;
import ls_12_23.ls_12_12_23.truck_driver.service.CrudService;
import ls_12_23.ls_12_12_23.truck_driver.service.impl.DriverServiceImpl;

/**
 * Даны два домена Truck(id, model, modelYear) и
 * Driver(id, firstName, lastName, age, qualification(Enum), List<Truck>).
 * Создать OneToMany отношение, а также CRUD(findAll) операции, показывать все trucks для конкретного Driver.
 */
public class TestTD {
    public static void main(String[] args) {
        CrudService<Driver> driverService = new DriverServiceImpl();

        driverService.create(new Driver());
    }
}
