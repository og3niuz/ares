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

package com.acmutv.botnet.core.analysis;

import com.acmutv.botnet.core.exception.BotAnalysisException;
import com.acmutv.botnet.core.report.Report;
import com.acmutv.botnet.core.report.SimpleReport;
import com.acmutv.botnet.tool.reflection.ReflectionManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple system analyzer.
 * @author Giacomo Marciani {@literal <gmarciani@acm.org>}
 * @author Michele Porretta {@literal <mporretta@acm.org>}
 * @since 1.0
 * @see SystemFeatures
 */
@Data
@AllArgsConstructor
public class SystemAnalyzer implements Analyzer {

  @NonNull
  private String name = SystemAnalyzer.class.getSimpleName();

  /**
   * Produces a {@link Report}.
   * @return the report produced.
   * @throws BotAnalysisException when analysis cannot be correctly executed.
   */
  @Override
  public Report makeReport() throws BotAnalysisException {
    SystemFeatures features = SystemFeatures.getLocal();
    Map<String,Object> attributes;
    try {
      attributes = ReflectionManager.getAttributes(SystemFeatures.class, features);
    } catch (IntrospectionException | InvocationTargetException | IllegalAccessException exc) {
      attributes = new HashMap<>();
    }
    return new SimpleReport(attributes);
  }
}
