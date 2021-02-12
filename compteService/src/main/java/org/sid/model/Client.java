package org.sid.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Client {

	private Long code;
    private String name;
    private String email;
}
