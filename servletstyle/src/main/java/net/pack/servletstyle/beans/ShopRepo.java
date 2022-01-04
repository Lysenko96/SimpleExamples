package net.pack.servletstyle.beans;

import java.io.Serializable;
import java.util.Objects;

public class ShopRepo implements Serializable{

	private static final long serialVersionUID = 5630295772480045416L;
	private String nameProduct;
	private int countProduct;

	public ShopRepo() {
	}

	public ShopRepo(String nameProduct, int count) {
		this.nameProduct = nameProduct;
		this.countProduct = count;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public int getCountProduct() {
		return countProduct;
	}

	public void setCountProduct(int countProduct) {
		this.countProduct = countProduct;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(countProduct, nameProduct);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShopRepo other = (ShopRepo) obj;
		return countProduct == other.countProduct && Objects.equals(nameProduct, other.nameProduct);
	}

	@Override
	public String toString() {
		return "ShopRepo [nameProduct=" + nameProduct + ", countProduct=" + countProduct + "]";
	}
}