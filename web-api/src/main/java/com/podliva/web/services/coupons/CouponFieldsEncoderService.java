package com.podliva.web.services.coupons;

import com.podliva.web.models.CodeInformationDto;

public abstract class CouponFieldsEncoderService {
    public void encode(CodeInformationDto codeInformationDto) {
        codeInformationDto.setName(encode(codeInformationDto.getName()));
        codeInformationDto.setCode(encode(codeInformationDto.getCode()));
    }

    protected abstract String encode(String field);
}
