package com.example.numberverify;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import okhttp3.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class NumberService {

        public ResponseEntity<NumberResponse> validate(String number) throws Exception {
            String regionCode="US";
            PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
            Phonenumber.PhoneNumber num = phoneNumberUtil.parse(number,regionCode);
            boolean valid= phoneNumberUtil.isValidNumber(num);
            if (valid==true){
                int country_code= num.getCountryCode();
                String region_code= phoneNumberUtil.getRegionCodeForNumber(num);
//                String carrier_name= phoneNumberUtil.formatNationalNumberWithCarrierCode(num,regionCode);
                //getting the country name from region code:
                Locale locale = new Locale("",region_code);
                String country_name= locale.getDisplayCountry();
                NumberResponse response= new NumberResponse(String.valueOf(country_code),country_name,carrier_name);
                return ResponseEntity.ok().body(response);
            }

           return ResponseEntity.ok().body(new NumberResponse("Not Valid","Not Valid","Not Valid"));


        }
    }

