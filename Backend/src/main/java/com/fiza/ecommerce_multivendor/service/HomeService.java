package com.fiza.ecommerce_multivendor.service;

import com.fiza.ecommerce_multivendor.model.Home;
import com.fiza.ecommerce_multivendor.model.HomeCategory;

import java.util.List;

public interface HomeService {

    Home creatHomePageData(List<HomeCategory> categories);

}
