package com.gvt.apache.camel.service.utilities;

import com.gvt.apache.camel.route.constants.HeaderConstant;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.format.DateTimeFormatter;

@Service
public class FileManagementService
{
    @Autowired public DateTimeService dateTimeService;

    public void fileNamingService(Exchange exchange)
    {
        String directory=exchange.getIn().getHeader(HeaderConstant.NAMESPACE, HeaderConstant.NAMESPACE_DEFAULT,String.class);
        String fileName=exchange.getIn().getHeader(HeaderConstant.FILE_NAME, HeaderConstant.FILE_NAME_DEFAULT,String.class);
        String today=dateTimeService.getCurrentDateTime(DateTimeFormatter.ISO_DATE);
        String outputFileName=directory+ File.separator+today+File.separator+fileName;
        exchange.getIn().setHeader(Exchange.FILE_NAME,outputFileName);
        //exchange.getIn().setHeader(HeaderConstant.OUTPUT_FILE_NAME,outputFileName);
    }
}
