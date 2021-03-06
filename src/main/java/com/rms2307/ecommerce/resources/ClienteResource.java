package com.rms2307.ecommerce.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rms2307.ecommerce.domain.Cliente;
import com.rms2307.ecommerce.domain.Endereco;
import com.rms2307.ecommerce.dto.ClienteDTO;
import com.rms2307.ecommerce.dto.ClienteNewDTO;
import com.rms2307.ecommerce.dto.EnderecoNewDTO;
import com.rms2307.ecommerce.services.ClienteService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@ApiOperation(value = "Retorna um cliente pelo Id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
		Cliente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Retorna todos os clientes")
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {
		List<Cliente> list = service.findAll();
		List<ClienteDTO> listDTO = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@ApiOperation(value = "Retorna um cliente pelo email")
	@GetMapping(value = "/email")
	public ResponseEntity<Cliente> findByEmail(@RequestParam(value = "value") String email) {
		Cliente obj = service.findByEmail(email);
		return ResponseEntity.ok().body(obj);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping(value = "/page")
	public ResponseEntity<Page<ClienteDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Cliente> pages = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ClienteDTO> pagesDTO = pages.map(obj -> new ClienteDTO(obj));
		return ResponseEntity.ok().body(pagesDTO);
	}

	@ApiOperation(value = "Insere um cliente")
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDTO objDTO) {
		Cliente obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualiza um cliente")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDTO, @PathVariable Integer id) {
		Cliente obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Remove um cliente")
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
//	IMAGENS
	
	@ApiOperation(value = "Salva de profile")
	@PostMapping(value = "/picture")
	public ResponseEntity<Void> uploadProfilePicture(@RequestParam(name = "file") MultipartFile file) {
		URI uri = service.uploadProfilePicture(file);
		return ResponseEntity.created(uri).build();
	}
	
// ENDEREÇOS
	
	@ApiOperation(value = "Insere o endereço")
	@PostMapping(value = "/enderecos")
	public ResponseEntity<Void> addEndereco(@Valid @RequestBody EnderecoNewDTO objDTO) {
		Endereco obj = service.enderecoFromDTO(objDTO);
		obj = service.addEndereco(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualiza o endereço")
	@PutMapping(value = "/enderecos/{id}")
	public ResponseEntity<Void> updateEndereco(@Valid @RequestBody EnderecoNewDTO objDTO, @PathVariable Integer id) {
		Endereco obj = service.enderecoFromDTO(objDTO);
		obj.setId(id);
		obj = service.updateEnd(obj);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Deleta o endereço")
	@DeleteMapping(value = "/enderecos/{id}")
	public ResponseEntity<Void> deleteEndereco(@PathVariable Integer id) {
		service.deleteEndereco(id);
		return ResponseEntity.noContent().build();
	}
}
