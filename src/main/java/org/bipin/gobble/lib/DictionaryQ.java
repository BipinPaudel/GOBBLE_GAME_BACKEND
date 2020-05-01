package org.bipin.gobble.lib;

import javax.enterprise.inject.Stereotype;
import javax.inject.Qualifier;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author bipin on 2020-05-01 15:50
 */
@Stereotype
@Inherited
@Target( { TYPE, METHOD, PARAMETER, FIELD })
@Retention(RUNTIME)
public @interface DictionaryQ {
}
