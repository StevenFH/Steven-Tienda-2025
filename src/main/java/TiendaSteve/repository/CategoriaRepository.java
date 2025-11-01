package TiendaSteve.repository;
 
import TiendaSteve.domain.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
public interface CategoriaRepository extends JpaRepository<Categoria,Long>{
    public List<Categoria> findByActivoTrue();
    
    //Ejemplo de metodo utlizado para consultas derivadas
    public List<Categoria> findByPrecioBetweenOrderByPrecioAsc(double precioInf, double precioSup);
    
    //Ejemplo de metood utilizado para consultas JPQL
    @Query(value = "SELECT p FROM Producto p WHERE p.precio BETWEEN :precioInf AND :precioSup ORDER BY p.precio ASC")
    public List<Categoria> consultaJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

    //Ejemplo de metodo utilizando consultas SQL nativas
    @Query(nativeQuery = true, 
            value = "SELECT * FROM producto p WHERE p.precio BETWEEN :precioInf AND :precioSup ORDER BY p.precio ASC")
    public List<Categoria> consultaSQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

}