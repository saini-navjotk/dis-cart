package com.tcs.eas.rest.apis.db;

import com.tcs.eas.rest.apis.model.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Integer> {
}
