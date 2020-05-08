package com.java456.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.java456.entity.Bank;
import com.java456.entity.Message;


public interface MessageDao extends JpaRepository<Message, Integer>, JpaSpecificationExecutor<Message> {
    @Query(value = "select * from t_message where id = ?1", nativeQuery = true)
    public Message findId(Integer id);
    @Query(value = "select * from t_message where order_No = ?1", nativeQuery = true)
    public Message findOrderNo(Integer order_No);
    @Query(value = "SELECT * FROM t_message WHERE message_type_id=1 ", nativeQuery = true)
    public  List<Message> findAllMovies();   
    @Query(value = "SELECT * FROM t_message WHERE message_type_id=2 ", nativeQuery = true)
    public  List<Message> findAllTravel();  
    @Query(value = "SELECT * FROM t_message WHERE message_type_id=3 ", nativeQuery = true)
    public  List<Message> findAllFood();   
    @Query(value = "SELECT * FROM t_message WHERE message_type_id=4 ", nativeQuery = true)
    public  List<Message> findAllBank();   
    @Query(value = "SELECT * FROM t_message WHERE message_type_id=5 ", nativeQuery = true)
    public  List<Message> findAllEntertainm();   
    @Query(value = "SELECT * FROM t_message WHERE message_type_id=6 ", nativeQuery = true)
    public  List<Message> findAllTraffic(); 
    //@Transactional
    //@Modifying
   // @Query(value="UPDATE t_message SET price=:price where order_no=:Order_No",nativeQuery=false)
    //public void updateMessage(@Param("message")Message message);
	@Query(value="select * from t_message  where source like CONCAT('%',:source,'%')",nativeQuery=true)
    List<Message> seachMessage(@Param("source") String source);;
    @Query(value="select * from t_message  order by create_date_time ",nativeQuery=true)
    List<Message> searchNewMessage();	
}
