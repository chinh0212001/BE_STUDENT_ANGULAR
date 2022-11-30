package chinh.linh.service.student;

import chinh.linh.model.Students;
import chinh.linh.reponsitory.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceIMPL implements IStudentService {
    @Autowired
    IStudentRepository studentRepository;
    @Override
    public List<Students> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Students> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Students save(Students students) {
        return studentRepository.save(students);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }


    @Override
    public List<Students> findAllByNameContaining(String name) {
        return studentRepository.findAllByNameContaining(name);
    }
}
