package com.Itstep.FitnessClub.mapper;

import com.Itstep.FitnessClub.model.dto.SubscriptionDto;
import com.Itstep.FitnessClub.model.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Daria Pevets
 **/
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionDto mapClientToSubDto(Client client);

}
