package hu.autoKereskedes.AutoKereskedes.service;

import hu.autoKereskedes.AutoKereskedes.service.dto.BejelentkezesDto;
import hu.autoKereskedes.AutoKereskedes.service.dto.RegisztracioDto;

public interface AuthenticationService {
    String regisztracio(RegisztracioDto dto);

    String bejelentkezes(BejelentkezesDto dto);
}
