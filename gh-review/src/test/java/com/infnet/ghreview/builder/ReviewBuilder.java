package com.infnet.ghreview.builder;

import com.infnet.ghreview.domain.Review;
import com.infnet.ghreview.dto.ImovelDTO;
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
        ImovelDTO imovelDTO = createImovelDTO();
        LocatarioDTO locatarioDTO = createLocatarioDTO();

        Review review = new Review();
        review.setId(1L);
        review.setDescricao("testestestestestestestesteste");
        review.setImovel(imovelDTO);
        review.setLocatario(locatarioDTO);
        return review;
    }

    public Review createReviewWithId(Long id){
        ImovelDTO imovelDTO = createImovelDTO();

        Review review = new Review();
        review.setId(id);
        review.setDescricao("testestestestestestestesteste");
        review.setImovel(imovelDTO);
        review.setLocatario(createLocatarioDTO());
        return review;
    }

    public List<Review> createReviewList(){
        ImovelDTO imovelDTO = createImovelDTO();
        LocatarioDTO locatarioDTO = createLocatarioDTO();

        List<Review> listImovel = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Review review = new Review();
            review.setId((long) i);
            review.setDescricao("testestestestestestestesteste");
            review.setImovel(imovelDTO);
            review.setLocatario(locatarioDTO);
            listImovel.add(review);
        }
        return listImovel;
    }

    private ImovelDTO createImovelDTO(){
        ImovelDTO imovelDTO = new ImovelDTO();
        imovelDTO.setId(1L);
        imovelDTO.setNome("teste");
        imovelDTO.setDescricao("testestestestestestestesteste");
        imovelDTO.setCategoria(TipoCategoria.CASA);
        imovelDTO.setIdProprietario(1L);
        imovelDTO.setDatasReservadas(createDateList());
        imovelDTO.setQuantidadeQuartos(1);
        imovelDTO.setArea(1);
        return imovelDTO;
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

    private List<ImovelDTO> createImovelDTOList(){
        List<ImovelDTO> listImovelDTO = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ImovelDTO imovelDTO = new ImovelDTO();
            imovelDTO.setId((long) i);
            imovelDTO.setNome("teste");
            imovelDTO.setDescricao("testestestestestestestesteste");
            imovelDTO.setCategoria(TipoCategoria.CASA);
            imovelDTO.setIdProprietario(1L);
            imovelDTO.setDatasReservadas(createDateList());
            imovelDTO.setQuantidadeQuartos(1);
            imovelDTO.setArea(50);
            listImovelDTO.add(imovelDTO);
        }
        return listImovelDTO;
    }

}
