/*
 * package com.xworkz.mani.Entity;
 * 
 * import java.time.LocalDateTime;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.FetchType; import javax.persistence.Id; import
 * javax.persistence.JoinColumn; import javax.persistence.ManyToOne; import
 * javax.persistence.Table;
 * 
 * import lombok.AllArgsConstructor; import lombok.Data; import
 * lombok.NoArgsConstructor; import lombok.ToString;
 * 
 * @Data
 * 
 * @ToString
 * 
 * @Entity
 * 
 * @NoArgsConstructor
 * 
 * @AllArgsConstructor
 * 
 * @Table(name = "add.t_technology") public class TechnologyEntity {
 * 
 * @Id
 * 
 * @Column(name = "a_id") private int id;
 * 
 * @Column(name = "a_technology") private String technologyName;
 * 
 * @Column(name = "a_language") private String languange;
 * 
 * @Column(name = "a_version") private Double version;
 * 
 * @Column(name = "a_owner") private String owner;
 * 
 * @Column(name = "a_supportForm") private String supportFrom;
 * 
 * @Column(name = "a_supportTo") private String supportTo;
 * 
 * @Column(name = "a_licenseNo") private String licenseNo;
 * 
 * @Column(name = "a_openSource") private String openSource;
 * 
 * @Column(name = "a_osType") private String osType;
 * 
 * @Column(name = "a_createdBy") private String createdBy;
 * 
 * @Column(name = "a_createdDate") private LocalDateTime createdDate;
 * 
 * @Column(name = "a_updatedBy") private String updatedBy;
 * 
 * @Column(name = "a_updatedDate") private LocalDateTime updatedDate;
 * 
 * @ManyToOne(fetch = FetchType.LAZY, optional = false)
 * 
 * @JoinColumn(name = "s_id", referencedColumnName = "s_id") private
 * SingInEntity singInEntity;
 * 
 * }
 */