package mng.main.avantstay.reservation.entity;

import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.util.Map;

public class PropertyEntity implements Serializable {

    public String id;
    public String name;

    public PropertyEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }


    public void describe() throws Exception {
        System.out.println("--- ");
        System.out.println("> Property Entity");
        Map<?, ?> content = BeanUtils.describe(this);
        content.keySet().forEach(s -> System.out.println(s + " >> " + content.get(s)));
    }


}
