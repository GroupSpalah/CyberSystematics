package ls_12_23.ls_12_12_23.dao.mongo;

import ls_12_23.ls_12_12_23.dao.DaoFactory;
import ls_12_23.ls_12_12_23.dao.StudentDAO;

public class MongoDaoFactory extends DaoFactory {
    @Override
    public StudentDAO getStudentDAO() {
        return new MongoStudentDAO();
    }
}
