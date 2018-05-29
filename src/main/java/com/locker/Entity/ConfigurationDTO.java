package com.locker.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Sejta on 2018/5/29.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CABINET_CONFIG")
public class ConfigurationDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int configId;

    @Column
    private String configType;

    @Column
    private String configValue;
}
