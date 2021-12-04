package com.te.session;

import java.util.Objects;

public class MyBean {

	private int num;

	public MyBean() {
	}

	public MyBean(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public int hashCode() {
		return Objects.hash(num);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyBean other = (MyBean) obj;
		return num == other.num;
	}

	@Override
	public String toString() {
		return "MyBean [num=" + num + "]";
	}
}

