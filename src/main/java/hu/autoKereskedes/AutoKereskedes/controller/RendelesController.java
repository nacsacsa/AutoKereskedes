package hu.autoKereskedes.AutoKereskedes.controller;

import hu.autoKereskedes.AutoKereskedes.service.FelhasznaloService;
import hu.autoKereskedes.AutoKereskedes.service.RendelesService;
import hu.autoKereskedes.AutoKereskedes.service.dto.FelhasznaloDto;
import hu.autoKereskedes.AutoKereskedes.service.dto.JarmuDto;
import hu.autoKereskedes.AutoKereskedes.service.dto.RendelesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RendelesController {

    @Autowired
    RendelesService service;

    @Autowired
    FelhasznaloService felhasznaloService;

    @PostMapping("/save/rendeles")
    public RendelesDto saveRendeles(@RequestBody RendelesDto rendeles, Authentication authentication) {
        String email = authentication.getName();
        FelhasznaloDto felhasznalo = felhasznaloService.findByEmail(email);
        if (felhasznalo == null) {
            throw new RuntimeException("Felhasználó nem található.");
        }
        return service.save(rendeles, felhasznalo);
    }

    @DeleteMapping("/delete/rendeles")
    public void deleteRendeles(@RequestParam() Long id) {
        service.delete(id);
    }

    @PutMapping("/update/rendeles")
    public RendelesDto updateRendeles(@RequestBody RendelesDto rendeles, Authentication authentication) {
        if (rendeles.getId() > 0L) {
            String email = authentication.getName();
            FelhasznaloDto felhasznalo = felhasznaloService.findByEmail(email);
            RendelesDto dto = service.getRendelesById(rendeles.getId());
            if (!dto.getFelhasznalo().getId().equals(felhasznalo.getId())) {
                throw new RuntimeException("Felhasználó nem saját járműjét akarja módosítani.");
            }
            return service.save(rendeles, dto.getFelhasznalo());
        } else {
            return null;
        }
    }

    @GetMapping("/rendeles")
    public List<RendelesDto> findAllRendeles(){
        return service.getAllRendeles();
    }

    @GetMapping("/rendeles/id")
    public RendelesDto findById(@RequestBody Long id){
        return service.getRendelesById(id);
    }

    @GetMapping("/rendeles/jarmu")
    public List<JarmuDto> findAllJarmuById(@RequestBody Long id){
        return service.getAllJarmuByRendelesId(id);
    }

    @DeleteMapping("/rendeles/jarmu/delete")
    public void deleteJarmuToRendeles(@RequestParam Long rendelesId, @RequestParam Long jarmuId){
        service.deleteJarmuFromRendeles(rendelesId, jarmuId);
    }

    @PutMapping("/rendeles/jarmu/save")
    public RendelesDto saveJarmuToRendeles(@RequestParam Long rendelesId, @RequestParam Long jarmuId){
        return service.saveJarmuToRendeles(rendelesId, jarmuId);
    }
}
