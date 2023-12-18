package com.aula.Aula.Data.Vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"id","firstName","lastName", "adress", "gender"})
public class PersonVO extends RepresentationModel <PersonVO> implements Serializable {

        private static final long serialVersionUID = 1L;
        @JsonProperty("id")
        private Long key;
        private String firstName;
        private String lastName;
        private String adress;
        private String gender;


        public PersonVO() {

        }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getAdress() {
            return adress;
        }

        public void setAdress(String adress) {
            this.adress = adress;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonVO personVO)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getKey(), personVO.getKey()) && Objects.equals(getFirstName(), personVO.getFirstName()) && Objects.equals(getLastName(), personVO.getLastName()) && Objects.equals(getAdress(), personVO.getAdress()) && Objects.equals(getGender(), personVO.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getKey(), getFirstName(), getLastName(), getAdress(), getGender());
    }
}
