package uk.co.automatictester.lightning.params;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import uk.co.automatictester.lightning.params.validators.BooleanValidator;
import uk.co.automatictester.lightning.params.validators.FileValidator;

@Parameters(separators = "=")
public class CmdLineParams {

    @Parameter(names = "-xml", description = "Lightning XML config file", required = true, validateWith = FileValidator.class)
    private String xmlFile;

    @Parameter(names = "-csv", description = "JMeter CSV output file", required = true, validateWith = FileValidator.class)
    private String csvFile;

    @Parameter(names = "-skipSchemaValidation", description = "Skip XML schema validation", required = false, validateWith = BooleanValidator.class)
    private String skipSchemaValidation;

    public String getXmlFile() {
        return xmlFile;
    }

    public String getCSVFile() {
        return csvFile;
    }

    public boolean skipSchemaValidation() {
        return Boolean.parseBoolean(skipSchemaValidation);
    }

}