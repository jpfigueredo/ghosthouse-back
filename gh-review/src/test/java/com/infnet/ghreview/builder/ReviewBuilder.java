package com.infnet.ghreview.builder;

import com.infnet.ghreview.domain.Review;
import com.infnet.ghreview.dto.PropertyDTO;
import com.infnet.ghreview.dto.LocatarioDTO;
import com.infnet.ghreview.dto.ReviewDTO;
import com.infnet.ghreview.enums.TipoCategoria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReviewBuilder {

    public ReviewDTO createReviewDTO(){
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(1L);
        reviewDTO.setDescricao("testestestestestestestesteste");
        reviewDTO.setIdImovel(1L);
        reviewDTO.setIdLocatario(1L);
        return reviewDTO;
    }

    public ReviewDTO createReviewDTOWithId(Long id) {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(id);
        reviewDTO.setDescricao("testestestestestestestesteste");
        reviewDTO.setIdImovel(1L);
        reviewDTO.setIdLocatario(1L);
        return reviewDTO;
    }

    public List<ReviewDTO> createReviewDTOList(){
        List<ReviewDTO> listImovelDTO = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ReviewDTO reviewDTO = new ReviewDTO();
            reviewDTO.setId((long) i);
            reviewDTO.setDescricao("testestestestestestestesteste");
            reviewDTO.setIdImovel(1L);
            reviewDTO.setIdLocatario(1L);
            listImovelDTO.add(reviewDTO);
        }
        return listImovelDTO;
    }

    public Review createReview(){
        PropertyDTO propertyDTO = createImovelDTO();
        LocatarioDTO locatarioDTO = createLocatarioDTO();

        Review review = new Review();
        review.setId(1L);
        review.setDescricao("testestestestestestestesteste");
        review.setImovel(propertyDTO);
        review.setLocatario(locatarioDTO);
        return review;
    }

    public Review createReviewWithId(Long id){
        PropertyDTO propertyDTO = createImovelDTO();

        Review review = new Review();
        review.setId(id);
        review.setDescricao("testestestestestestestesteste");
        review.setImovel(propertyDTO);
        review.setLocatario(createLocatarioDTO());
        return review;
    }

    public List<Review> createReviewList(){
        PropertyDTO propertyDTO = createImovelDTO();
        LocatarioDTO locatarioDTO = createLocatarioDTO();

        List<Review> listImovel = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Review review = new Review();
            review.setId((long) i);
            review.setDescricao("testestestestestestestesteste");
            review.setImovel(propertyDTO);
            review.setLocatario(locatarioDTO);
            listImovel.add(review);
        }
        return listImovel;
    }

    private PropertyDTO createImovelDTO(){
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(1L);
        propertyDTO.setNome("teste");
        propertyDTO.setDescricao("testestestestestestestesteste");
        propertyDTO.setCategoria(TipoCategoria.CASA);
        propertyDTO.setIdProprietario(1L);
        propertyDTO.setDatasReservadas(createDateList());
        propertyDTO.setQuantidadeQuartos(1);
        propertyDTO.setArea(1);
        return propertyDTO;
    }

    private List<Date> createDateList(){
        List<Date> dateList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Date date = new Date();
            date.setTime(i);
            dateList.add(date);
        }
        return dateList;
    }

    private LocatarioDTO createLocatarioDTO(){
        LocatarioDTO locatario = new LocatarioDTO();
        locatario.setId(1L);
        locatario.setFavoritos(createImovelDTOList());
        return locatario;
    }

    private List<PropertyDTO> createImovelDTOList(){
        List<PropertyDTO> listPropertyDTO = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            PropertyDTO propertyDTO = new PropertyDTO();
            propertyDTO.setId((long) i);
            propertyDTO.setNome("teste");
            propertyDTO.setDescricao("testestestestestestestesteste");
            propertyDTO.setCategoria(TipoCategoria.CASA);
            propertyDTO.setIdProprietario(1L);
            propertyDTO.setDatasReservadas(createDateList());
            propertyDTO.setQuantidadeQuartos(1);
            propertyDTO.setArea(50);
            listPropertyDTO.add(propertyDTO);
        }
        return listPropertyDTO;
    }

}
