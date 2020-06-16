package com.rewards.respository;

import com.rewards.model.CustomerOrders;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerOrdersRepository extends MongoRepository<CustomerOrders, String> {

}