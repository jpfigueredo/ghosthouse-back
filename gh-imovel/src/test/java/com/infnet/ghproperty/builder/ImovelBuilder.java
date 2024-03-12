package com.infnet.ghproperty.builder;

import com.infnet.ghproperty.domain.Imovel;
import com.infnet.ghproperty.domain.Proprietario;
import com.infnet.ghproperty.dto.ImovelDTO;
import com.infnet.ghproperty.enums.TipoCategoria;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class ImovelBuilder {

    public ImovelDTO createImovelDTO(){
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

    public ImovelDTO createImovelDTOWithId(Long id) {
        ImovelDTO imovelDTO = new ImovelDTO();
        imovelDTO.setId(id);
        imovelDTO.setNome("teste");
        imovelDTO.setDescricao("testestestestestestestesteste");
        imovelDTO.setCategoria(TipoCategoria.CASA);
        imovelDTO.setIdProprietario(1L);
        imovelDTO.setDatasReservadas(createDateList());
        imovelDTO.setQuantidadeQuartos(1);
        imovelDTO.setArea(1);
        return imovelDTO;
    }

    public List<ImovelDTO> createImovelDTOList(){
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

    public Imovel createImovel(){
        Imovel imovel = new Imovel();
        imovel.setId(1L);
        imovel.setNome("teste");
        imovel.setDescricao("testestestestestestestesteste");
        imovel.setCategoria(TipoCategoria.CASA);
        imovel.setProprietario(createProprietario());
        imovel.setDatasReservadas(createDateList());
        imovel.setQuantidadeQuartos(1);
        imovel.setArea(1);
        return imovel;
    }

    public List<Imovel> createImovelList(){
        List<Imovel> listImovel = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Imovel imovel = new Imovel();
            imovel.setId((long) i);
            imovel.setNome("teste");
            imovel.setDescricao("testestestestestestestesteste");
            imovel.setCategoria(TipoCategoria.CASA);
            imovel.setProprietario(createProprietario());
            imovel.setDatasReservadas(createDateList());
            imovel.setQuantidadeQuartos(1);
            imovel.setArea(1);
            listImovel.add(imovel);
        }
        return listImovel;
    }

    public Imovel createImovelWithId(Long id){
        Imovel imovel = new Imovel();
        imovel.setId(id);
        imovel.setNome("teste");
        imovel.setDescricao("testestestestestestestesteste");
        imovel.setCategoria(TipoCategoria.CASA);
        imovel.setProprietario(createProprietario());
        imovel.setDatasReservadas(createDateList());
        imovel.setQuantidadeQuartos(1);
        imovel.setArea(1);
        return imovel;
    }

    private Proprietario createProprietario(){
        Proprietario proprietario = new Proprietario();
        proprietario.setId(1L);
        proprietario.setNome("teste");
        proprietario.setEmail("teste@teste.test");
        proprietario.setSenha("etset");
        proprietario.setTelefone("+55 12345-6789");
        return proprietario;
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


}
