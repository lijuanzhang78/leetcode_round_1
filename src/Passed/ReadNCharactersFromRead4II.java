package Passed;

public class ReadNCharactersFromRead4II {
	public class Solution extends Reader4 {
	    /**
	     * @param buf Destination buffer
	     * @param n   Maximum number of characters to read
	     * @return    The number of characters read
	     */
	    Queue<Character> remain = new LinkedList<Character>(); 
	     
	    public int read(char[] buf, int n) {
	        int i = 0; 
	        while (i < n && !remain.isEmpty()) {
	            buf[i++] = remain.poll();
	        }
	        for(; i < n; i+=4) {
	            char[] tmp = new char[4];
	            int len = read4(tmp);
	            // 如果读到字符多于我们需要的字符，需要暂存这些多余字符
	            if(len > n - i){
	                System.arraycopy(tmp, 0, buf, i, n - i);
	                // 把多余的字符存入队列中
	                for(int j = n - i; j < len; j++){
	                    remain.offer(tmp[j]);
	                }
	            // 如果读到的字符少于我们需要的字符，直接拷贝
	            } else {
	                System.arraycopy(tmp, 0, buf, i, len);
	            }
	            // 同样的，如果读不满4个，说明数据已经读完，返回总所需长度和目前已经读到的长度的较小的
	            if(len < 4) return Math.min(i + len, n);
	        }
	        // 如果到这里，说明都是完美读取，直接返回n
	        return n;
	    }
	}

}
