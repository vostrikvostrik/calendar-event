package com.vostrik.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Cache
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEvent implements Serializable {
   @Id private Long id;
   private String title;
   @JsonFormat(pattern = "yyyy-MM-dd")
   @Index private Date start;
   private Boolean allDay;
   @Index private String className;

   @Index private Integer year;
   @Index private Integer month;
   @Index private Integer day;

   @Index private Integer hour;
   @Index private Integer minute;

}
