/*
  The MIT License (MIT)

  Copyright (c) 2016 Giacomo Marciani and Michele Porretta

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:


  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.


  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
 */

package com.acmutv.botnet.config.serial;

import com.acmutv.botnet.config.AppConfiguration;
import com.acmutv.botnet.core.control.Controller;
import com.acmutv.botnet.core.control.serial.ControllerDeserializer;
import com.acmutv.botnet.core.control.serial.ControllerSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.EqualsAndHashCode;

/**
 * The JSON constructor for {@link AppConfiguration}.
 * @author Giacomo Marciani {@literal <gmarciani@acm.org>}
 * @author Michele Porretta {@literal <mporretta@acm.org>}
 * @since 1.0
 * @see AppConfiguration
 * @see AppConfigurationSerializer
 * @see AppConfigurationDeserializer
 */
@EqualsAndHashCode(callSuper = true)
public class AppConfigurationJsonMapper extends ObjectMapper {

  /**
   * Initializes the JSON constructor.
   */
  public AppConfigurationJsonMapper() {
    super();
    SimpleModule module = new SimpleModule();
    module.addSerializer(AppConfiguration.class, AppConfigurationSerializer.getInstance());
    module.addSerializer(Controller.class, ControllerSerializer.getInstance());
    module.addDeserializer(AppConfiguration.class, AppConfigurationDeserializer.getInstance());
    module.addDeserializer(Controller.class, ControllerDeserializer.getInstance());
    super.registerModule(module);
    super.enable(SerializationFeature.INDENT_OUTPUT);
  }
}
