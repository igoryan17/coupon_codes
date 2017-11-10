package com.podliva.web.services.coupons;

import com.podliva.web.models.CodeInformationDto;
import com.podliva.web.models.Provider;

import java.util.List;

@FunctionalInterface
public interface CouponLoaderService {
    List<CodeInformationDto> loadCodes(Provider provider);
}
