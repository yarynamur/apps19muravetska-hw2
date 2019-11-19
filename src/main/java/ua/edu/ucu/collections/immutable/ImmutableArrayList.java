package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList{
    private Object[] array;
    private int len;

    public ImmutableArrayList() {
        array = new Object[0];
        this.len = 0;
    }

    public ImmutableArrayList(Object[] array) {
        this.array = Arrays.copyOf(array, array.length);
        this.len = array.length;
    }

    private void checkSize(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index > this.len) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableArrayList add(Object e){
        return add(this.len, e);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        Object[] temp = Arrays.copyOf(this.array, this.len + 1);
        for (int i = len; i > index; --i) {
            temp[i] = temp[i - 1];
        }
        temp[index] = e;
        ImmutableArrayList NewImmutableArrayList = new ImmutableArrayList(temp);
        return NewImmutableArrayList;
    }

    @Override
    public ImmutableArrayList addAll(Object[] c){
        return addAll(this.len, c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c){
        checkSize(index);
        Object[] NewImmutableArrayList = new Object[size() + c.length];
        for (int i = 0; i < index; i++) {
            NewImmutableArrayList[i] = this.get(i);
        }
        for (int i = 0; i < c.length; i++) {
            NewImmutableArrayList[index + i] = c[i];
        }
        for (int i = index; i < size(); i++) {
            NewImmutableArrayList[i + c.length] = this.get(i);
        }
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
            if (this.array[i].equals(e)) {
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
        if (this.len == 0){
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
//        Object[] NewImmutableArrayList = Arrays.copyOf(this.array, this.len);
        return Arrays.copyOf(this.array, this.len);
    }


    @Override
    public String toString() {
        return Arrays.toString(this.array);
    }

}
