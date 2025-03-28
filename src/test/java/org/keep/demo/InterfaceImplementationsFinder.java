package org.keep.demo;

import org.junit.jupiter.api.Test;
import org.keep.demo.etd.IErrorType;

import java.lang.reflect.Modifier;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InterfaceImplementationsFinder {

    @Test
    public void durationCompare() {

            Date validDate = new Date(System.currentTimeMillis() + Duration.ofDays(1).toMillis());
            System.out.println(Duration.ofMillis(validDate.getTime()).toSeconds());
    }
}
