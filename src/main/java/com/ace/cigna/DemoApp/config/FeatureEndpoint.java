package com.ace.cigna.DemoApp.config;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.stereotype.Component;



@Component
@Endpoint(id = "features")
public class FeatureEndpoint {

    //private  final Map<String, Feature> featureMap = new ConcurentHashMap<>();
}
