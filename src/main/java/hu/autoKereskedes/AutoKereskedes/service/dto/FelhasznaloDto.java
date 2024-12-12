package hu.autoKereskedes.AutoKereskedes.service.dto;

import hu.autoKereskedes.AutoKereskedes.data.entitty.JarmuEntity;
import hu.autoKereskedes.AutoKereskedes.data.entitty.RendelesEntity;

import java.util.Objects;
import java.util.Set;

public class FelhasznaloDto {

    private Long id;
    private String nev;
    private String email;
    private Set<JarmuEntity> jarmu;
    private RendelesEntity rendeles;

    public FelhasznaloDto() {
    }

    public FelhasznaloDto(Long id, String nev, String email, Set<JarmuEntity> jarmu, RendelesEntity rendeles) {
        this.id = id;
        this.nev = nev;
        this.email = email;
        this.jarmu = jarmu;
        this.rendeles = rendeles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<JarmuEntity> getJarmu() {
        return jarmu;
    }

    public void setJarmu(Set<JarmuEntity> jarmu) {
        this.jarmu = jarmu;
    }

    public RendelesEntity getRendeles() {
        return rendeles;
    }

    public void setRendeles(RendelesEntity rendeles) {
        this.rendeles = rendeles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FelhasznaloDto that = (FelhasznaloDto) o;
        return Objects.equals(id, that.id) && Objects.equals(nev, that.nev) && Objects.equals(email, that.email) && Objects.equals(jarmu, that.jarmu) && Objects.equals(rendeles, that.rendeles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev, email, jarmu, rendeles);
    }
}
