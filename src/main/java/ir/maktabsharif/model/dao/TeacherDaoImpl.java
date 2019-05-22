package ir.maktabsharif.model.dao;

import ir.maktabsharif.core.dao.BaseDaoImpl;
import ir.maktabsharif.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl extends BaseDaoImpl<Teacher> implements TeacherDAO {

    public TeacherDaoImpl(SessionFactory factory) {
        super(factory);
    }

    @Override
    protected String getEntity() {
        return "Teacher";
    }

    @Override
    public void deleteByCode(long code) {
        Session session = factory.openSession();

        session.beginTransaction();

        session.createQuery("delete " + getEntity() + " where teacherCode = ?1").setParameter(1, code).executeUpdate();

        session.getTransaction().commit();

        session.close();
    }

    @Override
    public List<Teacher> youngOldTeachers() {
        Session session = factory.openSession();

        Teacher teacher1 =(Teacher) session.createQuery("from Teacher t order by t.birthDay DESC").setMaxResults(1).getSingleResult();
        Teacher teacher2 =(Teacher) session.createQuery("from Teacher t order by t.birthDay").setMaxResults(1).getSingleResult();

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher1);
        teachers.add(teacher2);

        session.close();
        return teachers;
    }

    @Override
    public List<Teacher> minMaxSalary() {
        Session session = factory.openSession();

        Teacher teacher1 =(Teacher) session.createQuery("from Teacher t order by t.salary DESC").setMaxResults(1).getSingleResult();

        Teacher teacher2 =(Teacher) session.createQuery("from Teacher t order by t.salary").setMaxResults(1).getSingleResult();

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher1);
        teachers.add(teacher2);

//        Teacher teacher = (Teacher) session.createQuery("select t from Teacher t where t.salary=" +
//                                "4000").uniqueResult();
//                "(select max(b.salary from Teacher b))").uniqueResult();

        session.close();
        return teachers;
    }
}
