package com.locker.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sejta on 2018/5/29.
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CabinetDetailIdentity implements Serializable {
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detailNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cabinetId",nullable = false,foreignKey = @ForeignKey(name="FOREIGN_LOCKER_DETAIL_LOCKER",value = ConstraintMode.CONSTRAINT))
    private CabinetInfoDTO cabinetInfoDTO;
}
