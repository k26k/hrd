package com.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.boot.config.BaseEntity;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class ItemImage extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_image_id")
	private Long id;
	
	private String imageName;

	private String originName;
	
	private String imageUrl;
	
	private String repImgYn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id")
	private Item item; 
	
//	이미지 수정
	
	public void updateItemImage(String imageName, String originName, String imageUrl) {
		this.imageName = imageName;
		this.originName = originName;
		this.imageUrl = imageUrl;
	}
	
}
