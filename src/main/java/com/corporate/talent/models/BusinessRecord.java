package com.corporate.talent.models;

import java.util.*;

//Java 17/21 Record
public record BusinessRecord(long id, String name, long NIT, int foundationAge,
                             boolean isWorking, List<String> technologies, Map<String, Integer> Sedes){

}
