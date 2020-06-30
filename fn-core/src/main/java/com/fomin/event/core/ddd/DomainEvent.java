package com.fomin.event.core.ddd;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author fomin
 * @since 2020/6/30
 */
public interface DomainEvent extends Serializable {

    /**
     * 获取当前时间
     *
     * @return Instant
     */
    Instant getCurrentTime();
}
