package com.poiji.deserialize;


import com.poiji.bind.Poiji;
import com.poiji.deserialize.model.byid.Employee2;

import com.poiji.deserialize.model.byname.EmployeeByName2;
import com.poiji.option.PoijiOptions;
import com.poiji.option.PoijiOptions.PoijiOptionsBuilder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.poiji.util.Data.unmarshallingDeserialize;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by passedbylove@gmail.com on 2018-11-15.
 */
@RunWith(Parameterized.class)
public class DeserializersByNameTagWithWhiteSpaceTest {

    private String path;
    private List<Employee2> expectedEmployess;
    private Class<?> expectedException;

    public DeserializersByNameTagWithWhiteSpaceTest(String path,
                                                    List<Employee2> expectedEmployess,
                                                    Class<?> expectedException) {
        this.path = path;
        this.expectedEmployess = expectedEmployess;
        this.expectedException = expectedException;
    }

    @Parameterized.Parameters(name = "{index}: ({0})={1}")
    public static Iterable<Object[]> queries() {
        return Arrays.asList(new Object[][]{
                {"src/test/resources/employees-tagwithwhitespace.xlsx", unmarshallingDeserialize(), null},
        });
    }

    @Test
    public void shouldMapExcelToJava2() {
        PoijiOptions options = PoijiOptionsBuilder.settings().datePattern("dd/MM/yyyy","yyyy-MM-dd","yyyy/MM/dd","yyyy\\MM\\dd").trimCellValue(true).trimTagName(true).build();
        try {
            List<EmployeeByName2> actualEmployees = Poiji.fromExcel(new FileInputStream(new File(path)), EmployeeByName2.class, options);
            System.out.println(actualEmployees);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldMapExcelToJava() {

        PoijiOptions options = PoijiOptionsBuilder.settings().datePattern("dd/MM/yyyy","yyyy-MM-dd","yyyy/MM/dd","\\yyyy\\MM\\dd").trimCellValue(true).trimTagName(true).build();
        try {
            List<EmployeeByName2> actualEmployees = Poiji.fromExcel(new File(path), EmployeeByName2.class,options);

            assertThat(actualEmployees, notNullValue());
            assertThat(actualEmployees.size(), not(0));
            assertThat(actualEmployees.size(), is(expectedEmployess.size()));

            EmployeeByName2 actualEmployee1 = actualEmployees.get(0);
            EmployeeByName2 actualEmployee2 = actualEmployees.get(1);
            EmployeeByName2 actualEmployee3 = actualEmployees.get(2);
            EmployeeByName2 actualEmployee4 = actualEmployees.get(3);

            Employee2 expectedEmployee1 = expectedEmployess.get(0);
            Employee2 expectedEmployee2 = expectedEmployess.get(1);
            Employee2 expectedEmployee3 = expectedEmployess.get(2);
            Employee2 expectedEmployee4 = expectedEmployess.get(3);

            assertThat(actualEmployee1.toString(), is(expectedEmployee1.toString()));
            assertThat(actualEmployee2.toString(), is(expectedEmployee2.toString()));
            assertThat(actualEmployee3.toString(), is(expectedEmployee3.toString()));
            assertThat(actualEmployee4.toString(), is(expectedEmployee4.toString()));
        } catch (Exception e) {
            if (expectedException == null) {
                fail(e.getMessage());
            } else {
                assertThat(e, instanceOf(expectedException));
            }
        }
    }

}
