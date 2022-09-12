package com.casesproject.casesproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Builder
//@Table(name = "note")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Document(collection = "notes")
public class Note {

	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String details;
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "case_id")
	@JsonIgnore
	private Case mCase;

	@Override
	public String toString() {
		return "Note{" +
				"id=" + id +
				", details='" + details + '\'' +
				", mCase=" + (mCase != null ? mCase.toString() : "{}") +
				'}';
	}
}
