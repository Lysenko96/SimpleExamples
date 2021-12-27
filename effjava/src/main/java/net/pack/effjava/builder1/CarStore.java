package net.pack.effjava.builder1;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class CarStore {

	public enum Trunk {
		SEDAN, COUPE, HATCHBACK
	}

	final Set<Trunk> trunks;

	abstract static class Builder<T extends Builder<T>> {

		EnumSet<Trunk> trunks = EnumSet.noneOf(Trunk.class);

		public T addTrunk(Trunk trunk) {
			trunks.add(Objects.requireNonNull(trunk));
			return self();
		}

		public abstract CarStore build();

		protected abstract T self();
	}

	CarStore(Builder<?> builder) {
		trunks = builder.trunks.clone();
	}
}