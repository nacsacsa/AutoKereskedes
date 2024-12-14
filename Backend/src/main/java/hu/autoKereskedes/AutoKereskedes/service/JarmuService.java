package hu.autoKereskedes.AutoKereskedes.service;

import hu.autoKereskedes.AutoKereskedes.data.entitty.FelhasznaloEntity;
import hu.autoKereskedes.AutoKereskedes.service.dto.FelhasznaloDto;
import hu.autoKereskedes.AutoKereskedes.service.dto.JarmuDto;

import java.util.List;

public interface JarmuService {
    JarmuDto save(JarmuDto termekDto, FelhasznaloDto felhasznalo);
    void delete(Long id);
    JarmuDto findById(Long id);
    List<JarmuDto> findAll();
    List<JarmuDto> findAllByMarka(String marka);
    List<JarmuDto> findAllByTipus(String tipus);
    List<JarmuDto> findAllByArBetween(long start, long end);
    List<JarmuDto> findAllByEv(long ev);
    List<JarmuDto> findAllByEvBetween(long start, long end);
    List<JarmuDto> findAllByAny(String marka, String tipus, Long kezdo_ar, Long veg_ar, Long kezdo_ev, Long veg_ev);
}
