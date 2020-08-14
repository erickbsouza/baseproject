/*package br.com.mobit.gvm.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(passwordEncoder())
		.usersByUsernameQuery("SELECT login, password, active FROM users WHERE login=?")
		.authoritiesByUsernameQuery("SELECT u.login, a.description FROM users u" +
				" JOIN permission_user ausu ON (ausu.user_id = u.id)" +
				" JOIN permissions a ON (a.id = ausu.permission_id) WHERE u.login=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/javax.faces.resource/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login.xhtml")
		.usernameParameter("j_username").passwordParameter("j_password").permitAll()
		.defaultSuccessUrl("/index.xhtml", true)
		.failureUrl("/login.xhtml?error=true")
		.and()
		.logout().logoutSuccessUrl("/login.xhtml")
		.deleteCookies("JSESSIONID")
		.and()
		.rememberMe().key("_spring_security_remember_me")
		.and().csrf().disable();
		
		//.and().csrf().disable(); desabilita o csrf dentro dos formularios
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

}
*/