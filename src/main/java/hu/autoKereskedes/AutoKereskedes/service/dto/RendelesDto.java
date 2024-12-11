package hu.autoKereskedes.AutoKereskedes.service.dto;

import hu.autoKereskedes.AutoKereskedes.data.entitty.FelhasznaloEntity;
import hu.autoKereskedes.AutoKereskedes.data.entitty.JarmuEntity;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

public class RendelesDto {
    private Long id;
    private List<JarmuDto> jarmu;

    public RendelesDto() {
    }

    public RendelesDto(Long id, List<JarmuDto> jarmu) {
        this.id = id;
        this.jarmu = jarmu;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RendelesDto that = (RendelesDto) o;
        return Objects.equals(id, that.id) && Objects.equals(jarmu, that.jarmu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jarmu);
    }
}
