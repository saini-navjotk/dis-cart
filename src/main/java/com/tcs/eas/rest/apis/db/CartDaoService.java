package com.tcs.eas.rest.apis.db;

import com.tcs.eas.rest.apis.exception.CartExistsException;
import com.tcs.eas.rest.apis.exception.CartNotFoundException;
import com.tcs.eas.rest.apis.log.LoggingService;
import com.tcs.eas.rest.apis.model.AddressType;
import com.tcs.eas.rest.apis.model.Cart;
import com.tcs.eas.rest.apis.model.CartCheckoutResponse;
import com.tcs.eas.rest.apis.model.CartProduct;
import com.tcs.eas.rest.apis.model.CartProductRequest;
import com.tcs.eas.rest.apis.model.CartProductResponse;
import com.tcs.eas.rest.apis.model.CartProductUpdateResponse;
import com.tcs.eas.rest.apis.model.CartRequest;
import com.tcs.eas.rest.apis.model.CartResponse;
import com.tcs.eas.rest.apis.model.CartUpdateRequest;
import com.tcs.eas.rest.apis.model.CartUpdateResponse;
import com.tcs.eas.rest.apis.model.DeliveryInfo;
import com.tcs.eas.rest.apis.model.DeliveryType;
import com.tcs.eas.rest.apis.model.PaymentInfo;
import com.tcs.eas.rest.apis.model.PaymentType;
import com.tcs.eas.rest.apis.model.Product;
import com.tcs.eas.rest.apis.model.ProductResponse;
import com.tcs.eas.rest.apis.model.ShipmentProduct;
import com.tcs.eas.rest.apis.model.User;
import com.tcs.eas.rest.apis.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CartDaoService {

    @Value("${API_USER}")
    private String API_USER;

    @Value("${ADMIN_USER}")
    private String ADMIN_USER;

    @Value("${PRODUCT_API_BASE_URL}")
    private String PRODUCT_API_BASE_URL;

    @Value("${USER_API_BASE_URL}")
    private String USER_API_BASE_URL;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    LoggingService loggingService;

    @Autowired
    private CartProductRepository cartProductRepository;

    @Value("${PRODUCT_API_BASE_URL}")
    private String productApiBaseUrl;


    /**
     * Create Cart with Products
     *
     * @param cartRequest request with products to add in cart
     * @return cartResponse Cart Response for UI
     */
    public CartResponse createCart(CartRequest cartRequest) {

        Cart cartForUser = cartRepository.findCartsByUserId(cartRequest.getUserId());

        if (cartForUser != null) {
            throw new CartExistsException("Cart ID " + cartForUser.getCartId() + " already exists for the User !");
        }

        List<CartProductRequest> cartProducts = cartRequest.getCartProducts();
        Cart cart = new Cart();
        cart.setUserId(cartRequest.getUserId());
        cart.setStatus("A");
        cart.setCreatedTimestamp(new Date());
        cart.setCreatedBy(ADMIN_USER);
        cart.setUpdatedBy(API_USER);
        cart.setCartDate(cartRequest.getDate());
        List<CartProduct> cartProductList = new ArrayList<>();

        for (CartProductRequest productRequest : cartProducts) {
            CartProduct cartProduct = new CartProduct();
            cartProduct.setProductId(productRequest.getProductId());
            cartProduct.setCartQuantity(productRequest.getCartQuantity());
            cartProduct.setOfferId(productRequest.getOfferId());
            cartProduct.setCreatedBy(ADMIN_USER);
            cartProduct.setUpdatedBy(API_USER);
            cartProduct.setCreateTimestamp(new Date());
            cartProduct.setCart(cart);

            cartProductList.add(cartProduct);
        }

        cart.setCartProducts(cartProductList);
        Cart cartSaved = cartRepository.save(cart);

        CartResponse cartResponse = new CartResponse();
        if (!ObjectUtils.isEmpty(cartSaved.getCartId())) {
            Stream.of(cartSaved).map(cartTemp -> {
                cartResponse.setCartId(cartTemp.getCartId());
                cartResponse.setUserId(cartTemp.getUserId());
                cartResponse.setDate(cartTemp.getCartDate());
                cartResponse.setCartQuantity(cart.getCartProducts().size());

                List<CartProductResponse> cartProductResponses = new ArrayList<>();
                for (CartProduct cp : cart.getCartProducts()) {
                    ProductResponse productResponse = getProductInfoById(cp.getProductId());

                    cartProductResponses.add(
                            new CartProductResponse(
                                    productResponse.getProductId(),
                                    productResponse.getProductName(),
                                    cp.getCartQuantity(),
                                    productResponse.getAvailableQuantity(),
                                    productResponse.getPrice(),
                                    cp.getOfferId()
                            ));
                }
                cartResponse.setCartProductResponses(cartProductResponses);

                return cartResponse;
            }).collect(Collectors.toList()).get(0);
        }

        return cartResponse;
    }

    /**
     * Get Cart By ID
     *
     * @param id unique ID of Cart
     * @return cartResponse Cart Response for UI
     */
    public CartResponse getCartById(int id) {
        Optional<Cart> cartFetched = cartRepository.findById(id);
        CartResponse cartResponse = new CartResponse();
        if (cartFetched.isPresent()) {

            if (!ObjectUtils.isEmpty(cartFetched.get())) {
                Stream.of(cartFetched.get()).map(cartTemp -> {
                    cartResponse.setCartId(cartTemp.getCartId());
                    cartResponse.setUserId(cartTemp.getUserId());
                    cartResponse.setDate(cartTemp.getCartDate());
                    cartResponse.setCartQuantity(cartTemp.getCartProducts().size());

                    List<CartProductResponse> cartProductResponses = new ArrayList<>();
                    for (CartProduct cp : cartTemp.getCartProducts()) {
                        ProductResponse productResponse = getProductInfoById(cp.getProductId());
                        cartProductResponses.add(
                                new CartProductResponse(
                                        productResponse.getProductId(),
                                        productResponse.getProductName(),
                                        cp.getCartQuantity(),
                                        productResponse.getAvailableQuantity(),
                                        productResponse.getPrice()
                                ));
                    }
                    cartResponse.setCartProductResponses(cartProductResponses);

                    return cartResponse;
                }).collect(Collectors.toList()).get(0);
            }
        } else {
            throw new CartNotFoundException("Cart for ID " + id + " not found !");
        }
        return cartResponse;
    }


    /**
     * Get cart by user ID
     *
     * @param userId unique ID of user
     * @return cart reponse
     */
    public CartResponse getCartByUserID(int userId) {

        Cart userCart = cartRepository.findCartsByUserId(userId);

        CartResponse cartResponse = new CartResponse();
        if (userCart != null) {
            if (!ObjectUtils.isEmpty(userCart)) {
                Stream.of(userCart).map(cartTemp -> {
                    cartResponse.setCartId(cartTemp.getCartId());
                    cartResponse.setUserId(cartTemp.getUserId());
                    cartResponse.setDate(cartTemp.getCartDate());
                    cartResponse.setCartQuantity(cartTemp.getCartProducts().size());

                    List<CartProductResponse> cartProductResponses = new ArrayList<>();
                    for (CartProduct cp : cartTemp.getCartProducts()) {
                        ProductResponse productResponse = getProductInfoById(cp.getProductId());
                        cartProductResponses.add(
                                new CartProductResponse(
                                        productResponse.getProductId(),
                                        productResponse.getProductName(),
                                        cp.getCartQuantity(),
                                        productResponse.getAvailableQuantity(),
                                        productResponse.getPrice(),
                                        cp.getOfferId()
                                ));
                    }
                    cartResponse.setCartProductResponses(cartProductResponses);

                    return cartResponse;
                }).collect(Collectors.toList()).get(0);
            }
        } else {
            throw new CartNotFoundException("No Cart found for User " + userId + " !");
        }
        return cartResponse;

    }

    /**
     * Update Cart by ID
     *
     * @param cartUpdateRequest request body for update
     */
    public CartUpdateResponse updateCartById(CartUpdateRequest cartUpdateRequest) {
        if (cartUpdateRequest.getCartProducts().size() == 0) {
            cartRepository.deleteById(cartUpdateRequest.getCartId());
        } else {

            Optional<Cart> cartInfoFromDB = cartRepository.findById(cartUpdateRequest.getCartId());
            if (cartInfoFromDB.isPresent()) {
                List<CartProductRequest> cartProductsListFromRequest = cartUpdateRequest.getCartProducts();
                List<CartProduct> cartProductsListFromDB = cartInfoFromDB.get().getCartProducts();

                List<CartProduct> cartProductsToUpdateList = new ArrayList<>();

                for (CartProductRequest cartProductRequest : cartProductsListFromRequest) {
                    boolean isFoundInDB = false;
                    for (CartProduct cartProductDB : cartProductsListFromDB) {
                        if (cartProductRequest.getProductId() == cartProductDB.getProductId()) {
                            isFoundInDB = true;
                            if (cartProductRequest.getCartQuantity() > 0) {

                                cartProductDB.setCartQuantity(cartProductRequest.getCartQuantity());
                                cartProductDB.setOfferId(cartProductRequest.getOfferId());
                                cartProductsToUpdateList.add(cartProductDB);

                            } else {
                                cartProductRepository.deleteById(cartProductDB.getCartProductId());
                                cartProductDB.setCartQuantity(cartProductRequest.getCartQuantity());
                                cartProductDB.setOfferId(cartProductRequest.getOfferId());
                                cartProductsToUpdateList.add(cartProductDB);
                            }

                            break;
                        }
                    }
                    if (!isFoundInDB && cartProductRequest.getCartQuantity() > 0) {
                        CartProduct cartProduct = new CartProduct();
                        cartProduct.setCartQuantity(cartProductRequest.getCartQuantity());
                        cartProduct.setProductId(cartProductRequest.getProductId());
                        cartProduct.setOfferId(cartProductRequest.getOfferId());
                        cartProduct.setUpdatedBy(API_USER);
                        cartProduct.setCreatedBy(ADMIN_USER);
                        cartProduct.setCreateTimestamp(new Date());
                        cartProduct.setCart(cartInfoFromDB.get());

                        cartProductsToUpdateList.add(cartProduct);
                    }

                    cartInfoFromDB.get().setCartDate(cartUpdateRequest.getDate());
                    cartInfoFromDB.get().setCartProducts(cartProductsToUpdateList);
                    Cart cartResult = cartRepository.save(cartInfoFromDB.get());

                    CartUpdateResponse cartUpdateResponse = new CartUpdateResponse();
                    cartUpdateResponse.setCartId(cartResult.getCartId());
                    cartUpdateResponse.setUserId(cartResult.getUserId());
                    cartUpdateResponse.setDate(cartResult.getCartDate());
                    cartUpdateResponse.setCartQuantity(cartProductsListFromDB.size());

                    List<CartProductUpdateResponse> cartProductUpdateResponseList = new ArrayList<>();

                    for (CartProduct cartProduct : cartProductsToUpdateList) {
                        CartProductUpdateResponse cartProductUpdateResponse = new CartProductUpdateResponse();
                        cartProductUpdateResponse.setProductId(cartProduct.getProductId());
                        cartProductUpdateResponse.setOfferId(cartProduct.getOfferId());
                        cartProductUpdateResponse.setProductQuantity(cartProduct.getCartQuantity());

                        ProductResponse productResponse = getProductInfoById(cartProduct.getProductId());
                        if (!ObjectUtils.isEmpty(productResponse)) {
                            cartProductUpdateResponse.setProductPrice(productResponse.getPrice());
                            cartProductUpdateResponse.setProductName(productResponse.getProductName());
                            cartProductUpdateResponse.setAvailableQuantity(productResponse.getAvailableQuantity());
                        }

                        cartProductUpdateResponseList.add(cartProductUpdateResponse);
                    }
                    cartUpdateResponse.setCartProductUpdateResponseList(cartProductUpdateResponseList);

                    return cartUpdateResponse;
                }

               /* List<CartProduct> cartProductsToDeleteList = cartInfoFromDB.get().getCartProducts().stream().filter(n -> n.getCartQuantity() == 0).collect(Collectors.toList());
                if (cartProductsToDeleteList.size() != 0) {

                    for (CartProduct product : cartProductsToDeleteList) {
                        cartProductsToUpdateList.remove(product);
                    }
                    cartInfoFromDB.get().setCartProducts(cartProductsToUpdateList);
                    cartRepository.save(cartInfoFromDB.get());
                    *//**//*cartProductRepository.deleteAll(cartProductsToDeleteList);*//**//*
                }*/

            } else {
                throw new CartNotFoundException("Cart Not Found !");
            }
        }
        return null;
    }

    /**
     * Get Product Info by product ID
     *
     * @param productId unique ID of product
     * @return cartProductResponse cart product response for UI
     */
    private ProductResponse getProductInfoById(int productId) {

        RestTemplate restTemplate = new RestTemplate();

        try {
            ProductResponse response
                    = restTemplate.getForObject(productApiBaseUrl + "/" + productId, ProductResponse.class);
            return response != null ? response : new ProductResponse();
        } catch (Exception e) {
            loggingService.logError(e.getMessage());
            return new ProductResponse();
        }
    }

    /**
     * checkout cart with added products
     *
     * @param cartId    unique ID of cart
     * @param addressId unique ID of address
     * @return cartCheckoutResponse Cart response for UI
     */
    public CartCheckoutResponse checkoutCart(int cartId, int addressId) {

        //Check for Cart existence in DB
        Optional<Cart> cartFetchDB = cartRepository.findById(cartId);
        if (!cartFetchDB.isPresent()) {
            throw new CartNotFoundException("Cart with ID " + cartId + " Not Found !");
        }

        CartCheckoutResponse cartCheckoutResponse = new CartCheckoutResponse();
        cartCheckoutResponse.setCartId(cartId);
        cartCheckoutResponse.setUserId(2);

        //Payment Info
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setPaymentType(PaymentType.GPAY);
        paymentInfo.setTransactionAmount(23499.76);
        cartCheckoutResponse.setPaymentInfo(paymentInfo);

        //User Info
        int userId = cartFetchDB.get().getUserId();
        RestTemplate restTemplate = new RestTemplate();
        UserInfo userInfo = new UserInfo();
        DeliveryInfo deliveryInfo = new DeliveryInfo();
        try {

            String url = USER_API_BASE_URL + userId;
            User userResponse = restTemplate.getForEntity(url, User.class).getBody();

            if (userResponse != null) {

                //Map User Info from external service response
                userInfo.setUserName(userResponse.getFirstName() + " " + userResponse.getLastName());
                userInfo.setContactNumber(userInfo.getContactNumber());

                //Map Address Info from external service response
                deliveryInfo.setAddressLine1(userResponse.getAddress().getAddressline1());
                deliveryInfo.setAddressLine2(userResponse.getAddress().getAddressline2());
                deliveryInfo.setCity(userResponse.getAddress().getCity());
                deliveryInfo.setState(userResponse.getAddress().getState());
                deliveryInfo.setZipCode(userResponse.getAddress().getZipCode());
                deliveryInfo.setAddressType(AddressType.OFFICE);
                deliveryInfo.setCountry(userResponse.getAddress().getCountry());

            } else {

                //User Info
                userInfo.setUserName("NameNull");
                userInfo.setContactNumber("+91-999777788");

                //Address Info
                deliveryInfo.setAddressLine1("ADDRESSNULL LINE 1");
                deliveryInfo.setAddressLine2("ADDRESSNULL LINE 2");
                deliveryInfo.setCity("Kolkata");
                deliveryInfo.setState("WB");
                deliveryInfo.setZipCode("736557");
                deliveryInfo.setAddressType(AddressType.OFFICE);
                deliveryInfo.setCountry("India");
            }
        } catch (Exception e) {
            loggingService.logError(e.getMessage());

            //User Info
            userInfo.setUserName("NameX");
            userInfo.setContactNumber("+91-999777788");

            //Address Info
            deliveryInfo.setAddressLine1("ADDRESSX LINE 1");
            deliveryInfo.setAddressLine2("ADDRESSX LINE 2");
            deliveryInfo.setCity("KolkataX");
            deliveryInfo.setState("WBX");
            deliveryInfo.setZipCode("736557X");
            deliveryInfo.setAddressType(AddressType.OFFICE);
            deliveryInfo.setCountry("India");
        }

        cartCheckoutResponse.setUserInfo(userInfo);
        cartCheckoutResponse.setDeliveryInfo(deliveryInfo);

        //Shipment Products Info
        Optional<Cart> cartFromDB = cartRepository.findById(cartId);
        List<CartProduct> cartProductList = cartFromDB.get().getCartProducts();
        List<ShipmentProduct> shipmentProductsList = new ArrayList<>();
        for (CartProduct cartProduct : cartProductList) {
            try {
                String url = "http://localhost:8087/api/v1/dis/products/" + cartProduct.getProductId();
                Product productResponse = restTemplate.getForEntity(url, Product.class).getBody();

                ShipmentProduct shipmentProduct = new ShipmentProduct();
                shipmentProduct.setProductId(productResponse.getProductId());
                shipmentProduct.setProductPrice(productResponse.getProductPrice());
                shipmentProduct.setProductName(productResponse.getProductName());
                shipmentProduct.setProductQuantity(productResponse.getProductQuantity());
                shipmentProduct.setAvailableQuantity(productResponse.getAvailableQuantity());
                shipmentProduct.setDeliveryAvailable(productResponse.isDeliveryAvailable());
                shipmentProduct.setDeliveryType(productResponse.getDeliveryType());
                shipmentProduct.setDeliveryCharge(productResponse.getDeliveryCharge());
                shipmentProduct.setExpectedDeliveryDate(productResponse.getExpectedDeliveryDate());
                shipmentProduct.setTotalShipmentCharge(productResponse.getTotalShipmentCharge());
                shipmentProductsList.add(shipmentProduct);
                cartCheckoutResponse.setShipmentProducts(shipmentProductsList);

            } catch (Exception e) {

                ShipmentProduct shipmentProduct = new ShipmentProduct();
                shipmentProduct.setProductId(2);
                shipmentProduct.setProductPrice(24555.55);
                shipmentProduct.setProductName("VivoX V21");
                shipmentProduct.setProductQuantity(1);
                shipmentProduct.setAvailableQuantity(30);
                shipmentProduct.setDeliveryAvailable(true);
                shipmentProduct.setDeliveryType(DeliveryType.FREE);
                shipmentProduct.setDeliveryCharge(0.00);
                shipmentProduct.setExpectedDeliveryDate("2022-01-23");
                shipmentProduct.setTotalShipmentCharge(24555.55);
                shipmentProductsList.add(shipmentProduct);
                cartCheckoutResponse.setShipmentProducts(shipmentProductsList);

            }

        }

        return cartCheckoutResponse;
    }

    /**
     * Delete cart by ID
     *
     * @param cartId unique ID of Cart
     */
    public void deleteCartById(int cartId) {
        Optional<Cart> cartToDeleteDB = cartRepository.findById(cartId);

        if (!cartToDeleteDB.isPresent()) {
            throw new CartNotFoundException("Cart with ID " + cartId + " Not Found !");
        }
        cartRepository.deleteById(cartId);
    }

    public void deleteCartProductById(int cartProductId) {
        cartProductRepository.deleteById(cartProductId);
    }

}

