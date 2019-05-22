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

        Teacher teacher1 = (Teacher) session.createQuery("select t from Teacher t where t.birthDay=" +
                " (select max(b.birthDay) from Teacher b)").uniqueResult();

        Teacher teacher2 = (Teacher) session.createQuery("select t from Teacher t where t.birthDay=" +
                " (select min(b.birthDay) from Teacher b)").uniqueResult();

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher1);
        teachers.add(teacher2);

        session.close();
        return teachers;
    }

    @Override
    public List<Teacher> minMaxSalary() {
        Session session = factory.openSession();

        Teacher teacher1 = (Teacher) session.createQuery("select t from Teacher t where t.salary=" +
                " (select max(b.salary) from Teacher b)").uniqueResult();

        Teacher teacher2 = (Teacher) session.createQuery("select t from Teacher t where t.salary=" +
                " (select min(b.salary) from Teacher b)").uniqueResult();

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher1);
        teachers.add(teacher2);

        session.close();
        return teachers;
    }
}
