package net.gweep.voting.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.gweep.voting.entity.Candidate;
import net.gweep.voting.entity.Citizen;
import net.gweep.voting.entity.Party;
import net.gweep.voting.entity.Station;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repository {

	List<Station> stations = new ArrayList<>();
	List<Citizen> citizens = new ArrayList<>();
	List<Party> parties = new ArrayList<>();

	public void addStation(Station station) {
		stations.add(station);
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
		List<Candidate> candidates = new ArrayList<>(citizen.getParty().getCandidaties());
		citizens.add(citizen);
		candidates.add(new Candidate(citizen, primaries));
		citizen.getParty().setCandidaties(candidates);
	}

	public Map<Station, List<Citizen>> getMapStationCitizens() {
		return citizens.stream().collect(Collectors.groupingBy(Citizen::getStation));
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

	public void deleteCitizenCardByStaionIdByIdCard(int id, long idCard) {
		List<Citizen> citizensStation = new ArrayList<>(getStationById(id).getCitizens());
		citizensStation.remove(getCitizenByIdCard(idCard));
		citizens.remove(getCitizenByIdCard(idCard));
		getStationById(id).setCitizens(citizensStation);
	}

	public void showCitizens() {
		System.out.println(citizens);
	}

	public void showParties() {
		System.out.println(parties);
	}

	public void addPartyCandidate(Candidate candidate) {
		Party party = candidate.getParty();
		List<Candidate> candidates = new ArrayList<>(party.getCandidaties());
		candidates.add(candidate);
		citizens.add(new Citizen(candidate));
		party.setCandidaties(candidates);
	}

	public void deletePartyCandidate(long idCard) {
		Citizen citizen = getCitizenByIdCard(idCard);
		Party party = citizen.getParty();
		List<Candidate> candidates = new ArrayList<>(party.getCandidaties());
		Candidate candidate = candidates.stream().filter(c -> c.getIdCard() == idCard).findFirst()
				.orElse(new Candidate());
		candidates.remove(candidate);
		party.setCandidaties(candidates);
	}
}