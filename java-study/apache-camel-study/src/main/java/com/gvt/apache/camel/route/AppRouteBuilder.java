package com.gvt.apache.camel.route;

import com.gvt.apache.camel.route.constants.HeaderConstant;
import com.gvt.apache.camel.route.constants.NamespaceConstant;
import com.gvt.apache.camel.route.constants.RouteConstant;
import org.apache.camel.LoggingLevel;
import org.springframework.stereotype.Component;

@Component
public class AppRouteBuilder extends UtilityRouteBuilder
{

    @Override
    public void configure() throws Exception
    {
        super.configure();
        readInput();
    }

    public void readInput()
    {
        from(INPUT_RECEIVED_ROUTE)
                .routeId("appRouteBuilder.readInput")
                .log(LoggingLevel.INFO,"Message Received : "+INPUT_RECEIVED_ROUTE)
                .bean("namespaceService","sendInputReceivedNamespace")
                .setHeader(HeaderConstant.NAMESPACE,constant(NamespaceConstant.INPUT_RECEIVER))
                .to(RouteConstant.WRITE_TO_FILE_ROUTE).end()
        ;
    }
}
