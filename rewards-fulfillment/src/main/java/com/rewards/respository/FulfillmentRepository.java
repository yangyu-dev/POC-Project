package com.rewards.respository;

import com.rewards.model.Fulfillment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FulfillmentRepository extends MongoRepository<Fulfillment, String> {

}