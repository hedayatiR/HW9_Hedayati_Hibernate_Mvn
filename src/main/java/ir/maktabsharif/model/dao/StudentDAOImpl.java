package ir.maktabsharif.model.dao;

import ir.maktabsharif.core.dao.BaseDAO;
import ir.maktabsharif.core.dao.BaseDaoImpl;
import ir.maktabsharif.model.Student;
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
        //TODO
        // student query
        return null;
    }
}
