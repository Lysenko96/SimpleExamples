package org.example.jparelations.service;


import org.example.jparelations.entity.Husband;
import org.example.jparelations.entity.Student;
import org.example.jparelations.entity.Teacher;
import org.example.jparelations.entity.Wife;
import org.example.jparelations.repository.HusbandRepository;
import org.example.jparelations.repository.StudentRepository;
import org.example.jparelations.repository.TeacherRepository;
import org.example.jparelations.repository.WifeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private HusbandRepository husbandRepository;
    private WifeRepository wifeRepository;
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;

    public PersonService(HusbandRepository husbandRepository, WifeRepository wifeRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.husbandRepository = husbandRepository;
        this.wifeRepository = wifeRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    public void saveWife(Wife wife){
        wifeRepository.save(wife);
    }
    public void saveHusband (Husband husband){
        husbandRepository.save(husband);
    }

    public void deleteTeacher(Teacher teacher) {
        teacherRepository.deleteById(teacher.getId());
    }

    public Wife findWifeById(long id){
        return wifeRepository.findById(id).orElse(null);
    }

    public Husband findHusbandById(long id){
        return husbandRepository.findById(id).orElse(null);
    }

    public void deleteHusband(Husband husband) {
       husbandRepository.delete(husband);
    }

    public void deleteWife(Wife wife){
        Wife wifeDb = findWifeById(wife.getId());
        Husband husband = findHusbandById(wifeDb.getHusband().getId());
        husband.setWife(null);
        saveHusband(husband);
        wifeRepository.delete(wife);
    }

    public void saveTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public Teacher findTeacherById(long id) {
        // get list in session before commit transaction
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        if (teacher != null ) {
//            teacher.setStudents(new ArrayList<>());
            teacher.setStudents(findAllStudentsByTeacherId(teacher.getId()));
            for(Student student : teacher.getStudents()) student.setTeacher(teacher);
          //  System.out.println(teacher);
        }
        return teacher;
      //  return teacherRepository.findById(id).orElse(null);
    }

    public List<Student> findAllStudentsByTeacherId(long id){
        return studentRepository.findAllByTeacherId(id);
    }


    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

}
