package pl.sda.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;


public class jsonMapperTest {

    @Test
    public void test1() throws IOException {
        String jsonToDeserialize = "{\"firstName\":\"Jan\",\"lastName\":\"Kowalski\",\"addresses\":{\"Work\":{\"street\":\"Mokotowska\",\"code\":\"32-1232\",\"city\":\"Lublin\"},\"Home\":{\"street\":\"Polna\",\"code\":\"12-122\",\"city\":\"Poznań\"}},\"childrenNames\":[\"Marek\",\"Zosia\"]}\n";

        ObjectMapper mapper = new ObjectMapper();

        User user = mapper.readValue(jsonToDeserialize, User.class);

        Assert.assertEquals("Jan", user.getFirstName());

        Assert.assertNotNull(user.getChildrenNames());
        Assert.assertTrue(user.getChildrenNames() != null);

        Assert.assertTrue(user.getChildrenNames().size() == 2);
        Assert.assertEquals(Arrays.asList("Marek", "Zosia"), user.getChildrenNames());
    }

    public void test2() throws IOException {
        User user = new UserBuilder()
                .withFirstName("Janek")
                .withLastName("Kaczmarek")
                .withAddresses("Work", new AddressBuilder().withCity("Wawa").withCode("11-111").withStreet("Nowa").build())
                .withAddresses("Home", new AddressBuilder().withCity("Wawa").withCode("11-111").withStreet("Domowa").build())
                .withChildrenNames(Arrays.asList("Tomek", "Ola"))
                .build();

        ObjectMapper mapper = new ObjectMapper();

        String serializedObject = mapper.writeValueAsString(user);

        Assert.assertTrue(serializedObject.contains("\"firstName\":\"Janek\""));
        Assert.assertTrue(serializedObject.contains("Kaczmarek"));
        Assert.assertTrue(serializedObject.contains("Ola"));
    }

}
