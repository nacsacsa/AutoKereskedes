package hu.autoKereskedes.AutoKereskedes.service.impl;

import hu.autoKereskedes.AutoKereskedes.data.entitty.FelhasznaloEntity;
import hu.autoKereskedes.AutoKereskedes.data.repository.FelhasznaloRepository;
import hu.autoKereskedes.AutoKereskedes.data.repository.RendelesRepository;
import hu.autoKereskedes.AutoKereskedes.service.FelhasznaloService;
import hu.autoKereskedes.AutoKereskedes.service.dto.FelhasznaloDto;
import hu.autoKereskedes.AutoKereskedes.service.dto.JarmuDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FelhasznaloServiceImpl implements FelhasznaloService {

    @Autowired
    FelhasznaloRepository repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public FelhasznaloDto findByEmail(String email) {
        FelhasznaloEntity entity = repo.findByEmail(email);
        return mapper.map(entity, FelhasznaloDto.class);
    }
}
