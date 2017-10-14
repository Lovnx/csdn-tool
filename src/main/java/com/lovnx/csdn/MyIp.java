package com.lovnx.csdn;

public class MyIp {
	 
    private String address;
     
    private String port;
    
    public MyIp() {
		super();
	}

	public MyIp(String address, String port) {
		super();
		this.address = address;
		this.port = port;
	}

	public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }
 
    public String getPort() {
        return port;
    }
 
    public void setPort(String port) {
        this.port = port;
    }
}