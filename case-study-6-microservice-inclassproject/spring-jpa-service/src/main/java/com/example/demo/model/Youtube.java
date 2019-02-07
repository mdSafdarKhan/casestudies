package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="youtube", catalog="youtube_channels")
public class Youtube {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="rank")
	private String rank;
	
	@Column(name="channel_name")
	private String channelName;
	
	@Column(name="video_uploads")
	private Long videoUploads;
	
	@Column(name="subscribers")
	private Long subscribers;
	
	@Column(name="video_views")
	private Long videoViews;

}
