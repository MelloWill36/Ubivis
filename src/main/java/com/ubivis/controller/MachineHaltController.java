package com.ubivis.controller;

import com.ubivis.entity.Machine_halt;
import com.ubivis.service.MachineHaltService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/machineHalt")
public class MachineHaltController {

    @Autowired
    private MachineHaltService machineHaltService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Machine_halt salvar(@RequestBody Machine_halt machine_halt){
        return machineHaltService.salvar(machine_halt);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Machine_halt> listaMachine_halt(){
        return machineHaltService.listaMachineHalt();
    }

    @GetMapping(value = "/filtro")
    public ResponseEntity<List<Machine_halt>> findByMachine(String machine_Tag,LocalTime inicio,LocalTime fim) {
        List<Machine_halt> collection = machineHaltService.filtro(machine_Tag,inicio,fim);
        return ResponseEntity.ok().body(collection);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Machine_halt buscarPorId(@PathVariable("id") Long id){
        return machineHaltService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Log nao encontrado."));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerMachine_halt() {
        machineHaltService.removerTodos();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarMachine_halt(@PathVariable("id") Long id, @RequestBody Machine_halt machine_halt){
        machineHaltService.buscarPorId(id)
                .map(machine_haltBase -> {
                    modelMapper.map (machine_halt, machine_haltBase);
                    machineHaltService.salvar(machine_haltBase);
                    return Void.TYPE;
                }).orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND,"Log nao encontrado."));

    }
}