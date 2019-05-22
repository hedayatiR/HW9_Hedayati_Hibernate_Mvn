package ir.maktabsharif.model.dao;

import ir.maktabsharif.core.dao.BaseDAO;
import ir.maktabsharif.model.Student;

import java.util.List;

public interface StudentDAO extends BaseDAO<Student> {
    List<Student> findByName(String name);
}
