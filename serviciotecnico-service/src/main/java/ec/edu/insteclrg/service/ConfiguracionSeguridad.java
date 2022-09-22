package ec.edu.insteclrg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ec.edu.insteclrg.service.crud.ImplemetarServicioSeguridad;
import ec.edu.insteclrg.service.jwt.JwtAuthenticationEntryPoint;
import ec.edu.insteclrg.service.jwt.JwtAuthtenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

  @Autowired
  private ImplemetarServicioSeguridad servicioSeguridad;

  @Autowired
  private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

  @Bean
  public JwtAuthtenticationFilter jwtAuthtenticationFilter() {
    return new JwtAuthtenticationFilter();
  }

  String[] resources = new String[] {
      "/include/**", "/css/**", "/icons/**", "/imagenes/**", "/js/**", "/layer/**"
  };

  BCryptPasswordEncoder bCryptPasswordEncoder;

  // Crea el encriptador de contraseñas
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
    return bCryptPasswordEncoder;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(servicioSeguridad).passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .exceptionHandling()
        .authenticationEntryPoint(jwtAuthenticationEntryPoint)
        .and()
        .sessionManagement()
        // .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests()
        .antMatchers(resources).permitAll()
        .antMatchers(HttpMethod.OPTIONS).permitAll()
        // .antMatchers(HttpMethod.GET, "/api/v1.0/informacionadicional").permitAll()
        .antMatchers(HttpMethod.GET, "/articulos/listar_limitada").permitAll()
        .antMatchers(HttpMethod.GET, "/categoria/ver").permitAll()
        .antMatchers(HttpMethod.GET, "/buscar_categoria/**").permitAll()
        .antMatchers("/api/v1.0/autorizacion/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .logout()
        .permitAll()
        .invalidateHttpSession(true);
    http.addFilterBefore(jwtAuthtenticationFilter(), UsernamePasswordAuthenticationFilter.class);
  }

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
}
