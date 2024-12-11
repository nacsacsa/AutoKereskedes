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
    private FelhasznaloEntity felhasznalo_id;
    @Column(name = "marka")
    private String marka;
    @Column(name = "tipus")
    private String tipus;
    @Column(name = "ar")
    private Long ar;
    @Column(name = "ev_jarat")
    private String evJarat;

    public JarmuEntity() {
    }

    public JarmuEntity(Long id, FelhasznaloEntity felhasznalo_id, String marka, String tipus, Long ar, String evJarat) {
        this.id = id;
        this.felhasznalo_id = felhasznalo_id;
        this.marka = marka;
        this.tipus = tipus;
        this.ar = ar;
        this.evJarat = evJarat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FelhasznaloEntity getFelhasznalo_id() {
        return felhasznalo_id;
    }

    public void setFelhasznalo_id(FelhasznaloEntity felhasznalo_id) {
        this.felhasznalo_id = felhasznalo_id;
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

    public String getEv_jarat() {
        return evJarat;
    }

    public void setEv_jarat(String ev_jarat) {
        this.evJarat = ev_jarat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JarmuEntity that = (JarmuEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(felhasznalo_id, that.felhasznalo_id) && Objects.equals(marka, that.marka) && Objects.equals(tipus, that.tipus) && Objects.equals(ar, that.ar) && Objects.equals(evJarat, that.evJarat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, felhasznalo_id, marka, tipus, ar, evJarat);
    }
}
