package com.example.service;

import com.example.entity.Rating;
import com.example.jpa.ProductRepository;
import com.example.jpa.RatingRepository;
import com.example.jpa.UserRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RatingService implements GenericService<Rating, Long> {
	private final RatingRepository ratingRepository;
	private final ProductRepository productRepository;
	private final UserRepository userRepository;

	public RatingService(final RatingRepository ratingRepository, final ProductRepository productRepository,
			final UserRepository userRepository) {
		this.ratingRepository = ratingRepository;
		this.productRepository = productRepository;
		this.userRepository = userRepository;
	}

	@Override
	public Long getId(Rating entity) {
		return entity.getRatingId();
	}

	@Override
	public CrudRepository<Rating, Long> getRepository() {
		return this.ratingRepository;
	}

	public Iterable<Rating> getRatingsByProductId(final String productId) {
		return this.ratingRepository.getRatingsByProductId(productId);
	}

//	@Override
//	public Rating save(Rating entity) {
//		if (!productRepository.existsById(entity.getProductId()) || !userRepository.existsById(entity.getUserId())) {
//			throw new GenericServiceException("Either product_id or user_id doesn't exists: " + entity);
//		}
//		return GenericService.super.save(entity);
//	}
}
