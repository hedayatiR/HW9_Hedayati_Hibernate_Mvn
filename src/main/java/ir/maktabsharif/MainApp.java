package ir.maktabsharif;

import ir.maktabsharif.model.Student;
import ir.maktabsharif.model.Teacher;
import ir.maktabsharif.model.dao.StudentDAO;
import ir.maktabsharif.model.dao.StudentDAOImpl;
import ir.maktabsharif.model.dao.TeacherDAO;
import ir.maktabsharif.model.dao.TeacherDaoImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        // --------- Teacher part ------------------------------------------------

        // create
        TeacherDAO teacherDao = new TeacherDaoImpl(factory);

        Teacher teacher1 = new Teacher("Reza", "Hedayati", 1, 1000, LocalDate.of(1990, 4, 10));
        teacherDao.create(teacher1);
        Teacher teacher2 = new Teacher("Ali", "Ahmadi", 2, 2000, LocalDate.of(2000, 4, 10));
        teacherDao.create(teacher2);
        Teacher teacher3 = new Teacher("Hossein", "Alavi", 33, 3000, LocalDate.of(1960, 4, 10));
        teacherDao.create(teacher3);
        Teacher teacher4 = new Teacher("Naghi", "Imani", 44, 4000, LocalDate.of(1940, 4, 10));
        teacherDao.create(teacher4);


        List<Teacher> teachers = teacherDao.youngOldTeachers();
        System.out.println();
        System.out.println("================== Youngest & oldest teachers ===============");
        System.out.println("Youngest teacher :");
        System.out.println(teachers.get(0));
        System.out.println("Oldest teacher :");
        System.out.println(teachers.get(1));
        System.out.println("================== End of Youngest & oldest teachers ===============");
        System.out.println();

        List<Teacher> teachersSalary = teacherDao.minMaxSalary();
        System.out.println();
        System.out.println("================== min & max salaries ===============");
        System.out.println("Teacher with max salary:");
        System.out.println(teachersSalary.get(0));
        System.out.println("Teacher with min salary:");
        System.out.println(teachersSalary.get(1));
        System.out.println("================== End of min & max salaries ===============");
        System.out.println();

        // read
        Teacher readTeacher = teacherDao.read(teacher1.getId());
        System.out.println("teacher 1 read result:");
        System.out.println(readTeacher);
        System.out.println();

        //update teacher 1 name. From Reza to Shahram
        teacher1.setFirstName("Shahram");
        teacherDao.update(teacher1);
        Teacher teacherUpdated = teacherDao.read(teacher1.getId());
        System.out.println("teacher 1 after update result:");
        System.out.println(teacherUpdated);
        System.out.println();

        // delete teacher by Id
        teacherDao.delete(teacher1.getId());

        // test delete teacher by teacher code
        teacherDao.deleteByCode(2L); // Ali Ahmadi (teacher2) will be deleted.


        // --------- Student part ------------------------------------------------

        // create
        StudentDAO studentDAO = new StudentDAOImpl(factory);

        Student student1 = new Student("Mohammadali", "Rezvani");
        studentDAO.create(student1);

        Student student2 = new Student("Alimohammad", "Taghavi");
        studentDAO.create(student2);

        Student student3 = new Student("Mohammad", "Nazari");
        studentDAO.create(student3);

        Student student4 = new Student("Sara", "Mohammadi");
        studentDAO.create(student4);

        Student student5 = new Student("Naser", "Abdollahi");
        studentDAO.create(student5);

        // find by Name in students
        List<Student> students = studentDAO.findByName("mohammad");

        System.out.println();
        System.out.println("Students serach result:");
        System.out.println(students);

        // read
        Student readStudent = studentDAO.read(student1.getId());
        System.out.println();
        System.out.println("student 1 read result:");
        System.out.println(readStudent);
        System.out.println();


        //update student 1 name. From Mohammadali to Reza
        student1.setFirstName("Reza");
        studentDAO.update(student1);
        Student studentUpdated = studentDAO.read(student1.getId());
        System.out.println();
        System.out.println("teacher 1 after update result:");
        System.out.println(studentUpdated);
        System.out.println();


        // delete student by Id
        studentDAO.delete(student1.getId());





        factory.close();
    }
}
