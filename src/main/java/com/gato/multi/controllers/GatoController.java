package com.gato.multi.controllers;

import com.gato.multi.dtos.Gato.GatoCreateDTO;
import com.gato.multi.dtos.Gato.GatoMultipartRequest;
import com.gato.multi.models.Gato;
import com.gato.multi.services.GatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io. swagger. v3.oas. annotations. StringToClassMapItem;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Tag(name = "Gatos")
@RequestMapping("/gato")
public class GatoController {
  
  @Autowired
  private GatoService gatoService;
  
  @Operation(summary = "Devuelve todos los gatos")
  @GetMapping
  public ResponseEntity<List<Gato>> getAll() {
    return ResponseEntity.ok(gatoService.getAll());
  }
  
  @Operation(summary = "Devuelve un gato por id")
  @GetMapping("/{id}")
  public ResponseEntity<Gato> getOne(@PathVariable("id") String id) {
    return ResponseEntity.ok(gatoService.getOne(id));
  }
  
  @Operation(summary = "Crea un gato con datos e imagen")
  @PostMapping(consumes = {"multipart/form-data"})
  public ResponseEntity<Gato> create(
    @RequestParam("file") MultipartFile file,
    @RequestParam("nombre") String nombre,
    @RequestParam("tamanio") String tamanio,
    @RequestParam("propietario_id") String propietarioId
  ) {
    GatoCreateDTO gatoDto = new GatoCreateDTO();
    gatoDto.setNombre(nombre);
    gatoDto.setTamanio(tamanio);
    gatoDto.setPropietario_id(propietarioId);
    
    return ResponseEntity.ok(gatoService.create(gatoDto, file));
  }
  
  @Operation(summary = "Actualiza un gato")
  @PutMapping("/{id}")
  public ResponseEntity<Gato> update(@PathVariable("id") String id, @RequestBody GatoCreateDTO dto) {
    return ResponseEntity.ok(gatoService.update(id, dto));
  }
  
  @Operation(summary = "Elimina un gato")
  @DeleteMapping("/{id}")
  public ResponseEntity<Gato> delete(@PathVariable("id") String id) {
    return ResponseEntity.ok(gatoService.delete(id));
  }
}
