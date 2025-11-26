package TiendaSteve.repository;

import TiendaSteve.domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long>{
    
}
