package iuh.fit.se.repositories;

import iuh.fit.se.entities.DienThoai;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DienThoaiRepository extends JpaRepository<DienThoai, Integer> {
}
