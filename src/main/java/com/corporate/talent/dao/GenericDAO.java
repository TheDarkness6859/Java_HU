package com.corporate.talent.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T> {

    boolean save (T user);
    boolean delete (long id);
    boolean edit (T user);
    Optional<T> readId (long id);
    List<T> readAll ();


}
