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

package com.acmutv.botnet.config;

import com.acmutv.botnet.core.control.Controller;
import com.acmutv.botnet.tool.net.HttpProxy;
import com.acmutv.botnet.tool.time.Interval;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.Yaml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * The app configuration model.
 * @author Giacomo Marciani {@literal <gmarciani@acm.org>}
 * @author Michele Porretta {@literal <mporretta@acm.org>}
 * @since 1.0
 * @see Yaml
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppConfiguration {

  /**
   * Default value for {@code cnfInfo}.
   */
  public static final boolean CNF_INFO = true;

  /**
   * Default value for {@code tgtInfo} (true).
   */
  public static final boolean TGT_INFO = true;

  /**
   * Default value for {@code sysInfo}.
   */
  public static final boolean SYS_INFO = true;

  /**
   * Default value for {@code netInfo} (true).
   */
  public static final boolean NET_INFO = true;

  /**
   * Default value for {@code polling} (10-10 seconds).
   */
  public static final Interval POLLING = new Interval(10, 10, TimeUnit.SECONDS);

  /**
   * Default value for {@code reconnections} (3).
   */
  public static final Long RECONNECTIONS = 3L;

  /**
   * Default value for {@code reconnectionWait} (10-10 seconds).
   */
  public static final Interval RECONNECTION_WAIT = new Interval(10,10, TimeUnit.SECONDS);

  /**
   * Default value for {@code proxy} ({@code HttpProxy.NONE}).
   */
  public static final HttpProxy PROXY = HttpProxy.NONE;

  /**
   * Default value for {@code sleep} (null)
   */
  public static final String SLEEP = null;

  /**
   * Default value for {@code authentication} (null)
   */
  public static final Map<String,String> AUTHENTICATION = new HashMap<>();

  /**
   * Default value for {@code controllers} (empty list).
   */
  public static final List<Controller> CONTROLLERS = new ArrayList<>();

  /**
   * If true, the bot sends configuration information to the controller.
   * Default is {@code CNF_INFO}.
   */
  private boolean cnfInfo = CNF_INFO;

  /**
   * If true, the bot sends attack targets information to the controller.
   * Default is {@code TGT_INFO}.
   */
  private boolean tgtInfo = TGT_INFO;

  /**
   * If true, the bot sends system information to the controller.
   * Default is {@code SYS_INFO}.
   */
  private boolean sysInfo = SYS_INFO;

  /**
   * If true, the bot sends network information to the controller.
   * Default is {@code NET_INFO}.
   */
  private boolean netInfo = NET_INFO;

  /**
   * The bot polls controllers for command with a random period within this interval.
   * Default is {@code POLLING}.
   */
  private Interval polling = POLLING;

  /**
   * The maximum number of connection errors tolerated when connecting to a controller.
   * Default is {@code RECONNECTIONS}.
   */
  private Long reconnections = RECONNECTIONS;

  /**
   * The bot tries to reconnect to a controller waiting a random period within this interval.
   * Default is {@code RECONNECTION_WAIT}.
   */
  private Interval reconnectionWait = RECONNECTION_WAIT;

  /**
   * The proxy server to contact the controllers through.
   * Default is {@code PROXY}.
   */
  private HttpProxy proxy = PROXY;

  /**
   * The cron expression that sets up the sleep mode.
   * Default is {@code SLEEP}.
   */
  private String sleep = SLEEP;

  /**
   * The controller authentication fields.
   * Default is {@code AUTHENTICATION}.
   */
  private Map<String,String> authentication = AUTHENTICATION;

  /**
   * The list of controllers to contact.
   * Default is {@code CONTROLLERS}.
   */
  private List<Controller> controllers = CONTROLLERS;

  /**
   * Constructs a configuration as a copy of the one specified.
   * @param other the configuration to copy.
   */
  public AppConfiguration(AppConfiguration other) {
    this.copy(other);
  }

  /**
   * Copies the settings of the configuration specified.
   * @param other the configuration to copy.
   */
  public void copy(AppConfiguration other) {
    this.cnfInfo = other.cnfInfo;
    this.tgtInfo = other.tgtInfo;
    this.sysInfo = other.sysInfo;
    this.netInfo = other.netInfo;
    this.polling = other.polling;
    this.reconnections = other.reconnections;
    this.reconnectionWait = other.reconnectionWait;
    this.proxy = other.proxy;
    this.sleep = other.sleep;
    this.authentication = other.authentication;
    this.controllers = other.controllers;
  }

  /**
   * Restores the default configuration settings.
   */
  public void toDefault() {
    this.cnfInfo = CNF_INFO;
    this.tgtInfo = TGT_INFO;
    this.sysInfo = SYS_INFO;
    this.netInfo = NET_INFO;
    this.polling = POLLING;
    this.reconnections = RECONNECTIONS;
    this.reconnectionWait = RECONNECTION_WAIT;
    this.proxy = PROXY;
    this.sleep = SLEEP;
    this.authentication = AUTHENTICATION;
    this.controllers = CONTROLLERS;
  }

}
