/*
 * Copyright 2014 Red Hat, Inc.
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

<<<<<<< HEAD
import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.json.JsonArray;
=======
import io.vertx.codegen.annotations.VertxGen;
>>>>>>> Added back the class JDBCAuth to be backward compatible. Note that the whole class is marked as deprecated to encourage people to switch to JDBCAuthencation / JDBCAuthorization
import io.vertx.ext.auth.AuthProvider;
import io.vertx.ext.auth.jdbc.impl.JDBCAuthenticationImpl;
import io.vertx.ext.jdbc.JDBCClient;

/**
 * Factory interface for creating {@link io.vertx.ext.auth.AuthProvider} instances that use the Vert.x JDBC client.
 *
 * By default the hashing strategy is SHA-512. If you're already running in production this is backwards
 * compatible, however for new deployments or security upgrades it is recommended to use the PBKDF2 strategy
 * as it is the current OWASP recommendation for password storage.
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@VertxGen
public interface JDBCAuthentication extends AuthProvider {

  /**
   * Create a JDBC auth provider implementation
   *
   * @param client  the JDBC client instance
   * @param options authentication options
   * @param hashStrategy
   * @return  the auth provider
   */
<<<<<<< HEAD
<<<<<<< HEAD:vertx-auth-jdbc/src/main/java/io/vertx/ext/auth/jdbc/JDBCAuthenticationProvider.java
  static JDBCAuthenticationProvider create(JDBCClient client, JDBCHashStrategy hashStrategy, JDBCAuthenticationOptions options) {
    return new JDBCAuthenticationProviderImpl(client, hashStrategy, options);
  }

  /**
=======
  static JDBCAuthentication create(Vertx vertx, JDBCClient client) {
    return new JDBCAuthenticationImpl(vertx, client);
  }

  /**
   * Set the authentication query to use. Use this if you want to override the default authentication query.
   * @deprecated replaced by {@link JDBCAuthenticationOptions}
   * @param authenticationQuery  the authentication query
   * @return  a reference to this for fluency
   */
  @Fluent
  @Deprecated
  JDBCAuthentication setAuthenticationQuery(String authenticationQuery);

  /**
   * Set the hash strategy to use. Use this if you want override the default hash strategy
   * @deprecated replaced by {@link JDBCAuthenticationOptions}
   * @param strategy  the strategy
   * @return a reference to this for fluency
   */
  @GenIgnore
  @Deprecated
  JDBCAuthentication setHashStrategy(JDBCHashStrategy strategy);

  /**
>>>>>>> updated code based on comments from Paulo::vertx-auth-jdbc/src/main/java/io/vertx/ext/auth/jdbc/JDBCAuthentication.java
   * Compute the hashed password given the unhashed password and the salt without nonce
   *
   * The implementation relays to the JDBCHashStrategy provided.
   *
   * @param password  the unhashed password
   * @param salt  the salt
   * @return  the hashed password
   */
  default String computeHash(String password, String salt) {
    return computeHash(password, salt, -1);
  }

  /**
   * Compute the hashed password given the unhashed password and the salt
   *
   * The implementation relays to the JDBCHashStrategy provided.
   *
   * @param password  the unhashed password
   * @param salt  the salt
   * @param version the nonce version to use
   * @return  the hashed password
   */
  String computeHash(String password, String salt, int version);

  /**
   * Compute a salt string.
   *
   * The implementation relays to the JDBCHashStrategy provided.
   *
   * @return a non null salt value
   */
  String generateSalt();

  /**
   * Provide a application configuration level on hash nonce's as a ordered list of
   * nonces where each position corresponds to a version.
   *
   * The nonces are supposed not to be stored in the underlying jdbc storage but to
   * be provided as a application configuration. The idea is to add one extra variable
   * to the hash function in order to make breaking the passwords using rainbow tables
   * or precomputed hashes harder. Leaving the attacker only with the brute force
   * approach.
   *
   * The implementation relays to the JDBCHashStrategy provided.
   *
   * @deprecated replaced by {@link JDBCAuthenticationOptions}
   * @param nonces a List of non null Strings.
   * @return a reference to this for fluency
   */
  @Fluent
  @Deprecated
  JDBCAuthentication setNonces(JsonArray nonces);
=======
  static JDBCAuthentication create(JDBCClient client, JDBCHashStrategy hashStrategy, JDBCAuthenticationOptions options) {
    return new JDBCAuthenticationImpl(client, hashStrategy, options);
  }

>>>>>>> Added back the class JDBCAuth to be backward compatible. Note that the whole class is marked as deprecated to encourage people to switch to JDBCAuthencation / JDBCAuthorization
}
