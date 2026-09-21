package com.Itstep.FitnessClub.mapper;


import com.Itstep.FitnessClub.model.dto.ClientDto;
import com.Itstep.FitnessClub.model.dto.ClientInnerDto;
import com.Itstep.FitnessClub.model.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Daria Pevets
 **/
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ClientMapper {

    ClientDto clientToClientDto(Client client);

    ClientInnerDto clientToClientInnerDto(Client client);

    Client clientDtoToClient(ClientDto clientDto);

}
