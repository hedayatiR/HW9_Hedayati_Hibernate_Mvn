package ir.maktabsharif.model.dao;

import ir.maktabsharif.core.dao.BaseDaoImpl;
import ir.maktabsharif.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentDAOImpl extends BaseDaoImpl<Student> implements StudentDAO {

    public StudentDAOImpl(SessionFactory factory) {
        super(factory);
    }

    @Override
    protected String getEntity() {
        return "Student";
    }

    @Override
    public List<Student> findByName(String name) {

        Session session = factory.openSession();

        List<Student> students = session.createQuery("select t from Student t where "
                + "( lower(t.firstName) LIKE :searchKeyword )"
                + " OR ( lower(t.lastName) LIKE :searchKeyword )")
                .setParameter("searchKeyword", "%"+name.toLowerCase()+"%" )
                .list();

        session.close();
        return students;
    }
}
