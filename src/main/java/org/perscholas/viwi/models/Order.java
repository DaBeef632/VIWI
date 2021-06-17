package org.perscholas.viwi.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Customer_Order")
@Table(name = "customer_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;

    @Column(name = "order_placed_at",
    columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    //@NonNull
    private LocalDateTime orderPlacedAt;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "userId",
            foreignKey = @ForeignKey(
                    name = "user_order_fk"
            )
    )
    private User user;



}
