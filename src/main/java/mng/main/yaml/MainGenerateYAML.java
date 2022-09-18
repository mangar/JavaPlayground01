package mng.main.yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import mng.main.yaml.entity.Orders;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class MainGenerateYAML {

    public static void main(String args[]) throws IOException {

        Orders orders = OrderFactory.generateOrder(2);

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        // write to a file
        // >>>>>>>>>>>>>>>>>
        mapper.writeValue(new File("./_output/orders.yaml"), orders);
        // <<<<<<<<<<<<<<<<<


        // write to a String
        // >>>>>>>>>>>>>>>>>
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        mapper.writeValue(stream, orders);
        // <<<<<<<<<<<<<<<<<

        System.out.println(">>");
        System.out.println(stream.toString());
        System.out.println("<<");


        System.out.println("Done!");

    }


}
