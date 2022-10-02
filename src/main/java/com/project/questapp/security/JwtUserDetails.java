package com.project.questapp.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.questapp.entites.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtUserDetails  implements UserDetails{

	Long id;
	private String userName;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;

	 private JwtUserDetails(Long id, String username, String password,
			 Collection<? extends GrantedAuthority> authorities) {
	        this.id = id;
	        this.userName = username;
	        this.password = password;
	        this.authorities = authorities;
	    }
	 public static JwtUserDetails create(User user) {
	        List<GrantedAuthority> authoritiesList = new ArrayList<>();
	        authoritiesList.add(new SimpleGrantedAuthority("user"));
	        return new JwtUserDetails(user.getId(), user.getUserName(), 
	        		user.getPassword(), authoritiesList);
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
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

}
