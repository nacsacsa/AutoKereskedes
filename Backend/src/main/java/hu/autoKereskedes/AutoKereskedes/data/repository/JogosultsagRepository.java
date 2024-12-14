package hu.autoKereskedes.AutoKereskedes.data.repository;

import hu.autoKereskedes.AutoKereskedes.data.entitty.JogosultsagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogosultsagRepository extends JpaRepository<JogosultsagEntity,Long> {
    JogosultsagEntity findByNev(String nev);
}
