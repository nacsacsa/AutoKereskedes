package hu.autoKereskedes.AutoKereskedes.data.repository;

import hu.autoKereskedes.AutoKereskedes.data.entitty.JarmuEntity;
import hu.autoKereskedes.AutoKereskedes.data.entitty.RendelesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JarmuRepository extends JpaRepository<JarmuEntity, Long> {
    List<JarmuEntity> findAllByMarka(String marka);
    List<JarmuEntity> findAllByTipus(String tipus);
    List<JarmuEntity> findAllByArBetween(Long kezdoAr, Long vegAr);
    List<JarmuEntity> findAllByEv(Long ev);
    List<JarmuEntity> findAllByEvBetween(Long kezdoEv, Long vegEv);
}
