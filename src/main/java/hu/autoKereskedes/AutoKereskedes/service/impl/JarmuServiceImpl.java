package hu.autoKereskedes.AutoKereskedes.service.impl;

import hu.autoKereskedes.AutoKereskedes.data.entitty.JarmuEntity;
import hu.autoKereskedes.AutoKereskedes.data.repository.JarmuRepository;
import hu.autoKereskedes.AutoKereskedes.service.JarmuService;
import hu.autoKereskedes.AutoKereskedes.service.dto.JarmuDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JarmuServiceImpl implements JarmuService {

    @Autowired
    JarmuRepository repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public JarmuDto save(JarmuDto jarmuDto) {
        JarmuEntity entity = mapper.map(jarmuDto, JarmuEntity.class);
        entity = repo.save(entity);
        return mapper.map(entity, JarmuDto.class);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public JarmuDto findById(Long id) {
        JarmuEntity entity = repo.findById(id).orElse(null);
        return mapper.map(entity, JarmuDto.class);
    }

    @Override
    public List<JarmuDto> findAll() {
        List<JarmuEntity> list = repo.findAll();
        return mapper.map(list, new TypeToken<List<JarmuDto>>(){}.getType());
    }

    @Override
    public List<JarmuDto> findAllByMarka(String marka) {
        List<JarmuEntity> list = repo.findAllByMarka(marka);
        return mapper.map(list, new TypeToken<List<JarmuDto>>(){}.getType());
    }

    @Override
    public List<JarmuDto> findAllByTipus(String tipus) {
        List<JarmuEntity> list = repo.findAllByTipus(tipus);
        return mapper.map(list, new TypeToken<List<JarmuDto>>(){}.getType());
    }

    @Override
    public List<JarmuDto> findAllByArBetween(long start, long end) {
        List<JarmuEntity> list = repo.findAllByArBetween(start, end);
        return mapper.map(list, new TypeToken<List<JarmuDto>>(){}.getType());
    }

    @Override
    public List<JarmuDto> findAllByEv(long ev) {
        List<JarmuEntity> list = repo.findAllByEv(ev);
        return mapper.map(list, new TypeToken<List<JarmuDto>>(){}.getType());
    }

    @Override
    public List<JarmuDto> findAllByEvBetween(long start, long end) {
        List<JarmuEntity> list = repo.findAllByEvBetween(start, end);
        return mapper.map(list, new TypeToken<List<JarmuDto>>(){}.getType());
    }

    @Override
    public List<JarmuDto> findAllByAny(String marka, String tipus, Long kezdo_ar, Long veg_ar, Long kezdo_ev, Long veg_ev) {
        List<JarmuEntity> jarmuk = repo.findAll();
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
