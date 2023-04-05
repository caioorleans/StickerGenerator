package com.github.caioorleans.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.github.caioorleans.model.ImageInfo;

public interface ImageRepository extends MongoRepository<ImageInfo, String>{

}
