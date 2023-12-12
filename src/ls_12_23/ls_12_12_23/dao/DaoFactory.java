package ls_12_23.ls_12_12_23.dao;

import ls_12_23.ls_12_12_23.dao.mongo.MongoDaoFactory;
import ls_12_23.ls_12_12_23.dao.mysql.MySQLDaoFactory;

public abstract class DaoFactory {

    public abstract StudentDAO getStudentDAO();

    public static DaoFactory getInstance(int value) {//factory method
        return switch (value) {
            case 1 -> new MySQLDaoFactory();
            case 2 -> new MongoDaoFactory();
            default -> new MySQLDaoFactory();
        };
    }
}
