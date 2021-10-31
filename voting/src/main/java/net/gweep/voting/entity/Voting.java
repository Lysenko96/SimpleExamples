package net.gweep.voting.entity;

import java.time.LocalDate;
import java.util.List;
import static java.util.stream.Collectors.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voting {

	private LocalDate date;
	private List<Party> parties;
	private List<Citizen> citizens;

	public List<Citizen> getVoteCitizens() {
		return citizens.stream().filter(Citizen::isVote).collect(toList());
	}
	
	// check all citizenIsVote and add choice party if not set it
}