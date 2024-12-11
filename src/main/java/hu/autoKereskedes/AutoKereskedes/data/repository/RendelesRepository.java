package hu.autoKereskedes.AutoKereskedes.data.repository;

import hu.autoKereskedes.AutoKereskedes.data.entitty.JarmuEntity;
import hu.autoKereskedes.AutoKereskedes.data.entitty.RendelesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RendelesRepository extends JpaRepository<RendelesEntity, Long> {
}
