package com.corporate.talent.dao;

import java.util.List;

public interface GenericDAO<T> {

    boolean save (T user);
    boolean delete (long id);
    boolean edit (T user);
    T readId (long id);
    List<T> readAll ();


}
