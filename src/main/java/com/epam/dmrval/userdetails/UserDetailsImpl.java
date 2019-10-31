package com.epam.dmrval.userdetails;

import com.epam.dmrval.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/** Author - Damir_Valeev Created on 9/28/2019 */
@Component
public class UserDetailsImpl implements UserDetails {

  private User user;

  public UserDetailsImpl(User user) {
    this.user = user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    if (user != null) {
      Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
      grantedAuthorities.add(new SimpleGrantedAuthority(user.getUserRole().name()));
      return grantedAuthorities;
    } else return null;
  }

  @Override
  public String getPassword() {
    if (user != null) {
      return user.getPassword();
    } else return null;
  }

  @Override
  public String getUsername() {
    return user.getLogin();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
