package uk.co.automatictester.lightning.readers;

import org.testng.annotations.Test;
import uk.co.automatictester.lightning.data.PerfMonDataEntries;
import uk.co.automatictester.lightning.exceptions.CSVFileIOException;
import uk.co.automatictester.lightning.exceptions.CSVFileNoTransactionsException;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static uk.co.automatictester.lightning.data.TestData.*;

public class PerfMonDataEntriesReaderTest {

    @Test
    public void verifyReadMethod() {
        PerfMonDataEntries perfMonDataEntries = new PerfMonDataReader().getDataEntires(CSV_2_ENTRIES);
        assertThat(perfMonDataEntries, hasItem(CPU_ENTRY_1));
        assertThat(perfMonDataEntries, hasItem(CPU_ENTRY_2));
    }

    @Test(expectedExceptions = CSVFileIOException.class)
    public void verifyReadMethodIOException() {
        new PerfMonDataReader().getDataEntires(CSV_NONEXISTENT);
    }

    @Test(expectedExceptions = CSVFileNoTransactionsException.class)
    public void verifyReadMethodNoTransactionsException() {
        new PerfMonDataReader().getDataEntires(CSV_0_ENTRIES);
    }

}