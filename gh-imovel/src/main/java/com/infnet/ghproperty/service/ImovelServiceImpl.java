package com.infnet.ghproperty.service;

import com.infnet.ghproperty.dto.ImovelDTO;
import com.infnet.ghproperty.domain.Imovel;
import com.infnet.ghproperty.exceptions.ResourceNotFoundException;
import com.infnet.ghproperty.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImovelServiceImpl implements ImovelService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ImovelRepository imovelRepository;

    @Override
    public ImovelDTO createProperty(ImovelDTO imovelDTO) {
        Imovel imovel = modelMapper.map(imovelDTO, Imovel.class);
        Imovel savedImovel = imovelRepository.save(imovel);
        return modelMapper.map(savedImovel, ImovelDTO.class);
    }

    @Override
    public ImovelDTO getPropertyById(Long propertyId) throws Exception {
        Imovel review = propertyExistsByID(propertyId);
        return modelMapper.map(review, ImovelDTO.class);
    }

    @Override
    public ImovelDTO updateProperty(Long propertyId, ImovelDTO imovelDTO) throws ResourceNotFoundException {
        if (!imovelRepository.existsById(propertyId)) {
            throw new ResourceNotFoundException("Imóvel não encontrado com o ID: " + propertyId);
        }
        imovelDTO.setId(propertyId);
        Imovel updatedImovel = imovelRepository.save(modelMapper.map(imovelDTO, Imovel.class));
        return modelMapper.map(updatedImovel, ImovelDTO.class);
    }

    @Override
    public void deleteProperty(Long propertyId) throws Exception {
        Imovel imovel = propertyExistsByID(propertyId);
        imovelRepository.delete(imovel);
    }

    @Override
    public List<ImovelDTO> getPropertyList() {
        List<Imovel> imovelList = imovelRepository.findAll();
        return imovelList.stream()
                .map(imovel -> modelMapper.map(imovel, ImovelDTO.class))
                .collect(Collectors.toList());
    }

    private Imovel propertyExistsByID(Long propertyId) throws Exception {
        if (!imovelRepository.existsById(propertyId)) {
            throw new ResourceNotFoundException("Imóvel não encontrado com o ID: " + propertyId);
        }
        return imovelRepository.findById(propertyId).get();
    }
}
