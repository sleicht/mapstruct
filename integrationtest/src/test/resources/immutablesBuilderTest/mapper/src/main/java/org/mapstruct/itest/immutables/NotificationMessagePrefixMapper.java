/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.itest.immutables;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface NotificationMessagePrefixMapper {

	NotificationMessagePrefixMapper INSTANCE = Mappers.getMapper( NotificationMessagePrefixMapper.class );

	NotificationMessageDtoPrefix fromDto(NotificationMessageDto notificationMessageDto);
	NotificationMessageDto toDto(NotificationMessageDtoPrefix notificationMessageDto);
}
