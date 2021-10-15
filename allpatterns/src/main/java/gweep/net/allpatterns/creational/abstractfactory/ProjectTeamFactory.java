package gweep.net.allpatterns.creational.abstractfactory;

public interface ProjectTeamFactory {

	Architector getArchitector();

	Builder getBuilder();
}