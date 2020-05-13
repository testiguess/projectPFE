package com.production.demo.JsonHolder;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

public class ParRouteVariables {
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	public LocalDateTime debutTime;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	public LocalDateTime finTime;
	public String typePoid;
	public LocalDateTime getDebutTime() {
		return debutTime;
	}
	public void setDebutTime(LocalDateTime debutTime) {
		this.debutTime = debutTime;
	}
	public LocalDateTime getFinTime() {
		return finTime;
	}
	public void setFinTime(LocalDateTime finTime) {
		this.finTime = finTime;
	}
	public String getTypePoid() {
		return typePoid;
	}
	public void setTypePoid(String typePoid) {
		this.typePoid = typePoid;
	}
	public ParRouteVariables(LocalDateTime debutTime, LocalDateTime finTime, String typePoid) {
		super();
		this.debutTime = debutTime;
		this.finTime = finTime;
		this.typePoid = typePoid;
	}
	
}
