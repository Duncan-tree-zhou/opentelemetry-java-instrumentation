/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.javaagent.instrumentation.instrumentationannotations.v2_6.timed;

import io.opentelemetry.instrumentation.annotations.Timed;
import java.util.concurrent.TimeUnit;

public class TimedExample {
  public static final String METRIC_NAME = "name.duration";
  public static final String METRIC_DESCRIPTION = "I am the description.";
  public static final String RETURN_STRING = "I am a return string.";

  @Timed(METRIC_NAME)
  public void exampleWithName() {}

  @Timed(value = "example.with.description.duration", description = METRIC_DESCRIPTION)
  public void exampleWithDescription() {}

  @Timed(value = "example.with.unit.duration", unit = TimeUnit.MILLISECONDS)
  public void exampleWithUnit() throws InterruptedException {
    Thread.sleep(2000);
  }

  @Timed(
      value = "example.with.attributes.duration",
      additionalAttributes = {"key1", "value1", "key2", "value2"})
  public void exampleWithAdditionalAttributes1() {}

  @Timed(
      value = "example.with.attributes2.duration",
      additionalAttributes = {"key1", "value1", "key2", "value2", "key3"})
  public void exampleWithAdditionalAttributes2() {}

  @Timed("example.ignore.duration")
  public void exampleIgnore() {}

  @Timed("example.with.exception.duration")
  public void exampleWithException() {
    throw new IllegalStateException("test");
  }

  @Timed(value = "example.with.return.duration", returnValueAttribute = "returnValue")
  public ReturnObject exampleWithReturnValueAttribute() {
    return new ReturnObject();
  }

  public static class ReturnObject {
    @Override
    public String toString() {
      return RETURN_STRING;
    }
  }
}