package com.gato.multi.controllers;

import com.gato.multi.dtos.Propietario.PropietarioCreateDTO;
import com.gato.multi.models.Propietario;
import com.gato.multi.services.PropietarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Propietarios")
@RequestMapping("/propietario")
public class PropietarioController {
  
  @Autowired
  PropietarioService propietarioService;
  
  @Operation(summary = "Devuelve todos los propietarios")
  @GetMapping
  public ResponseEntity<List<Propietario>> getAll() {
    return ResponseEntity.ok(propietarioService.getAll());
  }
  
  @Operation(summary = "Devuelve un propietario por id")
  @GetMapping("/{id}")
  public ResponseEntity<Propietario> getOne(@PathVariable("id") String id) {
    return ResponseEntity.ok(propietarioService.getOne(id));
  }
  
  @Operation(summary = "Crea un propietario")
  @PostMapping
  public ResponseEntity<Propietario> create(@RequestBody PropietarioCreateDTO dto) {
    return ResponseEntity.ok(propietarioService.create(dto));
  }
  
  @Operation(summary = "Actualiza un propietario")
  @PutMapping("/{id}")
  public ResponseEntity<Propietario> update(@PathVariable("id") String id, @RequestBody PropietarioCreateDTO dto) {
    return ResponseEntity.ok(propietarioService.update(id, dto));
  }
  
  @Operation(summary = "Elimina un propietario")
  @DeleteMapping("/{id}")
  public ResponseEntity<Propietario> delete(@PathVariable("id") String id) {
    return ResponseEntity.ok(propietarioService.delete(id));
  }
}