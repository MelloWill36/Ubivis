package com.ubivis.repository;

import com.ubivis.entity.Machine_halt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;
import java.util.List;

public interface MachineHaltRepository extends JpaRepository <Machine_halt, Long> {

    List<Machine_halt> findByMachineOrStartOrPause(String machine, LocalTime start, LocalTime pause);


}
