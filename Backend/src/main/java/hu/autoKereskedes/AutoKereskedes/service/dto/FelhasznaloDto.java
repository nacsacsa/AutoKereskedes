package hu.autoKereskedes.AutoKereskedes.service.dto;

import java.util.Objects;

public class FelhasznaloDto {

    private Long id;
    private String nev;
    private String email;

    public FelhasznaloDto() {
    }

    public FelhasznaloDto(Long id, String nev, String email) {
        this.id = id;
        this.nev = nev;
        this.email = email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FelhasznaloDto that = (FelhasznaloDto) o;
        return Objects.equals(id, that.id) && Objects.equals(nev, that.nev) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev, email);
    }
}
