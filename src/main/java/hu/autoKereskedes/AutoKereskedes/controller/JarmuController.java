package hu.autoKereskedes.AutoKereskedes.controller;

import hu.autoKereskedes.AutoKereskedes.service.JarmuService;
import hu.autoKereskedes.AutoKereskedes.service.dto.JarmuDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JarmuController {

    @Autowired
    JarmuService service;

    @PostMapping("/save/jarmu")
    public JarmuDto saveJarmu(@RequestBody JarmuDto jarmu) {
        return service.save(jarmu);
    }

    @DeleteMapping("/delete/jarmu")
    public void deleteJarmu(@RequestParam() Long id) {
        service.delete(id);
    }

    @PutMapping("/update/jarmu")
    public JarmuDto updateJarmu(@RequestBody JarmuDto jarmu) {
        if(jarmu.getId() > 0L){
            return service.save(jarmu);
        } else {
            return null;
        }
    }

    @GetMapping("/jarmu")
    public List<JarmuDto> findAllJarmu(){
        return service.findAll();
    }

    @GetMapping("/jarmu/id")
    public JarmuDto findById(@RequestBody Long id){
        return service.findById(id);
    }

    @GetMapping("/jarmu/marka")
    public List<JarmuDto> findAllByMarka(@RequestBody String marka){
        return service.findAllByMarka(marka);
    }

    @GetMapping("/jarmu/tipus")
    public List<JarmuDto> findAllByTipus(@RequestBody String tipus){
        return service.findAllByTipus(tipus);
    }

    @GetMapping("/jarmu/ev")
    public List<JarmuDto> findAllByEv(@RequestBody Long ev){
        return service.findAllByEv(ev);
    }

    @GetMapping("/jarmu/evkozott")
    public List<JarmuDto> findByEvBetween(@RequestBody Long kezdo_ev, @RequestBody Long veg_ev){
        return service.findAllByEvBetween(kezdo_ev, veg_ev);
    }

    @GetMapping("/jarmu/arkozott")
    public List<JarmuDto> findByArBetween(@RequestBody Long kezdo_ar, @RequestBody Long veg_ar){
        return service.findAllByArBetween(kezdo_ar, veg_ar);
    }

    @GetMapping("/jarmu/filter")
    public List<JarmuDto> findFiltered(@RequestBody(required = false) String marka,
                                        @RequestBody(required = false) String tipus,
                                        @RequestBody(required = false) Long kezdo_ar,
                                        @RequestBody(required = false) Long veg_ar,
                                        @RequestBody(required = false) Long kezdo_ev,
                                       @RequestBody(required = false) Long veg_ev){
        return service.findAllByAny(marka,tipus,kezdo_ar,veg_ar,kezdo_ev,veg_ev);

    }
}
