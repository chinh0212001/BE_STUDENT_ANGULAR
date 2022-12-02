package chinh.linh.reponsitory;

import chinh.linh.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IStudentRepository extends JpaRepository<Students,Long> {
    List<Students> findAllByNameContaining(String name);
}
