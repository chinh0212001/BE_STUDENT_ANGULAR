package chinh.linh.service.student;

import chinh.linh.model.Students;
import chinh.linh.service.IGeneric;

import java.util.List;

public interface IStudentService extends IGeneric<Students> {
    List<Students> findAllByNameContaining(String name);
}
