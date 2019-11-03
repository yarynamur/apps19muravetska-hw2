package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList{
    private Object[] array;
    private int len;
    private final int DEFAULT_LENGHT = 50;

    public ImmutableArrayList() {
        array = new Object[DEFAULT_LENGHT];
        this.len = 0;
    }


    public ImmutableArrayList(int lenght) {
        array = new Object[lenght];
        this.len = lenght;
    }

    public ImmutableArrayList(Object[] array) {
        this.array = new Object[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
        this.len = array.length;
    }

    private void checkSize(int index) throws IndexOutOfBoundsException{
        if (index >= this.len || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableList add(Object e){
        return add(this.len, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        checkSize(index);
        Object[] NewImmutableArrayList = new Object[this.len + 1];
        System.arraycopy(this.array, 0, NewImmutableArrayList, 0, index);
        System.arraycopy(this.array, index, NewImmutableArrayList, index + 1,
                this.len - index);
        NewImmutableArrayList[index] = e;
        return new ImmutableArrayList(NewImmutableArrayList);
    }

    @Override
    public ImmutableList addAll(Object[] c){
        return addAll(this.len, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c){
        checkSize(index);
        Object[] NewImmutableArrayList = new Object[this.len + c.length];
        System.arraycopy(this.array, 0, NewImmutableArrayList, 0, index);
        System.arraycopy(c, 0, NewImmutableArrayList, index, c.length);
        System.arraycopy(this.array, index, NewImmutableArrayList, index + c.length,
                this.array.length - index);
        return new ImmutableArrayList(NewImmutableArrayList);
    }

    @Override
    public Object get(int index){
        checkSize(index);
        return this.array[index];
    }

    @Override
    public ImmutableList remove(int index){
        checkSize(index);
        Object[] NewImmutableArrayList = new Object[this.len - 1];
        System.arraycopy(this.array, 0, NewImmutableArrayList, 0, index);
        System.arraycopy(this.array, index + 1, NewImmutableArrayList, index,
                this.array.length - index - 1);
        return new ImmutableArrayList(NewImmutableArrayList);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        checkSize(index);
        Object[] NewImmutableArrayList = Arrays.copyOf(this.array, this.len);
        NewImmutableArrayList[index] = e;
        return new ImmutableArrayList(NewImmutableArrayList);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.len;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.len == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] NewImmutableArrayList = Arrays.copyOf(this.array, this.len);
        return NewImmutableArrayList;
    }


    @Override
    public String toString() {
        return Arrays.toString(this.array);
    }

}
