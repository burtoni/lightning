package uk.co.automatictester.lightning;

import org.testng.annotations.Test;

public class XMLSchemaValidatorTest {

    @Test
    public void testValidateValidXML() {
        new XMLSchemaValidator().validate("src/test/resources/xml/XMLSchemaValidatorTest_valid.xml");
    }
}