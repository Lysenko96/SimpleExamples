package net.gweep.voting.entity;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voting {

	private LocalDate date;
	private List<Party> parties;
	private VoterRepo voterRepo;

}