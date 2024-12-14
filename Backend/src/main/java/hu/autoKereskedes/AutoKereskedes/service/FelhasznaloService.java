package hu.autoKereskedes.AutoKereskedes.service;

import hu.autoKereskedes.AutoKereskedes.data.entitty.FelhasznaloEntity;
import hu.autoKereskedes.AutoKereskedes.service.dto.FelhasznaloDto;

public interface FelhasznaloService {
    FelhasznaloDto findByEmail(String email);
}
