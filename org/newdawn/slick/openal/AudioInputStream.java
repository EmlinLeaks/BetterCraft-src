package org.newdawn.slick.openal;

import java.io.IOException;

interface AudioInputStream {
  int getChannels();
  
  int getRate();
  
  int read() throws IOException;
  
  int read(byte[] paramArrayOfbyte) throws IOException;
  
  int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException;
  
  boolean atEnd();
  
  void close() throws IOException;
}


/* Location:              C:\Users\emlin\Desktop\BetterCraft.jar!\org\newdawn\slick\openal\AudioInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */