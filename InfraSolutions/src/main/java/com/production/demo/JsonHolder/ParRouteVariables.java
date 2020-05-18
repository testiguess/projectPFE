package com.production.demo.JsonHolder;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

public class ParRouteVariables {
	public Long rId;
	public String mode;
	public Long[] eIds;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	public LocalDateTime debutTime;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	public LocalDateTime finTime;
	public String typePoid;
	public Long getrId() {
		return rId;
	}
	public void setrId(Long rId) {
		this.rId = rId;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public Long[] geteIds() {
		return eIds;
	}
	public void seteIds(Long[] eIds) {
		this.eIds = eIds;
	}
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
	public ParRouteVariables(Long rId, String mode, Long[] eIds, LocalDateTime debutTime, LocalDateTime finTime,
			String typePoid) {
		super();
		this.rId = rId;
		this.mode = mode;
		this.eIds = eIds;
		this.debutTime = debutTime;
		this.finTime = finTime;
		this.typePoid = typePoid;
	}
	
}
