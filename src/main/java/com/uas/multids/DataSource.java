package com.uas.multids;
import java.lang.annotation.*;
@Target({ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    /**
     * @return datasource name
     */
    String value();
}
