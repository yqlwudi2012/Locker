package com.locker.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Sejta on 2018/5/28.
 */
@Entity
@Table(name="USER_INFO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserInfoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int userId;

    @Column(length = 16)
    private String userName;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="orderUserId")
    private List<OrderInfoDTO> userOrders;
}
