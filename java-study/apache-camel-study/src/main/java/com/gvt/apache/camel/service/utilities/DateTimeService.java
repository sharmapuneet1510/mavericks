package com.gvt.apache.camel.service.utilities;


import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DateTimeService
{

    public String getCurrentDateTime(DateTimeFormatter dateTimeFormatter)
    {
        return (LocalDateTime.now().format(dateTimeFormatter));
    }

}
