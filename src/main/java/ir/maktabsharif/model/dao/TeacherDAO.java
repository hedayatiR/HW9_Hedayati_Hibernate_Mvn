package ir.maktabsharif.model.dao;

import ir.maktabsharif.core.dao.BaseDAO;
import ir.maktabsharif.model.Teacher;

import java.util.List;

public interface TeacherDAO extends BaseDAO<Teacher> {
    void deleteByCode(long code);

    List<Teacher> youngOldTeachers();

    List<Teacher> minMaxSalary();

}
