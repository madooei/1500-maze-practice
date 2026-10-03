package stack;

import java.util.NoSuchElementException;

/**
 * An array-backed implementation of the Stack ADT.
 *
 * @param <T> the type of elements in this stack.
 */
public class ArrayStack<T> implements Stack<T> {

  private T[] arr;   // the top is at index size - 1
  private int size;

  // arr only ever holds T, so the cast is safe.
  @SuppressWarnings("unchecked")
  public ArrayStack() {
    arr = (T[]) new Object[10];
    size = 0;
  }

  @Override
  public void push(T item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }
    if (size == arr.length) {
      grow();
    }
    arr[size] = item;
    size++;
  }

  @Override
  public void pop() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    size--;
    arr[size] = null;  // clear the slot so the object can be garbage collected
  }

  @Override
  public T top() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return arr[size - 1];
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  // Doubles the capacity. Same cast rationale as the constructor.
  @SuppressWarnings("unchecked")
  private void grow() {
    T[] bigger = (T[]) new Object[arr.length * 2];
    for (int i = 0; i < size; i++) {
      bigger[i] = arr[i];
    }
    arr = bigger;
  }
}
