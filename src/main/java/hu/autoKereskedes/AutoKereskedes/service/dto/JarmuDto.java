package hu.autoKereskedes.AutoKereskedes.service.dto;


import java.util.Objects;

public class JarmuDto {
    private Long id;
    private String marka;
    private String tipus;
    private Long ar;
    private Long ev;
    private FelhasznaloDto felhasznalo;
    public JarmuDto() {
    }

    public JarmuDto(Long id, String marka, String tipus, Long ar, Long ev, FelhasznaloDto felhasznalo) {
        this.id = id;
        this.marka = marka;
        this.tipus = tipus;
        this.ar = ar;
        this.ev = ev;
        this.felhasznalo = felhasznalo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        JarmuDto jarmuDto = (JarmuDto) o;
        return Objects.equals(id, jarmuDto.id) && Objects.equals(felhasznalo, jarmuDto.felhasznalo) && Objects.equals(marka, jarmuDto.marka) && Objects.equals(tipus, jarmuDto.tipus) && Objects.equals(ar, jarmuDto.ar) && Objects.equals(ev, jarmuDto.ev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,felhasznalo, marka, tipus, ar, ev);
    }
}
