package net.pack.effjava.builder1;

import java.util.Objects;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BmwStore extends CarStore {

	private final String address;

	public static class Builder extends CarStore.Builder<Builder> {

		private final String address;

		public Builder(String address) {
			this.address = Objects.requireNonNull(address);
		}

		@Override
		public BmwStore build() {
			return new BmwStore(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
	}

	private BmwStore(Builder builder) {
		super(builder);
		address = builder.address;
	}

	@Override
	public String toString() {
		return "BmwStore [address=" + address + ", trunks=" + trunks + "]";
	}
}
