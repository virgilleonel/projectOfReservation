package de.tekup.loanwhitetest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import de.tekup.loanwhitetest.service.ReservationService;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;

@Endpoint
public class reservationEndpoint {
	public static final String namespace="http://www.tekup.de/soap/models/whitetest";
    @Autowired
    ReservationService service;
	@PayloadRoot(namespace =namespace ,localPart="StudentRequest") 
	@ResponsePayload
	public WhiteTestResponse getReservation(@RequestPayload StudentRequest studentrequest) throws Exception {
		return service.reservation(studentrequest);
	}
}

