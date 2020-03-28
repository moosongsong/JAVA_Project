

public class Common {
	
	public static final char STX = '\u0002';
	public static final char ETX = '\u0003';
	public static final char EOT = '\u0004';
	
	public static final int STUDENT_NAME_LEN = 8;
	public static final int STUDENT_ID_LEN = 8;
	public static final int STUDENT_MAJOR_LEN = 20;
	public static final int STUDENT_SCORE_LEN = 4;
	
	
	public static boolean isEOT(StringBuffer sb) {
		return (sb.indexOf("" + EOT) == 0);
	}
	
	public static boolean isPacketValidated(StringBuffer sb) {
		return !((sb.indexOf("" + STX) < 0) || (sb.indexOf("" + ETX) < 0));
	}
}
