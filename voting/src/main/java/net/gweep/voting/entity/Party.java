package net.gweep.voting.entity;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Party {

	private String name;
	private Fraction fraction;
	private LocalDate date;
	private List<Candidate> candidaties;
}
