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

package com.acmutv.botnet.service;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;

/**
 * This class realizes JUnit tests for {@link HttpService}.
 * @author Giacomo Marciani {@literal <gmarciani@acm.org>}
 * @author Michele Porretta {@literal <mporretta@acm.org>}
 * @since 1.0
 * @see HttpService
 */
public class HttpTest {

  @Before
  public void setup() {
    org.junit.Assume.assumeTrue(ConnectionService.checkConnection());
  }

  /**
   * Tests the HTTP GET without Proxy.
   * @throws ParseException when invalid weburl.
   * @throws IOException when HTTP GET error.
   */
  @Test
  public void testGET() throws ParseException, IOException {
    final URL url = new URL("http://www.google.com");
    final int expected = 200;
    final int actual = HttpService.makeGET(url);
    assertEquals(expected, actual);
  }

  /**
   * Tests the HTTP GET with Proxy.
   * @throws ParseException when invalid weburl or Proxy.
   * @throws IOException when HTTP GET error.
   */
  @Test
  public void testGETWithProxy() throws ParseException, IOException {
    final URL url = new URL("http://www.google.com");
    final Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("104.28.5.228", 80));
    final int expected = 400;
    final int actual = HttpService.makeGETWithProxy(url, proxy);
    assertEquals(expected, actual);
  }

}