package com.ubivis.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Machine_halt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column (nullable = false, length = 24)
    private String machine_tag;

    @Column (nullable = false)
    private LocalTime start_time;

    @Column
    private LocalTime end_time;

    @Column (length = 128)
    private String reason ;



}
