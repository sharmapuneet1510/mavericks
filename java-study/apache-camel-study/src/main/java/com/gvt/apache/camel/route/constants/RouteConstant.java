package com.gvt.apache.camel.route.constants;

public interface RouteConstant
{
    String INPUT_RECEIVED_ROUTE="activemq:queue:producer.dev";
    String WRITE_TO_FILE_ROUTE="direct:writeToFile";
}
