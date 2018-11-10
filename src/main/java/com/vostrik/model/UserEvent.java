package com.vostrik.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEvent implements Serializable {
   private Long id;
   private String title;
   @JsonFormat(pattern = "yyyy-MM-dd")
   private Date start;
   private Boolean allDay;
   private String className;

   private Integer year;
   private Integer month;
   private Integer day;

   private Integer hour;
   private Integer minute;

}
