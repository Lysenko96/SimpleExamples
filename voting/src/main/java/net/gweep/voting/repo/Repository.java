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

	// if change citizen change voter counter

	public void addStation(Station station) {
		stations.add(station);
	}

	public void addCitizen(Citizen citizen) {
		citizens.add(citizen);
	}

	public void addParty(Party party) {
		parties.add(party);
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
	
	
}
