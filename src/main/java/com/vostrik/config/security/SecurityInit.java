package com.vostrik.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;


/**
 * ниже приведенный код аналогичен следующему:
 * <filter>
 *  <filter-name>springSecurityFilterChain</filter-name>
 *  <filter-class>
 *  org.springframework.web.filter.DelegatingFilterProxy
 *  </filter-class>
 * </filter>
 *
 * <filter-mapping>
 *  <filter-name>springSecurityFilterChain</filter-name>
 *  <url-pattern>/*</url-pattern>
 *  <dispatcher>ERROR</dispatcher>
 *  <dispatcher>REQUEST</dispatcher>
 * </filter-mapping>
 */
//@Configuration
public class SecurityInit // extends AbstractSecurityWebApplicationInitializer
{
}
