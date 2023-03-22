package com.desarrollasoftware.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.desarrollasoftware.app.model.Cliente;
import com.desarrollasoftware.app.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<?> get() {
		List<Cliente> lista = (List<Cliente>) clienteService.findAll();
		if (lista.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontraron clientes registrados");
		}
		return ResponseEntity.ok(lista);
	}

	/*
	 * @GetMapping("/id/{id}") public Producto get(@PathVariable int id) { Producto
	 * bean = productoService.getById(id); if (bean == null) { throw new
	 * ProductoNotFoundException(id); } return bean;
	 * 
	 * }
	 * 
	 * @GetMapping("/leer") public Producto leer(@RequestParam(value = "id",
	 * defaultValue = "1") int id) { Producto bean = productoService.getById(id); if
	 * (bean == null) { throw new ProductoNotFoundException(id); } return bean; }
	 * 
	 * @GetMapping("/lista/{ids}") public List<Producto> get(@PathVariable int[]
	 * ids) { List<Producto> lista = productoService.getList(ids); if
	 * (lista.isEmpty()) { throw new ProductoNotFoundException(ids); } return lista;
	 * }
	 * 
	 * @PostMapping public ResponseEntity<Producto> crear(@RequestBody Producto
	 * bean) { bean = productoService.crear(bean); return
	 * ResponseEntity.status(HttpStatus.CREATED).body(bean); }
	 * 
	 * @PutMapping public Producto modificar(@RequestBody Producto bean) { Producto
	 * bean2 = productoService.getById(bean.getId()); if (bean2 == null) { throw new
	 * ProductoNotFoundException(bean.getId()); } return
	 * productoService.created(bean); }
	 * 
	 * @DeleteMapping("/id/{id}") public ResponseEntity<?> eliminar(@PathVariable
	 * int id) { Producto bean = productoService.getById(id); if (bean == null) {
	 * throw new ProductoNotFoundException(id); } productoService.deleteById(id);
	 * return ResponseEntity.noContent().build(); }
	 */

}
