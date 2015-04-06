package com.hackbulgaria.corejava;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import org.apache.commons.lang.SerializationUtils;

public final class ImmutableList<E> extends ArrayList<E> { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3941637011072773547L;

	public ImmutableList(Collection <? extends E> collection) {
		super.addAll(collection);
	}
	
	@Override
	public E get(int index) {
		return (E) SerializationUtils.clone( (Serializable) super.get(index));
	}
	@SafeVarargs
	public final ImmutableList<E> asList(E... arguments) {
		List<E> list = new LinkedList<E>(Arrays.asList(arguments));
		return new ImmutableList<E>(list);
	}
	
	@Override
	public boolean add(E e) {
		throw new IllegalModificationException();
	}
	
	@Override
	public E remove(int index) {
		throw new IllegalModificationException();
	}
	
	@Override
	public void add(int index, E element) {
		throw new IllegalModificationException();
	}
	
	@Override
	public boolean retainAll(Collection<?> c){
		throw new IllegalModificationException();
	}

	@Override
	public E set(int index, E element) {
		throw new IllegalModificationException();
	}

	@Override
	public void clear() {
		throw new IllegalModificationException();
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new IllegalModificationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		throw new IllegalModificationException();
	}

	@Override
	protected void removeRange(int fromIndex, int toIndex) {
		throw new IllegalModificationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new IllegalModificationException();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		throw new IllegalModificationException();
	}

	@Override
	public ListIterator<E> listIterator() {
		throw new IllegalModificationException();
	}

	@Override
	public boolean removeIf(Predicate<? super E> filter) {
		throw new IllegalModificationException();
	}

	@Override
	public void replaceAll(UnaryOperator<E> operator) {
		throw new IllegalModificationException();
	}



	
	

}
