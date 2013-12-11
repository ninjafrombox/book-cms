package com.samara.mentoring.bookcms.ejb;

import java.util.Date;
import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 * Asynchronous example
 *
 * @author ninjafrombox@users.noreply.github.com
 */
@Stateless
@Asynchronous
public class AsyncTask {
    public void doLongWork() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) { }
    }

    public Future<String> getImportantInfo() {
        return new AsyncResult<String>(new Date().toString());
    }
}
