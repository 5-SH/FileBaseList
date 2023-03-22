package com.seungho;

import java.io.File;

public interface FileBaseList {

  public void add(int value) throws Exception;

  public int get(int index) throws Exception;

  public int length() throws Exception;

  public void flush() throws Exception;

  public void close() throws Exception;

}
