package hu.autoKereskedes.AutoKereskedes.data.repository;

import hu.autoKereskedes.AutoKereskedes.data.entitty.FelhasznaloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FelhasznaloRepository extends JpaRepository<FelhasznaloEntity, Long> {
    FelhasznaloEntity findByEmail(String email);
}
