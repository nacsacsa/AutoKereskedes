package hu.autoKereskedes.AutoKereskedes.data.repository;

import hu.autoKereskedes.AutoKereskedes.data.entitty.JarmuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JarmuRepository extends JpaRepository<JarmuEntity, Long> {
    List<JarmuEntity> findAllByMarka(String marka);
    List<JarmuEntity> findAllByEv_jarat(String ev);
    List<JarmuEntity> findAllByTipus(String tipus);
    List<JarmuEntity> findAllByArBetween(Long kezdo_ar, Long veg_ar);
}
