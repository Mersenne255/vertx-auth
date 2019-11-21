/*
 * Copyright 2015 Red Hat, Inc.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */
package io.vertx.ext.auth.jdbc;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.annotations.Fluent;
import io.vertx.core.json.JsonObject;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import io.vertx.ext.auth.AuthOptions;
>>>>>>> updated code based on comments from Paulo:
import io.vertx.ext.jdbc.JDBCClient;
=======
>>>>>>> Added back the class JDBCAuth to be backward compatible. Note that the whole class is marked as deprecated to encourage people to switch to JDBCAuthencation / JDBCAuthorization

/**
 * Options configuring JDBC authentication.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
@DataObject(generateConverter = true)
<<<<<<< HEAD
<<<<<<< HEAD
public class JDBCAuthenticationOptions {

  /**
   * The default query to be used for authentication
   */
  private final static String DEFAULT_AUTHENTICATE_QUERY = "SELECT PASSWORD, PASSWORD_SALT FROM USER WHERE USERNAME = ?";

  private String authenticationQuery;

  public JDBCAuthenticationOptions() {
    this.authenticationQuery = DEFAULT_AUTHENTICATE_QUERY;
=======
public class JDBCAuthenticationOptions implements AuthOptions {
=======
public class JDBCAuthenticationOptions {
>>>>>>> Added back the class JDBCAuth to be backward compatible. Note that the whole class is marked as deprecated to encourage people to switch to JDBCAuthencation / JDBCAuthorization

  /**
   * The default query to be used for authentication
   */
  private final static String DEFAULT_AUTHENTICATE_QUERY = "SELECT PASSWORD, PASSWORD_SALT FROM USER WHERE USERNAME = ?";
  
  private String authenticationQuery;
  
  public JDBCAuthenticationOptions() {
<<<<<<< HEAD
    this.shared = true;
    this.config = null;
  }

  public JDBCAuthenticationOptions(JDBCAuthenticationOptions that) {
    shared = that.shared;
    datasourceName = that.datasourceName;
    config = that.config != null ? that.config.copy() : null;
>>>>>>> updated code based on comments from Paulo:
=======
    this.authenticationQuery = DEFAULT_AUTHENTICATE_QUERY;
>>>>>>> Added back the class JDBCAuth to be backward compatible. Note that the whole class is marked as deprecated to encourage people to switch to JDBCAuthencation / JDBCAuthorization
  }

  public JDBCAuthenticationOptions(JsonObject json) {
    this();
    JDBCAuthenticationOptionsConverter.fromJson(json, this);
  }

<<<<<<< HEAD
<<<<<<< HEAD
=======
  @Override
  public JDBCAuthenticationOptions clone() {
    return new JDBCAuthenticationOptions(this);
  }

  @Override
  public JDBCAuthentication createProvider(Vertx vertx) {
    JDBCClient client;
    if (shared) {
      if (datasourceName != null) {
        client = JDBCClient.createShared(vertx, config, datasourceName);
      } else {
        client = JDBCClient.createShared(vertx, config);
      }
    } else {
      client = JDBCClient.createNonShared(vertx, config);
    }
    JDBCAuthentication auth = JDBCAuthentication.create(vertx, client);
    if (authenticationQuery != null) {
      auth.setAuthenticationQuery(authenticationQuery);
    }
    return auth;
  }

  public boolean isShared() {
    return shared;
  }

  /**
   * Set whether the JDBC client is shared or non shared.
   *
   * @param shared the sharing mode
   * @return a reference to this, so the API can be used fluently
   */
  public JDBCAuthenticationOptions setShared(boolean shared) {
    this.shared = shared;
    return this;
  }

  public String getDatasourceName() {
    return datasourceName;
  }

  /**
   * Set the data source name to use, only use in shared mode.
   *
   * @param datasourceName the data source name
   * @return a reference to this, so the API can be used fluently
   */
  public JDBCAuthenticationOptions setDatasourceName(String datasourceName) {
    this.datasourceName = datasourceName;
    return this;
  }

  public JsonObject getConfig() {
    return config;
  }

  /**
   * The configuration of the JDBC client: refer to the Vert.x JDBC Client configuration.
   *
   * @param config
   * @return a reference to this, so the API can be used fluently
   */
  public JDBCAuthenticationOptions setConfig(JsonObject config) {
    this.config = config;
    return this;
  }

>>>>>>> updated code based on comments from Paulo:
=======
>>>>>>> Added back the class JDBCAuth to be backward compatible. Note that the whole class is marked as deprecated to encourage people to switch to JDBCAuthencation / JDBCAuthorization
  public String getAuthenticationQuery() {
    return authenticationQuery;
  }

  /**
   * Set the authentication query to use. Use this if you want to override the
   * default authentication query.
   *
   * @param authenticationQuery the authentication query
   * @return a reference to this, so the API can be used fluently
   */
  @Fluent
  public JDBCAuthenticationOptions setAuthenticationQuery(String authenticationQuery) {
    this.authenticationQuery = authenticationQuery;
    return this;
  }
<<<<<<< HEAD
  
=======

>>>>>>> updated code based on comments from Paulo:
}
