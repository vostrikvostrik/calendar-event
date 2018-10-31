package com.vostrik.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

   public static LocalDate getDatePart(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}

