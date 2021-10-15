package net.gweep.task;

import java.util.List;

public interface Component {

	List<Component> accumulate(List<Component> components);
}