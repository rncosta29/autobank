package br.com.rcosta.autobank.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.rcosta.autobank.controller.UserController;
import br.com.rcosta.autobank.exceptions.ResourceNotFoundException;
import br.com.rcosta.autobank.mapper.DozzerMapper;
import br.com.rcosta.autobank.model.vo.UserVO;
import br.com.rcosta.autobank.repositories.PermissionRepository;
import br.com.rcosta.autobank.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	private Logger logger = Logger.getLogger(UserService.class.getName());
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PermissionRepository permissionRepository;
	
	//@Autowired
	//private DelegatingPasswordEncoder passwordEncode;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("Finding one user by name " + username + "!");
		var user = userRepository.findByUsername(username);
		//logger.info("Finding one user by name " + user.getAuthorities() + "!");
		
		if (user != null) {
			return user;
		} else {
			throw new UsernameNotFoundException("Username " + username + " not found!");
		}
	}
	
	public List<UserVO> findAll() {
		logger.info("Listar todos os usuários");
		
		var usuarios = DozzerMapper.parseListObjects(userRepository.findAll(), UserVO.class);
		usuarios
			.stream()
			.forEach(u -> {
				try {
					u.add(linkTo(methodOn(UserController.class).findById(u.getKey())).withSelfRel());
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		return usuarios;
	}
	
	public UserVO findById(Long id) throws Exception {
		logger.info("Encontrar um usuário por id");
		
		var usuario = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para esse id!!!"));
		
		var vo = DozzerMapper.parseObject(userRepository.save(usuario), UserVO.class);
		vo.add(linkTo(methodOn(UserController.class).findById(vo.getKey())).withSelfRel());
		
		return vo;
	}
	
//	public UserVO save(UserVO model) throws Exception {
//		logger.info("Criando um novo usuário");
//		
//		Permission permission = permissionRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para esse id!!!"));
//		var entity = DozzerMapper.parseObject(model, User.class);
//		
//		PasswordEncoder passwordEncode = new BCryptPasswordEncoder();
//		
//		String pass = passwordEncode.encode(model.getPassword());
//		
//		entity.setAccountNonExpired(true);
//		entity.setAccountNonLocked(true);
//		entity.setCredentialsNonExpired(true);
//		entity.setDataCriacao(new Date());
//		entity.setEnabled(true);
//		entity.setPassword(pass);
//		entity.setPermissions(Arrays.asList(permission));
//		var vo = DozzerMapper.parseObject(userRepository.save(entity), UserVO.class);
//		vo.add(linkTo(methodOn(UserController.class).findById(vo.getKey())).withSelfRel());
//		
//		return vo;
//	}
	
	public UserVO update(UserVO userVO) throws Exception {
		logger.info("Updating one person!");
		
		var entity = userRepository.findById(userVO.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found this ID!!!"));
		
		entity.setUserName(userVO.getUserName());
		entity.setNomeCompleto(userVO.getNomeCompleto());
		
		var vo = DozzerMapper.parseObject(userRepository.save(entity), UserVO.class);
		vo.add(linkTo(methodOn(UserController.class).findById(vo.getKey())).withSelfRel());
		
		return vo;
	}
}