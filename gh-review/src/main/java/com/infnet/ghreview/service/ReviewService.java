package com.infnet.ghreview.service;

import com.infnet.ghreview.dto.ReviewDTO;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    public ReviewDTO createReview(ReviewDTO reviewDto) {
        // Implementar lógica para criar uma nova avaliação
        // Converter ReviewDto para entidade de domínio, salvar no banco de dados e retornar o ReviewDto resultante
        return null;
    }

    public ReviewDTO getReviewById(Long reviewId) {
        // Implementar lógica para buscar uma avaliação pelo ID e retornar o ReviewDto correspondente
        return null;
    }

    public ReviewDTO updateReview(Long reviewId, ReviewDTO reviewDto) {
        // Implementar lógica para atualizar uma avaliação existente com os dados fornecidos em reviewDto
        // Retornar o ReviewDto atualizado
        return null;
    }

    public void deleteReview(Long reviewId) {
        // Implementar lógica para excluir uma avaliação pelo ID
    }
}
