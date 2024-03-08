package com.infnet.ghreview.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.infnet.ghreview.domain.Review;
import com.infnet.ghreview.dto.ReviewDTO;
import com.infnet.ghreview.repository.ReviewRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewService reviewService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddReview() {
        // Simular uma nova avaliação
        Review review = new Review();
        review.setPropertyId(1L);
        review.setRating(4);
        review.setComment("Great experience!");

        ReviewDTO review = new ReviewDTO();
        review.setPropertyId(1L);
        review.setRating(4);
        review.setComment("Great experience!");

        // Simular a adição da avaliação no repositório
        when(reviewRepository.save(review)).thenReturn(reviewDTO);

        // Chamar o método para adicionar a avaliação
        ReviewDTO result = reviewService.createReview(review);

        // Verificar se a avaliação foi adicionada corretamente
        assertEquals(review, result);
    }

    // Outros testes para os métodos do ReviewService...
}
