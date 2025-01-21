package com.fiza.ecommerce_multivendor.service;

import java.util.List;

import com.fiza.ecommerce_multivendor.model.Home;
import com.fiza.ecommerce_multivendor.model.HomeCategory;

public interface HomeService {

    Home creatHomePageData(List<HomeCategory> categories);

}
