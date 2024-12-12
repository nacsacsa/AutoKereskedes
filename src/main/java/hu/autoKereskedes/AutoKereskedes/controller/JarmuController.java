package hu.autoKereskedes.AutoKereskedes.controller;

import hu.autoKereskedes.AutoKereskedes.data.entitty.FelhasznaloEntity;
import hu.autoKereskedes.AutoKereskedes.service.FelhasznaloService;
import hu.autoKereskedes.AutoKereskedes.service.JarmuService;
import hu.autoKereskedes.AutoKereskedes.service.dto.FelhasznaloDto;
import hu.autoKereskedes.AutoKereskedes.service.dto.JarmuDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JarmuController {

    @Autowired
    JarmuService jarmuService;

    @Autowired
    FelhasznaloService felhasznaloService;

    @PostMapping("/save/jarmu")
    public JarmuDto saveJarmu(@RequestBody JarmuDto jarmu, Authentication authentication) {
        String email = authentication.getName();
        FelhasznaloDto felhasznalo = felhasznaloService.findByEmail(email);
        if (felhasznalo == null) {
            throw new RuntimeException("Felhasználó nem található.");
        }
        return jarmuService.save(jarmu, felhasznalo);
    }

    @DeleteMapping("/delete/jarmu")
    public void deleteJarmu(@RequestParam() Long id) {
        jarmuService.delete(id);
    }

    @PutMapping("/update/jarmu")
    public JarmuDto updateJarmu(@RequestBody JarmuDto jarmu, Authentication authentication) {
        if (jarmu.getId() > 0L) {
            String email = authentication.getName();
            FelhasznaloDto felhasznalo = felhasznaloService.findByEmail(email);
            JarmuDto dto = jarmuService.findById(jarmu.getId());
            if (!dto.getFelhasznalo().getId().equals(felhasznalo.getId())) {
                throw new RuntimeException("Felhasználó nem saját járműjét akarja módosítani.");
            }
            return jarmuService.save(jarmu, dto.getFelhasznalo());
        } else {
            return null;
        }
    }

    @GetMapping("/jarmu")
    public List<JarmuDto> findAllJarmu(){
        return jarmuService.findAll();
    }

    @GetMapping("/jarmu/id")
    public JarmuDto findById(@RequestBody Long id){
        return jarmuService.findById(id);
    }

    @GetMapping("/jarmu/marka")
    public List<JarmuDto> findAllByMarka(@RequestBody String marka){
        return jarmuService.findAllByMarka(marka);
    }

    @GetMapping("/jarmu/tipus")
    public List<JarmuDto> findAllByTipus(@RequestBody String tipus){
        return jarmuService.findAllByTipus(tipus);
    }

    @GetMapping("/jarmu/ev")
    public List<JarmuDto> findAllByEv(@RequestBody Long ev){
        return jarmuService.findAllByEv(ev);
    }

    @GetMapping("/jarmu/evkozott")
    public List<JarmuDto> findByEvBetween(@RequestBody Long kezdo_ev, @RequestBody Long veg_ev){
        return jarmuService.findAllByEvBetween(kezdo_ev, veg_ev);
    }

    @GetMapping("/jarmu/arkozott")
    public List<JarmuDto> findByArBetween(@RequestBody Long kezdo_ar, @RequestBody Long veg_ar){
        return jarmuService.findAllByArBetween(kezdo_ar, veg_ar);
    }

    @GetMapping("/jarmu/filter")
    public List<JarmuDto> findFiltered(@RequestBody(required = false) String marka,
                                        @RequestBody(required = false) String tipus,
                                        @RequestBody(required = false) Long kezdo_ar,
                                        @RequestBody(required = false) Long veg_ar,
                                        @RequestBody(required = false) Long kezdo_ev,
                                       @RequestBody(required = false) Long veg_ev){
        return jarmuService.findAllByAny(marka,tipus,kezdo_ar,veg_ar,kezdo_ev,veg_ev);

    }
}
