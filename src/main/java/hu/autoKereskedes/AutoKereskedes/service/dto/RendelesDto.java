package hu.autoKereskedes.AutoKereskedes.service.dto;

import java.util.List;
import java.util.Objects;

public class RendelesDto {
    private Long id;
    private List<JarmuDto> jarmu;
    private FelhasznaloDto felhasznalo;

    public RendelesDto() {
    }

    public RendelesDto(Long id, List<JarmuDto> jarmu, FelhasznaloDto felhasznalo) {
        this.id = id;
        this.jarmu = jarmu;
        this.felhasznalo = felhasznalo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<JarmuDto> getJarmu() {
        return jarmu;
    }

    public void setJarmu(List<JarmuDto> jarmu) {
        this.jarmu = jarmu;
    }

    public FelhasznaloDto getFelhasznalo() {
        return felhasznalo;
    }

    public void setFelhasznalo(FelhasznaloDto felhasznalo) {
        this.felhasznalo = felhasznalo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RendelesDto that = (RendelesDto) o;
        return Objects.equals(id, that.id) && Objects.equals(jarmu, that.jarmu) && Objects.equals(felhasznalo, that.felhasznalo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jarmu, felhasznalo);
    }
}
