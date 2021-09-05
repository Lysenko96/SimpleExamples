package net.gweep.security.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import net.gweep.security.model.Role;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated().and()
				.formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/success").and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST")).invalidateHttpSession(true)
				.clearAuthentication(true).deleteCookies("JSESSIONID").logoutSuccessUrl("/login");
	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {

		return new InMemoryUserDetailsManager(
				User.builder().username("admin")
						.password("{bcrypt}$2a$12$zRMp1.Mrx1.SObK9utIAvOW.4a5X8cGAIZCehTLbv.cJhBv27lcjG")
						.authorities(Role.ADMIN.getAuthorities()).build(),
				User.builder().username("user")
						.password("{bcrypt}$2a$12$R3ZgcukoBRzrH61LkI7ODOFYoLIrpww/pouMADcfxGPKE2RNXnWW6")
						.authorities(Role.USER.getAuthorities()).build());

	}

	@Bean
	protected DelegatingPasswordEncoder passwordEncoder() {
		String idForEncode = "bcrypt";
		Map<String, PasswordEncoder> encoders = new HashMap<>();
		encoders.put(idForEncode, new BCryptPasswordEncoder());
		return new DelegatingPasswordEncoder(idForEncode, encoders);
	}

}
