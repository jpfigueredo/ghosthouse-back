package com.infnet.ghreview.service;

import com.infnet.ghreview.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {
    ReviewDTO createReview(ReviewDTO reviewDTO) throws Exception;
    ReviewDTO getReviewById(Long reviewId) throws Exception;
    ReviewDTO updateReview(Long reviewId, ReviewDTO reviewDTO) throws Exception;
    void deleteReview(Long reviewId) throws Exception;
    List<ReviewDTO> getReviewList() throws Exception;
}
