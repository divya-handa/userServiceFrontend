package com.nagp.devops.user.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class User implements Serializable {

	private final Long userId;
	private final String userName;
	private final String address;
	private final String areaCode;
	private final boolean vaccinated;

	@JsonCreator
	public User(@JsonProperty("userId") Long userId, @JsonProperty("userName") String userName,
				@JsonProperty("address") String address, @JsonProperty("areaCode") String areaCode,
				@JsonProperty("vaccinated") boolean vaccinated) {
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.areaCode = areaCode;
		this.vaccinated = vaccinated;
	}

	public Long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getAddress() {
		return address;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public boolean isVaccinated() {
		return vaccinated;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, areaCode, userId, userName, vaccinated);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(address, other.address) && Objects.equals(areaCode, other.areaCode)
				&& Objects.equals(userId, other.userId) && Objects.equals(userName, other.userName)
				&& vaccinated == other.vaccinated;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", address=" + address + ", areaCode=" + areaCode
				+ ", vaccinated=" + vaccinated + "]";
	}

}
