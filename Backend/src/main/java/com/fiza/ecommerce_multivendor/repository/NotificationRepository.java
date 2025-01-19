package com.fiza.ecommerce_multivendor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiza.ecommerce_multivendor.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
