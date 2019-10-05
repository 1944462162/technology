package com.imustacm.domain.base;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class BaseDomain extends BaseQuery {

    public String dateToString(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}
