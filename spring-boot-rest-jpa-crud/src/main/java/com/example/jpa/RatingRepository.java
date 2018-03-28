package com.example.jpa;

import javax.transaction.Transactional;

import com.example.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;


@Transactional
public interface RatingRepository extends JpaRepository<Rating, Long> {
	public Iterable<Rating> getRatingsByProductId(final String productId);
}
