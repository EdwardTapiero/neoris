package co.com.neoris.repository;

import co.com.neoris.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Cuenta, Integer> {
}
