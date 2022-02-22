package com.tcs.eas.rest.apis.db;

import com.tcs.eas.rest.apis.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	
    Cart findCartsByUserIdAndStatus(int userId, String status);
    
    Cart findCartsByUserId(int userId);
}
