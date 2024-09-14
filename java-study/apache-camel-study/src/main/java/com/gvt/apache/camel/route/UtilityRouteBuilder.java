package com.gvt.apache.camel.route;

import org.apache.camel.LoggingLevel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class UtilityRouteBuilder extends ExceptionRouteBuilder
{


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
                .bean("messageFormatService","formatTextMessage")
                .bean("fileManagementService","fileNamingService")
                .to("file:"+outputFileDirectory);
    }
}
