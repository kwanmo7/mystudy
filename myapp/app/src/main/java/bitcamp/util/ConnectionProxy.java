package bitcamp.util;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.ShardingKey;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class ConnectionProxy implements Connection {

  private Connection ori;
  private ConnectionPool connectionPool;

  public ConnectionProxy(Connection ori, ConnectionPool connectionPool) {
    this.ori = ori;
    this.connectionPool = connectionPool;
  }

  @Override
  public void close() throws SQLException {
    if (ori.getAutoCommit()) {
      // DB 커넥션풀에 반납
      connectionPool.returnConnection(this);
    }
  }

  public void realClose() {
    try {
      ori.close();
    } catch (Exception e) {
    }
  }

  @Override
  public Statement createStatement() throws SQLException {
    return ori.createStatement();
  }

  @Override
  public PreparedStatement prepareStatement(String sql) throws SQLException {
    return ori.prepareStatement(sql);
  }

  @Override
  public CallableStatement prepareCall(String sql) throws SQLException {
    return ori.prepareCall(sql);
  }

  @Override
  public String nativeSQL(String sql) throws SQLException {
    return ori.nativeSQL(sql);
  }

  @Override
  public boolean getAutoCommit() throws SQLException {
    return ori.getAutoCommit();
  }

  @Override
  public void setAutoCommit(boolean autoCommit) throws SQLException {
    ori.setAutoCommit(autoCommit);
  }

  @Override
  public void commit() throws SQLException {
    ori.commit();
  }

  @Override
  public void rollback() throws SQLException {
    ori.rollback();
  }

  @Override
  public boolean isClosed() throws SQLException {
    return ori.isClosed();
  }

  @Override
  public DatabaseMetaData getMetaData() throws SQLException {
    return ori.getMetaData();
  }

  @Override
  public boolean isReadOnly() throws SQLException {
    return ori.isReadOnly();
  }

  @Override
  public void setReadOnly(boolean readOnly) throws SQLException {
    ori.setReadOnly(readOnly);
  }

  @Override
  public String getCatalog() throws SQLException {
    return ori.getCatalog();
  }

  @Override
  public void setCatalog(String catalog) throws SQLException {
    ori.setCatalog(catalog);
  }

  @Override
  public int getTransactionIsolation() throws SQLException {
    return ori.getTransactionIsolation();
  }

  @Override
  public void setTransactionIsolation(int level) throws SQLException {
    ori.setTransactionIsolation(level);
  }

  @Override
  public SQLWarning getWarnings() throws SQLException {
    return ori.getWarnings();
  }

  @Override
  public void clearWarnings() throws SQLException {
    ori.clearWarnings();
  }

  @Override
  public Statement createStatement(int resultSetType, int resultSetConcurrency)
      throws SQLException {
    return ori.createStatement(resultSetType, resultSetConcurrency);
  }

  @Override
  public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
      throws SQLException {
    return ori.prepareStatement(sql, resultSetType, resultSetConcurrency);
  }

  @Override
  public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)
      throws SQLException {
    return ori.prepareCall(sql, resultSetType, resultSetConcurrency);
  }

  @Override
  public Map<String, Class<?>> getTypeMap() throws SQLException {
    return ori.getTypeMap();
  }

  @Override
  public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
    ori.setTypeMap(map);
  }

  @Override
  public int getHoldability() throws SQLException {
    return ori.getHoldability();
  }

  @Override
  public void setHoldability(int holdability) throws SQLException {
    ori.setHoldability(holdability);
  }

  @Override
  public Savepoint setSavepoint() throws SQLException {
    return ori.setSavepoint();
  }

  @Override
  public Savepoint setSavepoint(String name) throws SQLException {
    return ori.setSavepoint(name);
  }

  @Override
  public void rollback(Savepoint savepoint) throws SQLException {
    ori.rollback(savepoint);
  }

  @Override
  public void releaseSavepoint(Savepoint savepoint) throws SQLException {
    ori.releaseSavepoint(savepoint);
  }

  @Override
  public Statement createStatement(int resultSetType, int resultSetConcurrency,
      int resultSetHoldability) throws SQLException {
    return ori.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
  }

  @Override
  public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
      int resultSetHoldability) throws SQLException {
    return ori.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
  }

  @Override
  public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
      int resultSetHoldability) throws SQLException {
    return ori.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
  }

  @Override
  public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
    return ori.prepareStatement(sql, autoGeneratedKeys);
  }

  @Override
  public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
    return ori.prepareStatement(sql, columnIndexes);
  }

  @Override
  public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
    return ori.prepareStatement(sql, columnNames);
  }

  @Override
  public Clob createClob() throws SQLException {
    return ori.createClob();
  }

  @Override
  public Blob createBlob() throws SQLException {
    return ori.createBlob();
  }

  @Override
  public NClob createNClob() throws SQLException {
    return ori.createNClob();
  }

  @Override
  public SQLXML createSQLXML() throws SQLException {
    return ori.createSQLXML();
  }

  @Override
  public boolean isValid(int timeout) throws SQLException {
    return ori.isValid(timeout);
  }

  @Override
  public void setClientInfo(String name, String value) throws SQLClientInfoException {
    ori.setClientInfo(name, value);
  }

  @Override
  public String getClientInfo(String name) throws SQLException {
    return ori.getClientInfo(name);
  }

  @Override
  public Properties getClientInfo() throws SQLException {
    return ori.getClientInfo();
  }

  @Override
  public void setClientInfo(Properties properties) throws SQLClientInfoException {
    ori.setClientInfo(properties);
  }

  @Override
  public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
    return ori.createArrayOf(typeName, elements);
  }

  @Override
  public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
    return ori.createStruct(typeName, attributes);
  }

  @Override
  public String getSchema() throws SQLException {
    return ori.getSchema();
  }

  @Override
  public void setSchema(String schema) throws SQLException {
    ori.setSchema(schema);
  }

  @Override
  public void abort(Executor executor) throws SQLException {
    ori.abort(executor);
  }

  @Override
  public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
    ori.setNetworkTimeout(executor, milliseconds);
  }

  @Override
  public int getNetworkTimeout() throws SQLException {
    return ori.getNetworkTimeout();
  }

  @Override
  public void beginRequest() throws SQLException {
    ori.beginRequest();
  }

  @Override
  public void endRequest() throws SQLException {
    ori.endRequest();
  }

  @Override
  public boolean setShardingKeyIfValid(ShardingKey shardingKey, ShardingKey superShardingKey,
      int timeout) throws SQLException {
    return ori.setShardingKeyIfValid(shardingKey, superShardingKey, timeout);
  }

  @Override
  public boolean setShardingKeyIfValid(ShardingKey shardingKey, int timeout) throws SQLException {
    return ori.setShardingKeyIfValid(shardingKey, timeout);
  }

  @Override
  public void setShardingKey(ShardingKey shardingKey, ShardingKey superShardingKey)
      throws SQLException {
    ori.setShardingKey(shardingKey, superShardingKey);
  }

  @Override
  public void setShardingKey(ShardingKey shardingKey) throws SQLException {
    ori.setShardingKey(shardingKey);
  }

  @Override
  public <T> T unwrap(Class<T> iface) throws SQLException {
    return ori.unwrap(iface);
  }

  @Override
  public boolean isWrapperFor(Class<?> iface) throws SQLException {
    return ori.isWrapperFor(iface);
  }
}
