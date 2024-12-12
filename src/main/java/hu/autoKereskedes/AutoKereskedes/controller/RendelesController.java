package hu.autoKereskedes.AutoKereskedes.controller;

import hu.autoKereskedes.AutoKereskedes.service.RendelesService;
import hu.autoKereskedes.AutoKereskedes.service.dto.JarmuDto;
import hu.autoKereskedes.AutoKereskedes.service.dto.RendelesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RendelesController {

    @Autowired
    RendelesService service;

    @PostMapping("/save/rendeles")
    public RendelesDto saveRendeles(@RequestBody RendelesDto rendeles) {
        return service.save(rendeles);
    }

    @DeleteMapping("/delete/rendeles")
    public void deleteRendeles(@RequestParam() Long id) {
        service.delete(id);
    }

    @PutMapping("/update/rendeles")
    public RendelesDto updateRendeles(@RequestBody RendelesDto rendeles) {
        if(rendeles.getId() > 0L){
            return service.save(rendeles);
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
    public void deleteJarmuToRendeles(@RequestBody Long rendelesId, @RequestBody Long jarmuId){
        service.deleteJarmuFromRendeles(rendelesId, jarmuId);
    }

    @PostMapping("/rendeles/jarmu/save")
    public RendelesDto saveJarmuToRendeles(@RequestBody Long rendelesId, @RequestBody Long jarmuId){
        return service.saveJarmuToRendeles(rendelesId, jarmuId);
    }
}
