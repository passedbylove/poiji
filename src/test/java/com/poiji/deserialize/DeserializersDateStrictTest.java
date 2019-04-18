package com.poiji.deserialize;

import com.poiji.bind.Poiji;
import com.poiji.deserialize.model.byid.Employee2;
import com.poiji.option.PoijiOptions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class DeserializersDateStrictTest {
    private final String path;

    public DeserializersDateStrictTest(String path) {
        this.path = path;
    }

    @Parameterized.Parameters(name = "{index}: ({0})={1}")
    public static Iterable<Object[]> queries() throws Exception {
        return Arrays.asList(new Object[][]{
                {"src/test/resources/date_strict.xlsx"},
                {"src/test/resources/date_strict.xls"}});
    }

    @Test
    public void strictTrue() {
        try {
            PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings().datePattern("yyyy-MM-dd","yyyy年MM月dd日","yyyy/MM/dd","dd-MM-yyyy","dd/MM/yyyy").build();

            List<Employee2> actualEmployees = Poiji.fromExcel(new File(path), Employee2.class, options);

            assertThat(actualEmployees, notNullValue());
            assertThat(actualEmployees.size(), not(0));

        } catch (Exception e) {

        }
    }
}
