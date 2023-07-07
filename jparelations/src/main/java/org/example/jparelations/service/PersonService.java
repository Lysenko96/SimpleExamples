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

    public Wife findWifeById(long id){
        return wifeRepository.findById(id).orElse(null);
    }

    public Husband getHusbandById(long id){
        return husbandRepository.findById(id).orElse(null);
    }

    public void deleteHusbandById(long id) {
        husbandRepository.deleteById(id);
    }

    public void deleteWifeById(long id){
        wifeRepository.deleteById(id);
    }

    public void saveTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public Teacher findTeacherById(long id) { return teacherRepository.findById(id).orElse(null); }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

}
