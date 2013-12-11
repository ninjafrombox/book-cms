package com.samara.mentoring.bookcms.ejb;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

/**
 * lifeTime counter increases once a minute
 *
 * @author ninjafrombox@users.noreply.github.com
 */
@Singleton
public class Timer {
    private long lifeTime = 0;

    public long getLifeTime() {
        return lifeTime;
    }

    @Schedule(second="*/60", minute="*", hour="*")
    public void doWork() {
        lifeTime++;
    }
}
