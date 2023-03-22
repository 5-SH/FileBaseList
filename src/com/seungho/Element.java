package com.seungho;

import java.io.*;

public class Element {
  private int index;
  private int value;

  public Element(int index, int value) {
    this.index = index;
    this.value = value;
  }

  static Element readFields(RandomAccessFile raf, int idx) throws Exception {
    raf.seek(0);
    int len = raf.readInt();
    if (idx >= len) throw new Exception("out of range");

    long header = 4;
    raf.seek(header + (idx * 8));

    return new Element(raf.readInt(), raf.readInt());
  }

  static void writeFields(RandomAccessFile raf, int value) throws Exception {
    raf.seek(0);
    int len = raf.readInt();

    long header = 4;
    raf.seek(header + (len * 8));
    raf.writeInt(len);
    raf.writeInt(value);

    raf.seek(0);
    raf.writeInt(len + 1);
  }

  public int getIndex() {
    return index;
  }

  public int getValue() {
    return value;
  }
}
