package com.gvt.apache.camel.route;

import com.gvt.apache.camel.route.constants.RouteConstant;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ExceptionRouteBuilder extends RouteBuilder implements RouteConstant
{
    @Override
    public void configure() throws Exception
    {
        handleException();
    }

    public void handleException()
    {
        onException(Exception.class)
                .routeId("exceptionRouteBuilder.handleException")
                .routeDescription("Handle Exception generated for Exception.class")
                .log("${body}")
                .end();
    }
}
