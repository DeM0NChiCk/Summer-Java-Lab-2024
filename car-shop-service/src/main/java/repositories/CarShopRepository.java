package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.CMService.dto.CarShopDto;

public interface CarShopRepository extends JpaRepository<CarShopDto, Long> {
}
