package com.fiza.ecommerce_multivendor.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiza.ecommerce_multivendor.exception.CategoryNotFoundException;
import com.fiza.ecommerce_multivendor.exception.ProductException;
import com.fiza.ecommerce_multivendor.exception.SellerException;
import com.fiza.ecommerce_multivendor.exception.UserException;
import com.fiza.ecommerce_multivendor.model.Product;
import com.fiza.ecommerce_multivendor.model.Seller;
import com.fiza.ecommerce_multivendor.request.CreateProductRequest;
import com.fiza.ecommerce_multivendor.service.ProductService;
import com.fiza.ecommerce_multivendor.service.SellerService;
import com.fiza.ecommerce_multivendor.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sellers/product")
@RequiredArgsConstructor
public class SellerProductController {

	private final ProductService productService;
	private final SellerService sellerService;
	private final UserService userService;

	@GetMapping()
	public ResponseEntity<List<Product>> getProductBySellerId(
			@RequestHeader("Authorization") String jwt) throws ProductException, SellerException {

		Seller seller = sellerService.getSellerProfile(jwt);

		List<Product> products = productService.getProductBySellerId(seller.getId());
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequest request,

			@RequestHeader("Authorization") String jwt)
			throws UserException, ProductException, CategoryNotFoundException, SellerException {

		Seller seller = sellerService.getSellerProfile(jwt);

		Product product = productService.createProduct(request, seller);
		return new ResponseEntity<>(product, HttpStatus.CREATED);

	}

	@DeleteMapping("/{productId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
		try {
			productService.deleteProduct(productId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (ProductException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PatchMapping("/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long productId,
			@RequestBody Product product) {
		try {
			Product updatedProduct = productService.updateProduct(productId, product);
			return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
		} catch (ProductException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PatchMapping("/{productId}/stock")
	public ResponseEntity<Product> updateProductStock(@PathVariable Long productId) {
		try {
			Product updatedProduct = productService.updateProductStock(productId);
			return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
		} catch (ProductException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
