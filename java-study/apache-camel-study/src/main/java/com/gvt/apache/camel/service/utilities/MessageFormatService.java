package com.gvt.apache.camel.service.utilities;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class MessageFormatService
{
    @Autowired DateTimeService dateTimeService;

    public void formatTextMessage(Exchange exchange)
    {
       String currentDateTime=dateTimeService.getCurrentDateTime(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
       String body= exchange.getIn().getBody(String.class);
       String formattedBody=currentDateTime+" - "+body+"\n";
       exchange.getIn().setBody(formattedBody);
    }
}
