package com.vostrik.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class SessionUser implements Serializable {
    String name;
    String email;
    String id;
}
