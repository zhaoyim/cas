package org.apereo.cas.audit.entity;

import lombok.extern.slf4j.Slf4j;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * This is {@link AuditTrailEntity} that represents the audit table.
 * Schema is generated automatically.
 *
 * @author Misagh Moayyed
 * @since 4.2.0
 */
@Entity(name = "COM_AUDIT_TRAIL")
@Slf4j
@Getter
@Setter
public class AuditTrailEntity {

    /**
     * Audit table name.
     */
    public static final String AUDIT_TRAIL_TABLE_NAME = "COM_AUDIT_TRAIL";

    @org.springframework.data.annotation.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;

    @Column(name = "AUD_USER")
    private String user;

    @Column(name = "AUD_CLIENT_IP")
    private String clientIp;

    @Column(name = "AUD_SERVER_IP")
    private String serverIp;

    @Column(name = "AUD_RESOURCE")
    private String resource;

    @Column(name = "AUD_ACTION")
    private String action;

    @Column(name = "APPLIC_CD")
    private String applicationCode;

    @Column(name = "AUD_DATE", nullable = false, columnDefinition = "TIMESTAMP")
    private ZonedDateTime date;

    public AuditTrailEntity() {
        this.id = System.currentTimeMillis();
    }

    public long getId() {
        return this.id;
    }

    public ZonedDateTime getDate() {
        return this.date;
    }
}
