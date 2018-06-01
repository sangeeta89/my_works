package excelMagic.excelMagic;

public class ConfigData {

	String test;
	String runFlag;
	public String getTestKey() {
		return test;
	}
	public void setTestKey(String testKey) {
		this.test = testKey;
	}
	public String getRunFlag() {
		return runFlag;
	}
	public void setRunFlag(String runFlag) {
		this.runFlag = runFlag;
	}
	@Override
	public String toString() {
		return "ConfigData [test=" + test + ", runFlag=" + runFlag + "]";
	}
	
	
}
