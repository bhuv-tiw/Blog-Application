package com.SocialMedia.Chat.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="users")
@Data
@AllArgsConstructor
public class User {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column
	private Integer id;
	@Column
	private String first_name;
	@Column
	private String last_name;
	@Column
	private String email;
	@Column
	private String password;
	
	private List<Integer> followers=new ArrayList<>();
	
	private List<Integer> followings=new ArrayList<>();


	
	public User() {
		this.followers=new ArrayList<>();
		this.followings=new ArrayList<>();
	}

	

	public List<Integer> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Integer> followers) {
		this.followers = followers;
	}

	public List<Integer> getFollowings() {
		return followings;
	}

	public void setFollowings(List<Integer> followings) {
		this.followings = followings;
	}
	
	
	
}
