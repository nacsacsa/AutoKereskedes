package hu.autoKereskedes.AutoKereskedes.data.entitty;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "jarmu")
public class JarmuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "felhasznalo_id", referencedColumnName = "id")
    private FelhasznaloEntity felhasznalo;
    @Column(name = "marka")
    private String marka;
    @Column(name = "tipus")
    private String tipus;
    @Column(name = "ar")
    private Long ar;
    @Column(name = "ev")
    private Long ev;

    public JarmuEntity() {
    }

    public JarmuEntity(Long id, FelhasznaloEntity felhasznalo, String marka, String tipus, Long ar, Long ev) {
        this.id = id;
        this.felhasznalo = felhasznalo;
        this.marka = marka;
        this.tipus = tipus;
        this.ar = ar;
        this.ev = ev;
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

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public Long getAr() {
        return ar;
    }

    public void setAr(Long ar) {
        this.ar = ar;
    }

    public Long getEv() {
        return ev;
    }

    public void setEv(Long ev) {
        this.ev = ev;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JarmuEntity that = (JarmuEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(felhasznalo, that.felhasznalo) && Objects.equals(marka, that.marka) && Objects.equals(tipus, that.tipus) && Objects.equals(ar, that.ar) && Objects.equals(ev, that.ev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, felhasznalo, marka, tipus, ar, ev);
    }
}
