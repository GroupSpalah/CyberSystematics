package ls_12_23.ls_12_12_23.truck_driver.service.impl;

import ls_12_23.ls_12_12_23.truck_driver.dao.TruckDAO;
import ls_12_23.ls_12_12_23.truck_driver.dao.impl.TruckDaoImpl;
import ls_12_23.ls_12_12_23.truck_driver.domain.Truck;
import ls_12_23.ls_12_12_23.truck_driver.service.TruckService;

import java.util.List;

/**
 * *** Сohesion and coupling:
 * 		### Когезия означает что класс или модуль может делать.
 * 		Низкая когезия означает что класс делает много операций,
 * 		класс несфукосирован на том, что он должен делать.
 * 		Высокая когезия означает что класс сфокусирован на том, что он должен делать,
 * 		то есть только методы относящиеся к намерениям класса.
 *
 * 		### Связанность - термин относящийся как зависят или относятся два класса или модуля.
 * 		Для низко связанных классов, изменения кода в одном классе не должно влиять на другой класс.
 * 		Высокое связывание приводит к тому, что сложно менять и поддерживать код,
 * 		поскольку классы тесно связаны,
 * 		внесение изменений может потребовать полной модернизации системы
 *
 *         Good software design has high cohesion and low coupling.
 */

public class TruckServiceImpl implements TruckService {
    private TruckDAO dao;

    public TruckServiceImpl() {
        dao = new TruckDaoImpl();
    }

    @Override
    public void create(Truck truck) {
        dao.create(truck);
    }

    @Override
    public void update(Truck truck) {
        dao.update(truck);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public Truck findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Truck> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Truck> findAllByDriverId(int id) {
        return dao.findAllByDriverId(id);
    }
}
