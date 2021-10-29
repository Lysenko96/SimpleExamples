package net.gweep.voting.entity;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Party {

	private String name;
	private Fraction fraction;
	private LocalDate date;
	private List<Candidate> candidaties;

	public List<Candidate> sortedByPrimaries(){
		return candidaties.stream().sorted(comparing(Candidate::getPrimaries).reversed()).collect(toList());
	}	
}