package net.gweep.task;

import java.util.List;

public interface Component {

	List<Component> show(List<Component> components);
}