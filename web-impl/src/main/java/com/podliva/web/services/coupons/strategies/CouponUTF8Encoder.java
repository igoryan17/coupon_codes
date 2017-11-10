package com.podliva.web.services.coupons.strategies;

import com.podliva.web.services.coupons.CouponFieldsEncoderService;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.stereotype.Component;

@Component
public class CouponUTF8Encoder extends CouponFieldsEncoderService {

    @Override
    protected String encode(String field) {
        return StringEscapeUtils.unescapeJava(field);
    }
}
