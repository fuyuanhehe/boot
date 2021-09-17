package com.boot.boot.shiro;

import com.boot.boot.redis.RedisServiceImpl;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.SerializationUtils;

import java.io.Serializable;
import java.util.Collection;

public class CustomSessionDao extends AbstractSessionDAO {

    @Autowired
    RedisServiceImpl<byte[]> redisService;

    @Override
    protected Serializable doCreate(Session session) {

        Serializable sessionId = generateSessionId(session);
        byte[] value = SerializationUtils.serialize(session);
        redisService.set(sessionId.toString(), value, 3600L);

        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable serializable) {
        if (serializable == null) {
            return null;
        }
        String sessionId = serializable.toString();
        byte[] value = redisService.get(sessionId);

        Session session = (Session) SerializationUtils.deserialize(value);
        return session;
    }

    @Override
    public void update(Session session) {
        String sessionId = session.getId().toString();

        byte[] value = SerializationUtils.serialize(session);
        redisService.set(sessionId, value);
    }

    @Override
    public void delete(Session session) {
        String sessionId = session.getId().toString();
        redisService.remove(sessionId);
    }

    @Override
    public Collection<Session> getActiveSessions() {
   /*     Set<byte[]> values = redisService.get(SHIRO_PREX);

        if (CollectionUtils.isEmpty(values)) {
            return null;
        }
        Set<Session> sessionSet = new HashSet<>();
        for (byte[] v : values) {
            Session session = (Session) SerializationUtils.deserialize(v);
            sessionSet.add(session);
        }
        return sessionSet;*/
        return null;
    }
}
