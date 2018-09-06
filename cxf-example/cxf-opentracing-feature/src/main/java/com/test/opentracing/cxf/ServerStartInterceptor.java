package com.test.opentracing.cxf;

import java.util.List;
import java.util.Map;

import org.apache.cxf.helpers.CastUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;

import io.opentracing.Tracer;

public class ServerStartInterceptor extends AbstractServerInterceptor {

    public ServerStartInterceptor(final Tracer tracer) {
        super(Phase.PRE_INVOKE, tracer);
    }

    public ServerStartInterceptor(final String phase, final Tracer tracer) {
        super(phase, tracer);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        final Map<String, List<String>> headers = CastUtils.cast((Map<?, ?>) message.get(Message.PROTOCOL_HEADERS));

        final TraceScopeHolder<TraceScope> holder = super.startTraceSpan(headers, getUri(message),
                (String) message.get(Message.HTTP_REQUEST_METHOD));

        if (holder != null) {
            message.getExchange().put(TRACE_SPAN, holder);
        }
    }
}
