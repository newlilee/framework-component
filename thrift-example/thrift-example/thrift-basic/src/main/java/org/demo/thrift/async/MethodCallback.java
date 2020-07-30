package org.demo.thrift.async;

import org.apache.thrift.async.AsyncMethodCallback;

public class MethodCallback implements AsyncMethodCallback {

    private Object response = null;

    public Object getResult() {
        return this.response;
    }

    @Override
    public void onComplete(Object response) {
        this.response = response;
    }

    @Override
    public void onError(Exception exception) {

    }
}
