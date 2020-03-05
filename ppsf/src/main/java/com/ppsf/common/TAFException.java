package com.ppsf.common;

public class TAFException  {

	private static final String FAILED ="Failed";
	private static final String SCRIPT ="Script";
	private static final String ENVIRONMENT ="Environment";
	private static final String DATA ="Data";


	public static class GENERAL_SCRIPT_ERROR extends RuntimeException{
		private static final long serialVersionUID = 1L;
		public GENERAL_SCRIPT_ERROR(String msg) {
			super(msg);
		}
		public String getType() {
			return SCRIPT;
		}
	}
	
	public static class APPLICATION_DOWN extends RuntimeException{
		private static final long serialVersionUID = 1L;
		public APPLICATION_DOWN(String msg) {
			super(msg);
		}
		public String getType() {
			return ENVIRONMENT;
		}
	}

	public static class INVALID_DATA extends RuntimeException{
		private static final long serialVersionUID = 1L;
		public INVALID_DATA(String msg) {
			super(msg);
		}
		public String getType() {
			return DATA;
		}
	}

	public static class EXPECTED_OBJECT_NOT_FOUND extends RuntimeException{
		private static final long serialVersionUID = 1L;
		public EXPECTED_OBJECT_NOT_FOUND(String msg) {
			super(msg);
		}
		public String getType() {
			return FAILED;
		}
	}

	public static class EXPECTED_PAGE_NOT_FOUND extends RuntimeException{
		private static final long serialVersionUID = 1L;
		public EXPECTED_PAGE_NOT_FOUND(String msg) {
			super(msg);
		}
		public String getType() {
			return FAILED;
		}
	}

	
}
