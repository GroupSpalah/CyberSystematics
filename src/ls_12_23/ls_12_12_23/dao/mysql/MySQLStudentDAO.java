package ls_12_23.ls_12_12_23.dao.mysql;

import ls_12_23.ls_12_12_23.dao.Student;
import ls_12_23.ls_12_12_23.dao.StudentDAO;

public class MySQLStudentDAO implements StudentDAO {
    @Override
    public void save(Student student) {
        System.out.println("Save Student object to MySQL database");
    }
}
