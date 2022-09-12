package com.casesproject.casesproject.domain;

import com.casesproject.casesproject.enums.Status;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


//@Entity
@Builder
//@Table(name = "cases")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Document(collection = "cases")
public class Case {

	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String title;
	private String description;
	private Integer severity;
	//@Enumerated(EnumType.STRING)
	private Status status;
	//@ManyToOne
	//@JoinColumn(name = "user_id")
	private User user;
	//@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "mCase")
//	@JoinColumn(name = "case_id", referencedColumnName = "id")
	private List<Note> notes;


	@Override
	public String toString() {
		return "Case{" +
				"id=" + id +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", severity=" + severity +
				", status=" + status +
				", user=" + user.toString() +
				'}';
	}
}
