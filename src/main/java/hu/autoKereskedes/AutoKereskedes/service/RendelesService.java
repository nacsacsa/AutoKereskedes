package hu.autoKereskedes.AutoKereskedes.service;

import hu.autoKereskedes.AutoKereskedes.service.dto.JarmuDto;
import hu.autoKereskedes.AutoKereskedes.service.dto.RendelesDto;

import java.util.List;

public interface RendelesService {
    RendelesDto save(RendelesDto rendelesDto);
    void delete(Long id);
    RendelesDto getRendelesById(Long id);
    List<RendelesDto> getAllRendeles();
    List<JarmuDto> getAllJarmuByRendelesId(Long id);
    void deleteJarmuFromRendeles(Long rendelesId, Long jarmuId);
    RendelesDto saveJarmuToRendeles(Long rendelesId, Long jarmuId);
}
