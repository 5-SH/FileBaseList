package com.seungho;

import java.io.*;

public class BigList implements FileBaseList {

  private File path;
  private RandomAccessFile raf;

  public BigList(File path) throws IOException {
    this.path = path;
    path.createNewFile();

    raf = new RandomAccessFile(path.getPath(), "rw");
    raf.writeInt(0);
  }

  @Override
  public void add(int val) throws Exception {
    Element.writeFields(raf, val);
  }

  @Override
  public int get(int idx) throws Exception {
    Element elem = Element.readFields(this.raf, idx);
    return elem.getValue();
  }

  @Override
  public int length() throws Exception {
    long pos = this.raf.getFilePointer();
    this.raf.seek(0);
    int len = this.raf.readInt();
    this.raf.seek(pos);

    return len;
  }

  @Override
  public void flush() throws Exception {

  }

  @Override
  public void close() throws Exception {
    this.raf.close();
    if (path.exists()) path.delete();
  }
}
