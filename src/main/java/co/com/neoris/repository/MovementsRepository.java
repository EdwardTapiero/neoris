package co.com.neoris.repository;

import co.com.neoris.entity.Cliente;
import co.com.neoris.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovementsRepository extends JpaRepository<Movimiento, Integer> {

    List<Movimiento> findAllByFecha(LocalDate fecha);

    @Query(value = "SELECT * FROM neoris.movimiento mv WHERE mv.id_cuenta= :idCuenta", nativeQuery = true)
    List<Movimiento> findAllByIdCuenta(@Param("idCuenta") Integer idCuenta);
}
