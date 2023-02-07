package com.ubivis.service;

import com.ubivis.entity.Machine_halt;
import com.ubivis.repository.MachineHaltRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineHaltService {

    @Autowired
    private MachineHaltRepository machineHaltRepository;

    public Machine_halt salvar(Machine_halt machine_Halt){
        return machineHaltRepository.save(machine_Halt);
    }

    public List<Machine_halt> listaMachineHalt(){
        return machineHaltRepository.findAll();
    }

    public Optional<Machine_halt> buscarPorId(Long id){
        return machineHaltRepository.findById(id);
    }

    public void removerTodos(){
        machineHaltRepository.deleteAll();
    }
}
