package com.es.frame;

public class BookRecord<K, V> {

	private K k;
	private V v;
	public BookRecord() {

	}
	
	public BookRecord(K k, V v){
		this.k = k;
		this.v = v;
	}
	
	public K getK() {
		return k;
	}
	public void setK(K k) {
		this.k = k;
	}
	public V getV() {
		return v;
	}
	public void setV(V v) {
		this.v = v;
	}
}
