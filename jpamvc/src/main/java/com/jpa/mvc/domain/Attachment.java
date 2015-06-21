package com.jpa.mvc.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Attachment extends IdEntity {
    private static final long serialVersionUID = -5705758358154048501L;

    private String attachName;
    private String remark;
    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private AttachmentFile attachmentFile;
}
