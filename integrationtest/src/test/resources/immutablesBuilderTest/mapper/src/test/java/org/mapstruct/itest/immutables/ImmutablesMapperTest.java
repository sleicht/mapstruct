/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.itest.immutables;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for generation of Lombok Builder Mapper implementations
 *
 * @author Eric Martineau
 */
public class ImmutablesMapperTest {

    @Test
    public void testSimpleImmutableBuilderHappyPath() {
        PersonDto personDto = PersonMapper.INSTANCE.toDto( ImmutablePerson.builder()
            .age( 33 )
            .name( "Bob" )
            .address( ImmutableAddress.builder()
                .addressLine( "Wild Drive" )
                .build() )
            .build() );
        assertThat( personDto.getAge() ).isEqualTo( 33 );
        assertThat( personDto.getName() ).isEqualTo( "Bob" );
        assertThat( personDto.getAddress() ).isNotNull();
        assertThat( personDto.getAddress().getAddressLine() ).isEqualTo( "Wild Drive" );
    }

    @Test
    public void testLombokToImmutable() {
        Person person = PersonMapper.INSTANCE.fromDto( new PersonDto( "Bob", 33, new AddressDto( "Wild Drive" ) ) );
        assertThat( person.getAge() ).isEqualTo( 33 );
        assertThat( person.getName() ).isEqualTo( "Bob" );
        assertThat( person.getAddress() ).isNotNull();
        assertThat( person.getAddress().getAddressLine() ).isEqualTo( "Wild Drive" );
    }

    @Test
	public void testInfixFrom() {
		NotificationMessageDtoInfix notificationMessage = NotificationMessageInfixMapper.INSTANCE.fromDto(new NotificationMessageDto("Message", "33", "Outbound"));
		assertThat(notificationMessage.getMessage()).isEqualTo("Message");
		assertThat(notificationMessage.getTableId()).isEqualTo("33");
		assertThat(notificationMessage.getType()).isEqualTo("Outbound");
	}

	@Test
	public void testInfixTo() {
		NotificationMessageDto notificationMessage = NotificationMessageInfixMapper.INSTANCE.toDto(_NotificationMessageDtoInfix_.builder()
			.message("Message")
			.tableId("33")
			.type("Outbound")
			.build());
		assertThat(notificationMessage.getMessage()).isEqualTo("Message");
		assertThat(notificationMessage.getTableId()).isEqualTo("33");
		assertThat(notificationMessage.getType()).isEqualTo("Outbound");
	}

    @Test
	public void testPostfixFrom() {
		NotificationMessageDtoPostfix notificationMessage = NotificationMessagePostfixMapper.INSTANCE.fromDto(new NotificationMessageDto("Message", "33", "Outbound"));
		assertThat(notificationMessage.getMessage()).isEqualTo("Message");
		assertThat(notificationMessage.getTableId()).isEqualTo("33");
		assertThat(notificationMessage.getType()).isEqualTo("Outbound");
	}

	@Test
	public void testPostfixTo() {
		NotificationMessageDto notificationMessage = NotificationMessagePostfixMapper.INSTANCE.toDto(NotificationMessageDtoPostfix_.builder()
			.message("Message")
			.tableId("33")
			.type("Outbound")
			.build());
		assertThat(notificationMessage.getMessage()).isEqualTo("Message");
		assertThat(notificationMessage.getTableId()).isEqualTo("33");
		assertThat(notificationMessage.getType()).isEqualTo("Outbound");
	}

    @Test
	public void testPrefixFrom() {
		NotificationMessageDtoPrefix notificationMessage = NotificationMessagePrefixMapper.INSTANCE.fromDto(new NotificationMessageDto("Message", "33", "Outbound"));
		assertThat(notificationMessage.getMessage()).isEqualTo("Message");
		assertThat(notificationMessage.getTableId()).isEqualTo("33");
		assertThat(notificationMessage.getType()).isEqualTo("Outbound");
	}

	@Test
	public void testPrefixTo() {
		NotificationMessageDto notificationMessage = NotificationMessagePrefixMapper.INSTANCE.toDto(_NotificationMessageDtoPrefix.builder()
			.message("Message")
			.tableId("33")
			.type("Outbound")
			.build());
		assertThat(notificationMessage.getMessage()).isEqualTo("Message");
		assertThat(notificationMessage.getTableId()).isEqualTo("33");
		assertThat(notificationMessage.getType()).isEqualTo("Outbound");
	}
}
