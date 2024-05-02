package com.cnade.betfthelper.util;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class Utility {

    public static Specification equalsSpecification(String campo, String value) {
        return (root, query, cb) -> cb.equal(root.get(campo), value);
    }
    public static Specification equalsSpecification(String campoId, String campo, Object value) {
        return (root, query, cb) -> cb.equal(root.get(campoId).get(campo), value);
    }

    public static Specification betweenSpecification(String campo, String value1, String value2) {
        return (root, query, cb) -> cb.between(root.get(campo), value1, value2);
    }

    public static Specification inSpecification(String campo, List<String> list) {
        return (root, query, cb) -> cb.in(root.get(campo)).value(list);
    }

}
