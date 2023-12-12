package ls_12_23.ls_12_12_23.dao.mongo;

import ls_12_23.ls_12_12_23.dao.Student;
import ls_12_23.ls_12_12_23.dao.StudentDAO;

public class MongoStudentDAO implements StudentDAO {
    @Override
    public void save(Student student) {
        System.out.println("Save Student object to Mongo database");
    }
}
