package com.erbalkan.rentAcar.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandRequest {
    private String name;
    // Id otomatik arttığı için kullanıcıdan sadece name bilgisi alınır.
}
