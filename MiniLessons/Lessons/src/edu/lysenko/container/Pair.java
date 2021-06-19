package edu.lysenko.container;

public class Pair<K, V> {

	final K key;
	final V value;

	Pair(K k, V v) {
		key = k;
		value = v;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

}
