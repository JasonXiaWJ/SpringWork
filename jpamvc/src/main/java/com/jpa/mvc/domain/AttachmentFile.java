package com.jpa.mvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class AttachmentFile extends IdEntity {
    private static final long serialVersionUID = -5705758358154048501L;

    @Lob
    @Column(name = "doc")
    private byte[] file;
}
