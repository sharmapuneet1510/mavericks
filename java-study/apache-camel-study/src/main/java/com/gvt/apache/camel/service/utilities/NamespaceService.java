package com.gvt.apache.camel.service.utilities;

import com.gvt.apache.camel.route.constants.HeaderConstant;
import com.gvt.apache.camel.route.constants.NamespaceConstant;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Service;

@Service
public class NamespaceService
{
    public void sendInputReceivedNamespace(Exchange exchange)
    {
       exchange.getIn().setHeader(HeaderConstant.NAMESPACE, NamespaceConstant.INPUT_RECEIVER);
       exchange.getIn().setHeader(HeaderConstant.FILE_NAME, "incoming-trace-data.txt");
    }
}
