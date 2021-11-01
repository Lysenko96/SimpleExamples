package net.gweep.voting.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.gweep.voting.entity.Candidate;
import net.gweep.voting.entity.Citizen;
import net.gweep.voting.entity.Party;
import net.gweep.voting.entity.Station;
import net.gweep.voting.entity.Voting;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repository {

	List<Station> stations = new ArrayList<>();
	List<Citizen> citizens = new ArrayList<>();
	List<Party> parties = new ArrayList<>();
	List<Candidate> candidates = new ArrayList<>();
	List<Voting> votings = new ArrayList<>();

	public void addStation(Station station) {
		stations.add(station);
	}

	public void addCandidate(Candidate candidate) {
		List<Candidate> candidatesAll = new ArrayList<>(candidates);
		candidatesAll.add(candidate);
		candidates = candidatesAll;
	}

	public void addCitizen(Citizen citizen) {
		List<Citizen> citizensAll = new ArrayList<>(citizens);
		citizensAll.add(citizen);
		citizens = citizensAll;
	}

	public void addParty(Party party) {
		List<Party> partiesAll = new ArrayList<>(parties);
		partiesAll.add(party);
		parties = partiesAll;
	}

	public void setPartyCandidate(Citizen citizen, int primaries) {
		List<Candidate> candidatesList = new ArrayList<>(citizen.getParty().getCandidaties());
		citizens.add(citizen);
		candidatesList.add(new Candidate(citizen, primaries));
		citizen.getParty().setCandidaties(candidatesList);
	}

	public Map<Station, List<Citizen>> getMapStationCitizens() {
		return citizens.stream().collect(groupingBy(Citizen::getStation));
	}

	public Station getStationById(int id) {
		return stations.stream().filter(station -> station.getId() == id).findFirst().orElse(new Station());
	}

	public void addCitizenByStationId(int id, Citizen citizen) {
		List<Citizen> citizensStation = new ArrayList<>(getStationById(id).getCitizens());
		citizens.add(citizen);
		citizensStation.add(citizen);
		getStationById(id).setCitizens(citizensStation);
	}

	public Citizen getCitizenByIdCard(long idCard) {
		return citizens.stream().filter(citizen -> citizen.getIdCard() == idCard).findFirst().orElse(new Citizen());
	}

	public void deleteCitizenByStaionIdByIdCard(int id, long idCard) {
		List<Citizen> citizensStation = new ArrayList<>(getStationById(id).getCitizens());
		citizensStation.remove(getCitizenByIdCard(idCard));
		citizens.remove(getCitizenByIdCard(idCard));
		getStationById(id).setCitizens(citizensStation);
	}

	public void addPartyCandidate(Candidate candidate) {
		Party party = candidate.getParty();
		List<Candidate> candidatesList = new ArrayList<>(party.getCandidaties());
		candidatesList.add(candidate);
		citizens.add(new Citizen(candidate));
		party.setCandidaties(candidatesList);
	}

	public void deletePartyCandidate(long idCard) {
		Citizen citizen = getCitizenByIdCard(idCard);
		Party party = citizen.getParty();
		List<Candidate> candidatesList = new ArrayList<>(party.getCandidaties());
		Candidate candidate = candidatesList.stream().filter(c -> c.getIdCard() == idCard).findFirst()
				.orElse(new Candidate());
		candidatesList.remove(candidate);
		party.setCandidaties(candidatesList);
	}
}