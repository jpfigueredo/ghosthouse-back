package com.infnet.ghreview.service;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.infnet.ghreview.builder.ReviewBuilder;
import com.infnet.ghreview.domain.Review;
import com.infnet.ghreview.dto.ReviewDTO;
import com.infnet.ghreview.repository.ReviewRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewServiceImplTest {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewService reviewService;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private ReviewBuilder reviewBuilder;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Order(1)
    public void createReview() throws Exception {
        ReviewDTO reviewDTO = reviewBuilder.createReviewDTO();
        Review review = reviewBuilder.createReview();

        when(modelMapper.map(reviewDTO, Review.class)).thenReturn(review);
        when(reviewRepository.save(any(Review.class))).thenReturn(review);
        when(modelMapper.map(review, ReviewDTO.class)).thenReturn(reviewDTO);

        ReviewDTO savedReviewDTO = reviewService.createReview(reviewDTO);

        Assertions.assertEquals(reviewDTO, savedReviewDTO);
        verify(reviewRepository, times(1)).save(any(Review.class));
    }

    @Test
    @Order(2)
    public void getReviewById() throws Exception {
        Long reviewById = 1L;
        ReviewDTO reviewDTO = reviewBuilder.createReviewDTO();
        Review review = reviewBuilder.createReview();

        when(reviewRepository.findById(reviewById)).thenReturn(Optional.of(review));
        when(modelMapper.map(review, ReviewDTO.class)).thenReturn(reviewDTO);

        ReviewDTO foundReviewDTO = reviewService.getReviewById(reviewById);

        Assertions.assertEquals(reviewDTO, foundReviewDTO);
    }

    @Test
    @Order(3)
    public void getReviewByIdThrowsException() {
        Long reviewById = 1L;
        when(reviewRepository.findById(reviewById)).thenReturn(Optional.empty());
        assertThrows(Exception.class, () -> reviewService.getReviewById(reviewById));
    }

    @Test
    @Order(4)
    public void updateReview() throws Exception {
        Long reviewID = 1L;
        ReviewDTO reviewDTO = reviewBuilder.createReviewDTOWithId(reviewID);
        Review review = reviewBuilder.createReviewWithId(reviewID);

        when(reviewRepository.existsById(reviewID)).thenReturn(true);
        when(reviewRepository.save(any(Review.class))).thenReturn(review);
        when(modelMapper.map(reviewDTO, Review.class)).thenReturn(review);
        when(modelMapper.map(review, ReviewDTO.class)).thenReturn(reviewDTO);

        ReviewDTO updatedReviewDTO = reviewService.updateReview(reviewID, reviewDTO);

        Assertions.assertEquals(reviewDTO, updatedReviewDTO);
    }

    @Test
    @Order(5)
    public void updateReviewThrowsException() {
        Long reviewID = 1L;
        ReviewDTO reviewDTO = reviewBuilder.createReviewDTOWithId(reviewID);

        when(reviewRepository.existsById(reviewID)).thenReturn(false);

        assertThrows(Exception.class, () -> reviewService.updateReview(reviewID, reviewDTO));
    }

    @Test
    @Order(6)
    public void deleteReview() throws Exception {
        Long reviewID = 1L;
        when(reviewRepository.existsById(reviewID)).thenReturn(true);
        reviewService.deleteReview(reviewID);
        verify(reviewRepository, times(1)).deleteById(reviewID);
    }

    @Test
    @Order(7)
    public void deleteReviewThrowsException() {
        Long reviewID = 1L;
        when(reviewRepository.existsById(reviewID)).thenReturn(false);
        assertThrows(Exception.class, () -> reviewService.deleteReview(reviewID));
    }

    @Test
    @Order(8)
    public void getReviewList() throws Exception {
        List<Review> reviewList = reviewBuilder.createReviewList();
        List<ReviewDTO> reviewDTOList = reviewBuilder.createReviewDTOList();

        when(reviewRepository.findAll()).thenReturn(reviewList);

        List<ReviewDTO> foundReviewDTOList = reviewService.getReviewList();

        Assertions.assertEquals(reviewDTOList.size(), foundReviewDTOList.size());
        for (int i = 0; i < reviewList.size(); i++) {
            Assertions.assertEquals(reviewDTOList.get(i).getIdImovel(), reviewList.get(i).getImovel().getId());
            Assertions.assertEquals(reviewDTOList.get(i).getIdLocatario(), reviewList.get(i).getLocatario().getId());
        }
    }
}

