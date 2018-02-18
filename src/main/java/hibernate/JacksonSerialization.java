package hibernate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import hibernate.model.Actor;
import hibernate.model.Employee;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;


public class JacksonSerialization {

    final static Logger logger = Logger.getLogger(JacksonSerialization.class);

    public static void serialize(ObjectMapper mapper, String fileSuffix) throws IOException {
        //Set mapper to pretty-print
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(new JodaModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);;

        ModelObjectsCreator oc1 = new ModelObjectsCreator();
        List<Employee> employees = oc1.employees;

        ModelObjectsCreator oc2 = new ModelObjectsCreator();
        List<Actor> actors = oc2.actors;

        mapper.writeValue(new File("actors." + fileSuffix), actors);
        String js1 = mapper.writeValueAsString(actors);
        logger.info("Printing serialized original object " + fileSuffix);
        System.out.println(js1);


        mapper.writeValue(new File("employees." + fileSuffix), employees);
        String js2 = mapper.writeValueAsString(employees);
        logger.info("Printing serialized original object " + fileSuffix);
        System.out.println(js2);






    }



    public static void main(String[] args) throws IOException {

        ObjectMapper jsonMapper = new ObjectMapper();
        serialize(jsonMapper, "json");

        ObjectMapper xmlMapper = new XmlMapper();
        serialize(xmlMapper, "xml");


    }
}
