package test.com.jfinal.plugin.jms;

import java.io.Serializable;

import com.jfinal.plugin.jms.ReceiveResolver;

public class AReceiveResolver implements ReceiveResolver {

	@Override
	public void resolve(Serializable objectMessage) throws Exception {
		System.out.println("AReceiveResolver");
	}

}
