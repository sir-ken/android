package com.erik.hellotabs;

import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.json.JSONArray;
import org.json.JSONException;

public class JSONArrayList<T> extends AbstractSequentialList<T>  {
    JSONArray mArray;

    public JSONArrayList() {
            super();
            mArray = new JSONArray();
    }

    public JSONArrayList(String jss) {
            super();
            try {
                    mArray = new JSONArray(jss);
            } catch (JSONException e) {
                    e.printStackTrace();
                    mArray = new JSONArray();
            }
    }

    public JSONArrayList(JSONArray a) {
            super();
            mArray = (a == null) ? new JSONArray() : a;
    }


    public JSONArray getArray() {
            return mArray;
    }

    public String toString() {
            return mArray.toString();
    }

    /**
     * Return a separator-separated string containing all the members in
the array
     * @param separator - the separator to appear btw the parts of the
output string
     * @return a new string with the array components separated by
separator
     */
    public String join(String separator) {
            try {
                    return mArray.join(separator);
            } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return null;
            }
    }

    @Override
    public void add(int location, T object) {
            int len = mArray.length();
            if(location < 0 || location > len)
                    throw new IndexOutOfBoundsException();
            try {
                    for(int i = len; i > location; --i) {
                            mArray.put(i, mArray.getString(i-1));
                    }
                    mArray.put(location, object);
            } catch (JSONException e) {
                    e.printStackTrace();
            }
    }

    @Override
    public boolean addAll(int arg0, Collection<? extends T> arg1) {
            if(arg0 < 0)
                    throw new IndexOutOfBoundsException();
            for(T o : arg1) {
                    try {
                            mArray.put(arg0++, o);
                    } catch (JSONException e) {
                            e.printStackTrace();
                            throw new IllegalArgumentException();
                    }
            }
            return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int location) {
            if(location >= mArray.length())
                    throw new IndexOutOfBoundsException();
            return (T) mArray.opt(location);
    }

    private class MyIterator<E> implements Iterator<E> {

            int pos = -1;

            @Override
            public boolean hasNext() {
                    return pos + 1 < mArray.length();
            }

            @SuppressWarnings("unchecked")
            @Override
            public E next() {
                    if(pos + 1 >= mArray.length())
                            throw new NoSuchElementException();
                    return (E) mArray.opt(++pos);
            }

            @Override
            public void remove() {
                    throw new UnsupportedOperationException();
            }

    }
    @Override
    public Iterator<T> iterator() {
            return new MyIterator<T>();
    }

    @Override
    public int lastIndexOf(Object object) {
            for(int i = mArray.length()-1; i >= 0; --i) {
                    if(mArray.optString(i).equals(object))
                            return i;
            }
            return -1;
    }

    @Override
    public ListIterator<T> listIterator(int location) {
            return new MyListIterator<T>(location);
    }

    @Override
    public T remove(int location) {
            throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object object) {
            throw new UnsupportedOperationException();
    }

    @SuppressWarnings("unchecked")
    public T set(int location, T object) {
            T r = (T) mArray.opt(location);
            mArray.put(object);
            return r;
    }

    class MyListIterator<E> implements ListIterator<E>  {
            int mPos = -1;

            public MyListIterator() {
                    super();
            }

            public MyListIterator(int location) {
                    super();
                    if(location < 0)
                            location = 0;
                    mPos = location - 1;
            }

            @Override
            public void add(E arg0) {
                    try {
                            for(int i = mArray.length(); i > mPos + 1; --i) 
{
                                    mArray.put(i, mArray.getString(i-1));
                            }
                            mArray.put(++mPos, arg0);
                    } catch (JSONException e) {
                            e.printStackTrace();
                    }
            }

            @Override
            public boolean hasNext() {
                    return mPos + 1 < mArray.length();
            }

            @Override
            public boolean hasPrevious() {
                    return mPos >= 0;
            }

            @SuppressWarnings("unchecked")
            @Override
            public E next() {
                    if(mPos + 1 >= mArray.length())
                            throw new NoSuchElementException();
                    return (E) mArray.opt(++mPos);
            }

            @Override
            public int nextIndex() {
                    return mPos + 1;
            }

            @SuppressWarnings("unchecked")
            @Override
            public E previous() {
                    if(mPos < 0)
                            throw new NoSuchElementException();
                    return (E) mArray.opt(mPos--);
            }

            @Override
            public int previousIndex() {
                    return mPos;
            }

            @Override
            public void remove() {
                    throw new UnsupportedOperationException();

            }

            @Override
            public void set(E arg0) {
                    if(mPos == -1)
                            throw new IllegalStateException();
                    try {
                            mArray.put(mPos, arg0);
                    } catch (JSONException e) {
                            e.printStackTrace();
                            throw new IllegalArgumentException();
                    }
            }
    }
    @Override
    public int size() {
            return mArray.length();
    }
}

