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

package com.acmutv.botnet.tool.time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.concurrent.TimeUnit;

/**
 * A time duration model.
 * @author Giacomo Marciani {@literal <gmarciani@acm.org>}
 * @author Michele Porretta {@literal <mporretta@acm.org>}
 * @since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Duration {

  /**
   * The frequency amount of time.
   */
  private long amount;

  /**
   * The frequency time unit.
   */
  @NonNull
  private TimeUnit unit = TimeUnit.SECONDS;

  /**
   * Converts the duration in millis.
   * @return the millis duration.
   */
  public long toMillis() {
    return this.getUnit().toMillis(this.getAmount());
  }

  /**
   * Parses {@link Duration} from string.
   * @param string the string to parse.
   * @return the parsed {@link Duration}; null if cannot be parsed.
   */
  public static Duration valueOf(String string) {
    if (string == null) return null;
    String parts[] = string.split(":", 2);
    if (parts.length != 2) return null;
    long amount = Long.valueOf(parts[0]);
    TimeUnit unit = TimeUnit.valueOf(parts[1]);
    return new Duration(amount, unit);
  }

  @Override
  public String toString() {
    return String.format("%d:%s", this.getAmount(), this.getUnit());
  }
}
