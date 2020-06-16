package com.rewards.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @NonNull
    private String guid;

    @NonNull
    private List<OrderStatusEvent> orderStatusEvents;

    @NonNull
    private List<OrderItem> orderItems;

}
