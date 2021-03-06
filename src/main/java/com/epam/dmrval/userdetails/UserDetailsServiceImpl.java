package com.epam.dmrval.userdetails;

import com.epam.dmrval.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/** Author - Damir_Valeev Created on 9/28/2019 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired private UserService userService;

  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    return new UserDetailsImpl(userService.findByLogin(login));
  }
}
