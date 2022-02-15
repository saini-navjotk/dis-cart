package com.tcs.eas.rest.apis.controller;

import java.util.Map;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import com.tcs.eas.rest.apis.db.CartDaoService;
import com.tcs.eas.rest.apis.model.Cart;
import com.tcs.eas.rest.apis.model.CartCheckoutResponse;
import com.tcs.eas.rest.apis.model.CartRequest;
import com.tcs.eas.rest.apis.model.CartResponse;
import com.tcs.eas.rest.apis.model.CartUpdateRequest;
import com.tcs.eas.rest.apis.model.CartUpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.eas.rest.apis.log.LoggingService;
import com.tcs.eas.rest.apis.utility.Utility;

@RestController
@RequestMapping(value = "api/v1/dis/carts")
public class CartController {

    @Autowired
    private CartDaoService cartDaoService;

    @Autowired
    LoggingService loggingService;

    @PostMapping
    public ResponseEntity<CartResponse> createCart(@Valid @RequestBody CartRequest cartRequest, @RequestHeader Map<String, String> headers) {

        loggingService.writeProcessLog("POST", "cart", "createCart", cartRequest);
        CartResponse cartResponse = cartDaoService.createCart(cartRequest);
        Utility.sendToKafka(cartResponse);

        return ResponseEntity.status(HttpStatus.CREATED).headers(Utility.getCustomResponseHeaders(headers)).body(cartResponse);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<CartResponse> getCartByUserId(@PathVariable int userId, @RequestHeader Map<String, String> headers) {

        CartResponse cartResponse = cartDaoService.getCartByUserID(userId);

        loggingService.writeProcessLog("GET", "cart", "getCart", cartResponse);
       // Utility.sendToKafka(cartResponse);
        return ResponseEntity.status(HttpStatus.OK).headers(Utility.getCustomResponseHeaders(headers)).body(cartResponse);
    }

    @PutMapping
    public ResponseEntity<CartUpdateResponse> updateCartById(@Valid @RequestBody CartUpdateRequest cartUpdateRequest, @RequestHeader Map<String, String> headers) {

        loggingService.writeProcessLog("PUT", "cart", "updateCartById", cartUpdateRequest);
        CartUpdateResponse cartResponse = cartDaoService.updateCartById(cartUpdateRequest);
        Utility.sendToKafka(cartResponse);
        return ResponseEntity.status(HttpStatus.OK).headers(Utility.getCustomResponseHeaders(headers)).body(cartResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCartById(@PathVariable int id, @RequestHeader Map<String, String> headers) {

        Cart cart = new Cart();
        cart.setCartId(id);
        loggingService.writeProcessLog("DELETE", "cart", "deleteCartById", cart);
        cartDaoService.deleteCartById(id);
        return ResponseEntity.status(HttpStatus.OK).headers(Utility.getCustomResponseHeaders(headers)).body("Cart with ID " + id + " Deleted Successfully !");
    }

    @GetMapping(value = "{id}/checkout")
    public ResponseEntity<CartCheckoutResponse> checkoutCart(@PathVariable int id, @PathParam("addressId") int addressId, @RequestHeader Map<String, String> headers) {

        CartCheckoutResponse cartCheckoutResponse = cartDaoService.checkoutCart(id, addressId);
        return ResponseEntity.ok().headers(Utility.getCustomResponseHeaders(headers)).body(cartCheckoutResponse);
    }
}
