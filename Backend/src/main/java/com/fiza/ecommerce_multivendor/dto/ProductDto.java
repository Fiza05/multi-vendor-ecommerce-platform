package com.fiza.ecommerce_multivendor.dto;

import com.fiza.ecommerce_multivendor.model.Category;
import com.fiza.ecommerce_multivendor.model.Review;
import com.fiza.ecommerce_multivendor.model.Seller;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDto {

    private Long id;

    private String title;

    private String description;

    private int mrpPrice;

    private int sellingPrice;

    private int discountPercent;

    private int quantity;

    private String color;

    private List<String> images = new ArrayList<>();

    private int numRatings;

    private LocalDateTime createdAt;

    private String Sizes;

}
