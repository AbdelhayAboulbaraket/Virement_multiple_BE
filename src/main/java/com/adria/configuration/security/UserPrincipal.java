package com.adria.configuration.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.adria.entities.Abonne;



public class UserPrincipal implements UserDetails {

	
	
	private static final long serialVersionUID = 1L;
	
	Abonne abonne;
	
	@Autowired
	public UserPrincipal(Abonne abonne) {
		super();
		this.abonne=abonne;

	}



	@Override
	public String getPassword() {
		
		return this.abonne.getPassword();
	}

	@Override
	public String getUsername() {
		
		return this.abonne.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

}
