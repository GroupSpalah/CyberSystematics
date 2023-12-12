package ls_12_23.ls_12_12_23.dao.mysql;

import ls_12_23.ls_12_12_23.dao.DaoFactory;
import ls_12_23.ls_12_12_23.dao.StudentDAO;

public class MySQLDaoFactory extends DaoFactory {
    @Override
    public StudentDAO getStudentDAO() {
        return new MySQLStudentDAO();
    }
}
