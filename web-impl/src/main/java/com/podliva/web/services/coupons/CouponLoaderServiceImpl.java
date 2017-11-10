package com.podliva.web.services.coupons;

import com.podliva.web.models.CodeInformationDto;
import com.podliva.web.models.CodesContainerDto;
import com.podliva.web.models.Provider;
import com.podliva.web.url.UrlComposer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class CouponLoaderServiceImpl implements CouponLoaderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CouponLoaderServiceImpl.class);
    private final Map<Provider, UrlComposer> codeUrlComposerMap;

    private final CouponFieldsEncoderService couponFieldsEncoderService;

    @Autowired
    public CouponLoaderServiceImpl(Map<Provider, UrlComposer> codeUrlComposersMap, CouponFieldsEncoderService couponFieldsEncoderService) {
        this.codeUrlComposerMap = codeUrlComposersMap;
        this.couponFieldsEncoderService = couponFieldsEncoderService;
    }

    @Override
    public List<CodeInformationDto> loadCodes(Provider provider) {
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        restTemplate.getMessageConverters().add(converter);
        UrlComposer urlComposer = codeUrlComposerMap.get(provider);
        CodesContainerDto codesContainerDto = restTemplate.getForObject(urlComposer.getUrl(), CodesContainerDto.class);
        return codesContainerDto.getCodes();
    }
}
