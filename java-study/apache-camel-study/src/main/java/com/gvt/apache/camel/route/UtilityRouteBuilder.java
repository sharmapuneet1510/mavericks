package com.gvt.apache.camel.route;

import com.gvt.apache.camel.service.utilities.FileManagementService;
import com.gvt.apache.camel.service.utilities.MessageFormatService;
import org.apache.camel.LoggingLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class UtilityRouteBuilder extends ExceptionRouteBuilder
{

    @Autowired
    private FileManagementService fileManagementService;

    @Autowired private MessageFormatService messageFormatService;

    @Value("${output.file.directory}") private String outputFileDirectory;

    @Override
    public void configure() throws Exception
    {
        super.configure();
        writeToFile();
    }

    public void writeToFile()
    {
        from(WRITE_TO_FILE_ROUTE)
                .routeId("utilityRouteBuilder.writeToFile")
                .log(LoggingLevel.INFO,"Message Received : "+WRITE_TO_FILE_ROUTE)
                .bean(messageFormatService,"formatTextMessage")
                .bean(fileManagementService,"fileNamingService")
                .to("file:"+outputFileDirectory);
    }
}
