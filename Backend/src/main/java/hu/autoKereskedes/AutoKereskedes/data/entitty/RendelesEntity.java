package hu.autoKereskedes.AutoKereskedes.data.entitty;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "rendeles")
public class RendelesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "felhasznalo_id", referencedColumnName = "id")
    private FelhasznaloEntity felhasznalo;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "rendeles_jarmu",
            joinColumns = { @JoinColumn(name = "rendeles_id")},
            inverseJoinColumns = { @JoinColumn(name = "jarmu_id")}
    )
    private List<JarmuEntity> jarmuvek;

    public RendelesEntity() {
    }

    public RendelesEntity(Long id, FelhasznaloEntity felhasznalo, List<JarmuEntity> jarmuvek) {
        this.id = id;
        this.felhasznalo = felhasznalo;
        this.jarmuvek = jarmuvek;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FelhasznaloEntity getFelhasznalo() {
        return felhasznalo;
    }

    public void setFelhasznalo(FelhasznaloEntity felhasznalo) {
        this.felhasznalo = felhasznalo;
    }

    public List<JarmuEntity> getJarmuvek() {
        return jarmuvek;
    }

    public void setJarmuvek(List<JarmuEntity> jarmuvek) {
        this.jarmuvek = jarmuvek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RendelesEntity that = (RendelesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(felhasznalo, that.felhasznalo) && Objects.equals(jarmuvek, that.jarmuvek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, felhasznalo, jarmuvek);
    }
}
