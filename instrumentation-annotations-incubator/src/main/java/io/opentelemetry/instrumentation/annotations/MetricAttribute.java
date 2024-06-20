/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.instrumentation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation marks that a parameter of a method or constructor annotated with {@link Timed} or
 * {@link Counted} should be added as an attribute to the instrument.
 *
 * <p>Application developers can use this annotation to signal OpenTelemetry auto-instrumentation
 * that the attribute should be created.
 *
 * <p>If you are a library developer, then probably you should NOT use this annotation, because it
 * is non-functional without the OpenTelemetry auto-instrumentation agent, or some other annotation
 * processor.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface MetricAttribute {

  /**
   * Optional name of the attribute.
   *
   * <p>If not specified and the code is compiled using the `{@code -parameters}` argument to
   * `javac`, the parameter name will be used instead. If the parameter name is not available, e.g.,
   * because the code was not compiled with that flag, the attribute will be ignored.
   *
   * <p>Warning: be careful to fill it because it might cause an explosion of the cardinality on
   * your metric
   */
  String value() default "";
}