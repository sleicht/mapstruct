/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.itest.immutables;

public class NotificationMessageDto {
	private String message;
	private String tableId;
	private String type;

	public NotificationMessageDto(String message, String tableId, String type) {
		this.message = message;
		this.tableId = tableId;
		this.type = type;
	}

	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message = message;
	}
	public String getTableId(){
		return tableId;
	}
	public void setTableId(String tableId){
		this.tableId = tableId;
	}
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type = type;
	}
}
