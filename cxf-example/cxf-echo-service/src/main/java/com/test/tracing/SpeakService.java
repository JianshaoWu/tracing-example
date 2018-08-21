package com.test.tracing;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/speak")
public interface SpeakService {

    @POST
    @Path("/say")
    String say(String msg);
}
