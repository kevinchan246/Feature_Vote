package com.featurevote.service;

import com.featurevote.domain.Feature;
import com.featurevote.domain.Product;
import com.featurevote.domain.User;
import com.featurevote.repositories.FeatureRepository;
import com.featurevote.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeatureService {
    @Autowired //load from database
    private ProductRepository productRepo;

    @Autowired
    private FeatureRepository featureRepo;

    public Feature createFeature(Long productId, User user){
        Feature feature = new Feature();

        Optional<Product> productOpt = productRepo.findById(productId);

        if (productOpt.isPresent()){
            Product product = productOpt.get();

            feature.setProduct(product);
            product.getFeatures().add(feature);

            feature.setUser(user);
            user.getFeatures().add(feature);

            feature.setStatus("Pending review");

            return featureRepo.save(feature);
        }

        return feature;

    }

    public Feature save(Feature feature){
        return featureRepo.save(feature);
    }

    public Optional<Feature> findById(Long featureId) {
        return featureRepo.findById(featureId);
    }
}
