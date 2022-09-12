package com.casesproject.casesproject.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Builder
//@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Document(collection = "users")
public class User {

	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(unique = true, nullable = false)
	@Id
	private Long id;
	private String firstName;
	private String lastName;
	//@Column(unique = true)
	private String email;

}
