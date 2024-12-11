package hu.autoKereskedes.AutoKereskedes.service.impl;

import hu.autoKereskedes.AutoKereskedes.data.entitty.JarmuEntity;
import hu.autoKereskedes.AutoKereskedes.data.entitty.RendelesEntity;
import hu.autoKereskedes.AutoKereskedes.data.repository.JarmuRepository;
import hu.autoKereskedes.AutoKereskedes.data.repository.RendelesRepository;
import hu.autoKereskedes.AutoKereskedes.service.RendelesService;
import hu.autoKereskedes.AutoKereskedes.service.dto.JarmuDto;
import hu.autoKereskedes.AutoKereskedes.service.dto.RendelesDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendelesServiceImpl implements RendelesService {

    @Autowired
    RendelesRepository rendelesRepository;

    @Autowired
    JarmuRepository jarmuRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public RendelesDto save(RendelesDto rendelesDto) {
        RendelesEntity entity = mapper.map(rendelesDto, RendelesEntity.class);
        entity = rendelesRepository.save(entity);
        return mapper.map(entity, RendelesDto.class);
    }

    @Override
    public void delete(Long id) {
        rendelesRepository.deleteById(id);
    }

    @Override
    public RendelesDto getRendelesById(Long id) {
        RendelesEntity entity = rendelesRepository.findById(id).orElse(null);
        return mapper.map(entity, RendelesDto.class);
    }

    @Override
    public List<RendelesDto> getAllRendeles() {
        List<RendelesEntity> list = rendelesRepository.findAll();
        return mapper.map(list, new TypeToken<List<RendelesDto>>(){}.getType());
    }

    @Override
    public List<JarmuDto> getAllJarmuByRendelesId(Long id) {
        List<JarmuEntity> list = jarmuRepository.findAllById(id);
        return mapper.map(list, new TypeToken<List<JarmuDto>>(){}.getType());
    }
}
