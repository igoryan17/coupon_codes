package com.podliva;

import com.podliva.db.models.CodeInformation;
import com.podliva.db.repositories.CodeRepository;
import com.podliva.web.converrters.CodeInformationDtoToEntityConverter;
import com.podliva.web.models.CodeInformationDto;
import com.podliva.web.models.Provider;
import com.podliva.web.services.coupons.CouponLoaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CouponSaver implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(CouponSaver.class);
    private final CouponLoaderService couponLoaderService;
    private final CodeInformationDtoToEntityConverter codeInformationDtoToEntityConverter;
    private final CodeRepository codeRepository;

    @Autowired
    public CouponSaver(CouponLoaderService couponLoaderService,
                       CodeInformationDtoToEntityConverter codeInformationDtoToEntityConverter,
                       CodeRepository codeRepository) {
        this.couponLoaderService = couponLoaderService;
        this.codeInformationDtoToEntityConverter = codeInformationDtoToEntityConverter;
        this.codeRepository = codeRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<CodeInformationDto> codeInformationDtos = couponLoaderService.loadCodes(Provider.PAPA_JONS);
        List<CodeInformation> codeInformations = codeInformationDtoToEntityConverter.convert(codeInformationDtos);
        codeRepository.save(codeInformations);
    }
}
