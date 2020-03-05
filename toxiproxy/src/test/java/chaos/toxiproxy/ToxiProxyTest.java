package chaos.toxiproxy;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.step.WsStep;

import eu.rekawek.toxiproxy.Proxy;
import eu.rekawek.toxiproxy.ToxiproxyClient;
import eu.rekawek.toxiproxy.model.ToxicDirection;

public class ToxiProxyTest {

	ToxiproxyClient client;
	Proxy httpProxy;
	Proxy httpBackendProxy;
		
	@BeforeMethod
	public void setup() throws Exception {
		Runtime.getRuntime().exec("src/test/resources/toxiproxy-server-windows-amd64.exe");
		client = new ToxiproxyClient("127.0.0.1", 8474);
		
		httpProxy = client.createProxy("http-tproxy", "127.0.0.1:8888", "127.0.0.1:3000");
		httpBackendProxy = client.createProxy("http-backend-tproxy", "127.0.0.1:8889", "127.0.0.1:5000");
	}
	
	/*latency
	Add a delay to all data going through the proxy. The delay is equal to latency +/- jitter.
	Attributes:
	latency: time in milliseconds
	jitter: time in milliseconds*/
	@Test
	public void latencyTest() throws Exception {
		
    	WsStep.userRequests("sample.reqwithbody1");
		WsStep.responseShouldHaveStatusCode(200);

		// create toxic
		httpProxy.toxics().latency("latency-toxic", ToxicDirection.DOWNSTREAM, 12000).setJitter(15);

    	WsStep.userRequests("sample.reqwithbody1");
		WsStep.responseShouldHaveStatusCode(200);
		
		
	}
	
	@Test
	public void latencyTest_api() throws Exception {
    	WsStep.userRequests("sample.reqwithbody1");
		WsStep.responseShouldHaveStatusCode(200);

		// create toxic
		httpBackendProxy.toxics().latency("latency-toxic", ToxicDirection.DOWNSTREAM, 12000).setJitter(15);

    	WsStep.userRequests("sample.reqwithbody1");
		WsStep.responseShouldHaveStatusCode(200);
		
		
	}
	
	/*timeout
	Stops all data from getting through, and closes the connection after timeout. If timeout is 0, the connection won't close, and data will be delayed until the toxic is removed.
	Attributes:
	timeout: time in milliseconds*/
	@Test
	public void timeoutTest() throws Exception {
		
    	WsStep.userRequests("sample.reqwithbody1");
		WsStep.responseShouldHaveStatusCode(200);

		// create toxic
		httpProxy.toxics().timeout("timeout-toxic", ToxicDirection.DOWNSTREAM, 1000);

    	WsStep.userRequests("sample.reqwithbody1");
		WsStep.responseShouldHaveStatusCode(400);
		
		httpProxy.delete();
		
		WsStep.userRequests("sample.reqwithbody1");
		WsStep.responseShouldHaveStatusCode(400);
		
	}
	
	@Test
	public void timeoutTest1() throws Exception {
		
    	WsStep.userRequests("sample.reqwithbody2");
		WsStep.responseShouldHaveStatusCode(200);

		// create toxic
		httpBackendProxy.toxics().timeout("timeout-toxic", ToxicDirection.DOWNSTREAM, 1000);

    	WsStep.userRequests("sample.reqwithbody2");
		WsStep.responseShouldHaveStatusCode(400);
		
		
		
	}
	
	
	/*limit_data
	Closes connection when transmitted data exceeded limit.
	bytes: number of bytes it should transmit before connection is closed*/
	@Test
	public void limitDataTest() throws Exception {
		
    	WsStep.userRequests("sample.reqwithbody1");
		WsStep.responseShouldHaveStatusCode(200);

		// create toxic
		httpProxy.toxics().limitData("limitData-toxic", ToxicDirection.DOWNSTREAM, 20);

    	WsStep.userRequests("sample.reqwithbody1");
		WsStep.responseShouldHaveStatusCode(200);
		
		
	}
	
	/*
	down
	Bringing a service down is not technically a toxic in the implementation of Toxiproxy. This is done by POSTing to /proxies/{proxy} and setting the enabled field to false.
	
	bandwidth
	Limit a connection to a maximum number of kilobytes per second.
	Attributes:
	rate: rate in KB/s

	slow_close
	Delay the TCP socket from closing until delay has elapsed.
	Attributes:
	delay: time in milliseconds
	
	slicer
	Slices TCP data up into small bits, optionally adding a delay between each sliced "packet".
	Attributes:
	average_size: size in bytes of an average packet
	size_variation: variation in bytes of an average packet (should be smaller than average_size)
	delay: time in microseconds to delay each packet by*/
	
	@Test
	public void slowCloseTest() throws Exception {
		
    	WsStep.userRequests("sample.reqwithbody1");
		WsStep.responseShouldHaveStatusCode(200);

		// create toxic
		httpBackendProxy.toxics().slowClose("slowclose-toxic", ToxicDirection.DOWNSTREAM, 10000);

    	WsStep.userRequests("sample.reqwithbody1");
		WsStep.responseShouldHaveStatusCode(200);
		
		
	}
	
	
	  @AfterMethod 
	  public void afterTest() throws Exception { 
	  httpProxy.delete();
	  httpBackendProxy.delete();
	  Runtime.getRuntime().exec("TASKKILL /F /IM src/test/resources/toxiproxy-server-windows-amd64.exe");
	  
	  }
	 
	
	/*
	 * @AfterSuite public void teardown() throws Exception { //httpProxy.delete();
	 * //httpBackendProxy.delete();
	 * //Runtime.getRuntime().exec("KILL toxiproxy-server-windows-amd64.exe");
	 * 
	 * }
	 */
	 
	
	
	
}
