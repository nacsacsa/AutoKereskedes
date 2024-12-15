package hu.autoKereskedes.AutoKereskedes.service.dto;

import java.util.Objects;

public class JarmuFilterDto {

    private String marka;
    private String tipus;
    private Long kezdoAr;
    private Long vegAr;
    private Long kezdoEv;
    private Long vegEv;

    public JarmuFilterDto() {
    }

    public JarmuFilterDto(String marka, String tipus, Long kezdoAr, Long vegAr, Long kezdoEv, Long vegEv) {
        this.marka = marka;
        this.tipus = tipus;
        this.kezdoAr = kezdoAr;
        this.vegAr = vegAr;
        this.kezdoEv = kezdoEv;
        this.vegEv = vegEv;
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

    public Long getKezdoAr() {
        return kezdoAr;
    }

    public void setKezdoAr(Long kezdoAr) {
        this.kezdoAr = kezdoAr;
    }

    public Long getVegAr() {
        return vegAr;
    }

    public void setVegAr(Long vegAr) {
        this.vegAr = vegAr;
    }

    public Long getKezdoEv() {
        return kezdoEv;
    }

    public void setKezdoEv(Long kezdoEv) {
        this.kezdoEv = kezdoEv;
    }

    public Long getVegEv() {
        return vegEv;
    }

    public void setVegEv(Long vegEv) {
        this.vegEv = vegEv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JarmuFilterDto that = (JarmuFilterDto) o;
        return Objects.equals(marka, that.marka) && Objects.equals(tipus, that.tipus) && Objects.equals(kezdoAr, that.kezdoAr) && Objects.equals(vegAr, that.vegAr) && Objects.equals(kezdoEv, that.kezdoEv) && Objects.equals(vegEv, that.vegEv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marka, tipus, kezdoAr, vegAr, kezdoEv, vegEv);
    }
}
