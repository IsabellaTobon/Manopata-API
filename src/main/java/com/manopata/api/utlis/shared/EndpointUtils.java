package com.manopata.api.utlis.shared;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class EndpointUtils
{
    public static String getEndpointUrl()
    {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getServletPath();
    }
}
