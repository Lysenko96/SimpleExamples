package edu.lysenko.container1;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class ContainerList extends AbstractList<String> {

	private int size;
	private List<String> strings = new ArrayList<>();

	public ContainerList() {
	}

	public ContainerList(int size) {
		if (size > 0) {
			this.size = size;
		} else
			this.size = 0;
	}

	@Override
	public boolean add(String e) {
		return strings.add(e);
	}

	public List<String> getList() {
		return strings;
	}

	@Override
	public String get(int index) {
		return String.valueOf(index);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + size;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContainerList other = (ContainerList) obj;
		if (size != other.size)
			return false;
		return true;
	}

	public static void main(String[] args) {
		ContainerList containerList = new ContainerList(4);
		ContainerList containerList2 = new ContainerList();
		System.out.println(containerList.getList());
		System.out.println(containerList2.getList());

	}

}
