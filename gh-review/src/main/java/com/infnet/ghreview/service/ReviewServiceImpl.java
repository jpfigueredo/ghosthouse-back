package com.infnet.ghreview.service;

import com.infnet.ghreview.domain.Review;
import com.infnet.ghreview.dto.ReviewDTO;
import com.infnet.ghreview.repository.ReviewRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ReviewDTO createReview(ReviewDTO reviewDTO){
        Review review = modelMapper.map(reviewDTO, Review.class);
        Review savedReview = reviewRepository.save(review);
        return modelMapper.map(savedReview, ReviewDTO.class);
    }

    @Override
    public ReviewDTO getReviewById(Long reviewId) throws Exception {
        Review review = reviewExistsByID(reviewId);
        return modelMapper.map(review, ReviewDTO.class);
    }

    @Override
    public ReviewDTO updateReview(Long reviewId, ReviewDTO reviewDTO) throws Exception{
        reviewExistsByID(reviewDTO.getId());
        reviewDTO.setId(reviewId);
        Review updatedReview = reviewRepository.save(modelMapper.map(reviewDTO, Review.class));
        return modelMapper.map(updatedReview, ReviewDTO.class);
    }

    @Override
    public void deleteReview(Long reviewId) throws Exception{
        Review review = reviewExistsByID(reviewId);
        reviewRepository.delete(review);
    }

    @Override
    public List<ReviewDTO> getReviewList() throws Exception{
        List<Review> imovelList = reviewRepository.findAll();
        return imovelList.stream()
                .map(review -> modelMapper.map(review, ReviewDTO.class))
                .collect(Collectors.toList());
    }

    private Review reviewExistsByID(Long reviewId) throws Exception {
        if (!reviewRepository.existsById(reviewId)) {
            throw new Exception("Avaliação não encontrado com o ID: " + reviewId);
        }
        return reviewRepository.findById(reviewId).get();
    }
}
