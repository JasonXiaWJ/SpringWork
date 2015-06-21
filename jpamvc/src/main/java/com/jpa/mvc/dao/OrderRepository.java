package com.jpa.mvc.dao;

import java.util.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jpa.mvc.domain.order.BaseOrder;

@Repository
public interface OrderRepository extends JpaSpecificationExecutor<BaseOrder>, JpaRepository<BaseOrder, Long> {
    
    BaseOrder findByNo(String no);

    BaseOrder findByNoAndCustomerId(String no, Long customerId);

    /**
     * Find a set of order IDs which have state change after the given date.
     * 
     * @param date
     * @return
     */
    @Query("select a.id from BaseOrder a where a.orderAuditState.auditDate >= ?1")
    Set<Long> findByStateChangeAfter(Date date);

    /**
     * Find a set of order IDs which have shipment update after the given date.
     * 
     * @param date
     * @return
     */
    @Query("select a.baseOrder.id from Shipment a where a.modifiedDate >= ?1")
    Set<Long> findByShipmentUpdateAfter(Date date);

    /**
     * Find order no by order id.
     * 
     * @param id
     * @return
     */
    @Query("select a.no from BaseOrder a where a.id = ?1")
    String findNoById(Long id);

    /**
     * Find order audit state id by order id.
     * 
     * @param id
     * @return
     */
    @Query("select a.orderAuditState.id from BaseOrder a where a.id = ?1")
    Long findAuditStateIdById(Long id);
    
    @Query(value = "select audit_date from (select  casu.audit_date from ORDER_AUDIT_STATE_AUD casu where casu.audit_type=?1 and casu.id=?2 order by casu.audit_date desc) auds where rownum = 1", nativeQuery = true)
    Object findAuditDateByAuditTypeAndId(String auditType, Long stateId);
    
    @Query(value = "select account_id from (select  casu.account_id from ORDER_AUDIT_STATE_AUD casu where casu.audit_type=?1 and casu.id=?2 order by casu.audit_date desc) auds where rownum = 1", nativeQuery = true)
    Object findAccountIdByAuditTypeAndId(String auditType, Long stateId);
    
}
