package com.epam.dmrval.configuration.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/** Author - Damir_Valeev Created on 9/28/2019 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

  public SecurityWebApplicationInitializer() {
    super(WebSecurityConfig.class);
  }
}
