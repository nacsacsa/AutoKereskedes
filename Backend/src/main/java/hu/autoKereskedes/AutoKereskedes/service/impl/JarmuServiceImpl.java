package hu.autoKereskedes.AutoKereskedes.service.impl;

import hu.autoKereskedes.AutoKereskedes.data.entitty.FelhasznaloEntity;
import hu.autoKereskedes.AutoKereskedes.data.entitty.JarmuEntity;
import hu.autoKereskedes.AutoKereskedes.data.repository.FelhasznaloRepository;
import hu.autoKereskedes.AutoKereskedes.data.repository.JarmuRepository;
import hu.autoKereskedes.AutoKereskedes.service.JarmuService;
import hu.autoKereskedes.AutoKereskedes.service.dto.FelhasznaloDto;
import hu.autoKereskedes.AutoKereskedes.service.dto.JarmuDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JarmuServiceImpl implements JarmuService {

    @Autowired
    JarmuRepository jarmuRepository;

    @Autowired
    FelhasznaloRepository felhasznaloRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public JarmuDto save(JarmuDto jarmuDto, FelhasznaloDto felhasznalo) {
        JarmuEntity jarmu = mapper.map(jarmuDto, JarmuEntity.class);
        FelhasznaloEntity felhasz = felhasznaloRepository.findByEmail(felhasznalo.getEmail());
        jarmu.setFelhasznalo(felhasz);
        jarmu = jarmuRepository.save(jarmu);
        return mapper.map(jarmu, JarmuDto.class);
    }

    @Override
    public void delete(Long id) {
        JarmuEntity jarmu = jarmuRepository.getReferenceById(id);
        jarmu.setFelhasznalo(null);
        jarmuRepository.deleteById(jarmu.getId());
    }

    @Override
    public JarmuDto findById(Long id) {
        JarmuEntity entity = jarmuRepository.findById(id).orElse(null);
        return mapper.map(entity, JarmuDto.class);
    }

    @Override
    public List<JarmuDto> findAll() {
        List<JarmuEntity> list = jarmuRepository.findAll();
        return mapper.map(list, new TypeToken<List<JarmuDto>>(){}.getType());
    }

    @Override
    public List<JarmuDto> findAllByMarka(String marka) {
        List<JarmuEntity> list = jarmuRepository.findAllByMarka(marka);
        return mapper.map(list, new TypeToken<List<JarmuDto>>(){}.getType());
    }

    @Override
    public List<JarmuDto> findAllByTipus(String tipus) {
        List<JarmuEntity> list = jarmuRepository.findAllByTipus(tipus);
        return mapper.map(list, new TypeToken<List<JarmuDto>>(){}.getType());
    }

    @Override
    public List<JarmuDto> findAllByArBetween(long start, long end) {
        List<JarmuEntity> list = jarmuRepository.findAllByArBetween(start, end);
        return mapper.map(list, new TypeToken<List<JarmuDto>>(){}.getType());
    }

    @Override
    public List<JarmuDto> findAllByEv(long ev) {
        List<JarmuEntity> list = jarmuRepository.findAllByEv(ev);
        return mapper.map(list, new TypeToken<List<JarmuDto>>(){}.getType());
    }

    @Override
    public List<JarmuDto> findAllByEvBetween(long start, long end) {
        List<JarmuEntity> list = jarmuRepository.findAllByEvBetween(start, end);
        return mapper.map(list, new TypeToken<List<JarmuDto>>(){}.getType());
    }

    @Override
    public List<JarmuDto> findAllByAny(String marka, String tipus, Long kezdo_ar, Long veg_ar, Long kezdo_ev, Long veg_ev) {
        List<JarmuEntity> jarmuk = jarmuRepository.findAll();
        jarmuk = jarmuk.stream()
                .filter(x -> marka == null || x.getMarka().equals(marka))
                .filter(x -> tipus == null || x.getTipus().equals(tipus))
                .filter(x -> kezdo_ar == null || x.getAr() >= kezdo_ar)
                .filter(x -> veg_ar == null || x.getAr() <= veg_ar)
                .filter(x -> kezdo_ev == null || x.getEv() >= kezdo_ev)
                .filter(x -> veg_ev == null || x.getEv() <= veg_ev)
                .toList();

        return mapper.map(jarmuk, new TypeToken<List<JarmuDto>>(){}.getType());
    }
}
