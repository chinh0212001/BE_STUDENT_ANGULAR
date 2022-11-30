package chinh.linh.reponsitory;

import chinh.linh.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Students,Long> {
    List<Students> findAllByNameContaining(String name);
}
