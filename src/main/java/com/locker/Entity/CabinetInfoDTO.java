package com.locker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sejta on 2018/5/29.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CABINET_INFO")
public class CabinetInfoDTO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cabinetId;

    @Column(length=256)
    private String address;

    @Column
    private double longitude;

    @Column
    private double latitude;

    @Column
    private int cabinetState;

    @Column(length = 3)
    private int largeTotal;
    @Column(length = 3)
    private int largeSurplus;
    @Column(length = 3)
    private int midTotal;
    @Column(length = 3)
    private int midSurplus;
    @Column(length = 3)
    private int smallTotal;
    @Column(length = 3)
    private int smallSurplus;

    @Column
    private String model;

    @Column
    private String stipulations;

    @Column
    private String cabinetImage;


}
