package com.tekup.gld.project.elbetta.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
public class EBUserDetails implements UserDetails {


	private String username;
	private String password;
	// Comma separated list of roles
	private List<GrantedAuthority> authorities;
	private Boolean active;

	public EBUserDetails() {
	}

	public EBUserDetails(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this .active = user.getActive();
		this.authorities = Arrays.stream(user.getRoles().split(","))
				.map(role -> new SimpleGrantedAuthority("ROLE_" + role))
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return active;
	}

	@Override
	public boolean isAccountNonLocked() {
		return active;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return active;
	}

	@Override
	public boolean isEnabled() {
		return active;
	}
}
