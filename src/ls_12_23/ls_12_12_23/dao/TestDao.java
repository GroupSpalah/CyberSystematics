package ls_12_23.ls_12_12_23.dao;

public class TestDao {
    public static void main(String[] args) {
        DaoFactory factory = DaoFactory.getInstance(2);//MongoDaoFactory

        StudentDAO studentDAO = factory.getStudentDAO();//MongoStudentDAO

        studentDAO.save(new Student());
    }
}
