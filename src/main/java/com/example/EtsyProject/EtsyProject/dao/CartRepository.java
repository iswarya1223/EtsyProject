package com.example.EtsyProject.EtsyProject.dao;

import com.example.EtsyProject.EtsyProject.entity.Cart;
import com.example.EtsyProject.EtsyProject.service.Response.CartResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer>{

    @Query(value = "SELECT * FROM Cart WHERE email =:email AND productId =:productid", nativeQuery = true)
    Cart findCartDetails(@Param("email") String email,
                         @Param("productid") int productid);

    @Transactional
    @Query(value = "UPDATE Cart SET quantity =:quantity WHERE email =:email AND productId =:productid", nativeQuery = true)
    Integer updateQuantity(@Param("email") String email,
                        @Param("quantity") int quantity,
                        @Param("productid") int productid);

    @Query("SELECT new com.example.EtsyProject.EtsyProject.service.Response.CartResponse(" +
            "P.productId, P.productName, P.shopName, P.imageUrl, C.quantity, P.price, P.currency, C.cartId, P.stock) " +
            "FROM Products P INNER JOIN Cart C ON P.productId = C.productId " +
            "WHERE C.email = :email AND P.productId IN (SELECT C.productId FROM Cart C)")
    List<CartResponse> findCartByEmail(@Param("email") String email);

    @Transactional
    @Modifying
    @Query("DELETE FROM Cart C where C.email =:email")
    Integer deleteByEmailId(@Param("email") String email);
}