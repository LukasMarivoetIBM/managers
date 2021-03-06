/*
 * Licensed Materials - Property of IBM
 * 
 * (c) Copyright IBM Corp. 2019.
 */
package dev.galasa.linux;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dev.galasa.framework.spi.ValidAnnotatedFields;
import dev.galasa.linux.internal.LinuxManagerField;

/**
 * Represents a zOS Image that has been provisioned for the test
 * 
 * <p>
 * Used to populate a {@link ILinuxImage} field
 * </p>
 * 
 * @author Michael Baylis
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@LinuxManagerField
@ValidAnnotatedFields({ ILinuxImage.class })
public @interface LinuxImage {

    /**
     * The tag of the Linux Image this variable is to be populated with
     */
    String imageTag() default "PRIMARY";

    /**
     * The operating system of the Linux image
     * 
     * @return
     */
    OperatingSystem operatingSystem() default OperatingSystem.any;

    /**
     * Capabilities required of this Linux Image, if any.
     */
    String[] capabilities() default {};

    /**
     * Set a variable prefix to be filled in for this zOS Image TODO: ****** TO BE
     * SPECED OUT FURTHER *****
     */
    String variablePrefix() default "";
}
