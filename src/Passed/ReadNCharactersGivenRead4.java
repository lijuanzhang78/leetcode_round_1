package Passed;

public class ReadNCharactersGivenRead4 {
	 char[] buffer = new char[4];
     int readbytes = 0;
     boolean eof = false;
     
     while(!eof && readbytes < n) {
         int sz = read4(buffer);
         if (sz < 4) eof = true;
         int bytes = Math.min(n-readbytes, sz);
         System.arraycopy(buffer, 0, buf, readbytes, bytes);
         readbytes += bytes;
     }
     
     return readbytes;
 }
}
