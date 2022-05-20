
package com.proyectoportfolio.primerportfolio.security.controller;

import com.proyectoportfolio.primerportfolio.security.dto.JwtDto;
import com.proyectoportfolio.primerportfolio.security.dto.LoginUsuario;
import com.proyectoportfolio.primerportfolio.security.dto.NuevoUsuario;
import com.proyectoportfolio.primerportfolio.security.entity.Rol;
import com.proyectoportfolio.primerportfolio.security.entity.Usuario;
import com.proyectoportfolio.primerportfolio.security.enums.RolNombre;
import com.proyectoportfolio.primerportfolio.security.jwt.JwtProvider;
import com.proyectoportfolio.primerportfolio.security.service.RolService;
import com.proyectoportfolio.primerportfolio.security.service.UsuarioService;
import jakarta.validation.Valid;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portafolio-web-70535.web.app/")
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    RolService rolService;
    
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
            Usuario usuario =
                    new Usuario(nuevoUsuario.getNombre(),nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
                    passwordEncoder.encode(nuevoUsuario.getPassword()));
            Set<Rol> roles = new HashSet<>();
            roles.add(rolService.getByRolNombre(RolNombre. ROLE_USER).get());
            if (nuevoUsuario.getRoles().contains("admin"))
                roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
            usuario.setRoles(roles);
            usuarioService.save(usuario);
       return new ResponseEntity(HttpStatus.OK);
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingresult){
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario()
                , loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(),userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    
    }
}
