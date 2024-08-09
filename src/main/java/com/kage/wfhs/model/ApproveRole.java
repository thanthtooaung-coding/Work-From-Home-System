/*
 * @Author 		 : Valhalla TKT (DAT OJT Batch II - Team III)
 * @Date 		 : 2024-04-24
 * @Time  		 : 21:00
 * @Project_Name : Work From Home System
 * @Contact      : tktvalhalla@gmail.com
 */
package com.kage.wfhs.model;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "approve_role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApproveRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;

	@ManyToMany(mappedBy = "approveRoles")
	@JsonIgnore
	@ToString.Exclude
	private List<User> users;

	@OneToMany(mappedBy = "approveRole", cascade = CascadeType.ALL)
	@ToString.Exclude
	@JsonIgnore
	private List<WorkFlowOrder> workFlowOrders;
	
	@OneToMany(mappedBy = "approveRole", cascade = CascadeType.ALL)
	@ToString.Exclude
	@JsonIgnore
	private List<WorkFlowStatus> workFlowStatuses;

	@ManyToMany
	@JoinTable(name = "approve_role_team",
			joinColumns = @JoinColumn(name = "approve_role_id"),
			inverseJoinColumns = @JoinColumn(name = "team_id"))
	@ToString.Exclude
	@JsonIgnore
	private Set<Team> teams;

	@ManyToMany
	@JoinTable(name = "approve_role_department",
			joinColumns = @JoinColumn(name = "approve_role_id"),
			inverseJoinColumns = @JoinColumn(name = "department_id"))
	@ToString.Exclude
	@JsonIgnore
	private Set<Department> departments;

	@ManyToMany
	@JoinTable(name = "approve_role_division",
			joinColumns = @JoinColumn(name = "approve_role_id"),
			inverseJoinColumns = @JoinColumn(name = "division_id"))
	@ToString.Exclude
	@JsonIgnore
	private Set<Division> divisions;

}
