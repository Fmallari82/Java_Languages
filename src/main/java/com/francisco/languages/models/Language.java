package com.francisco.languages.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 3, max = 200, message=" name needs to be at least 3 characters long")
    private String name;
    
    @NotNull
    @Size(min = 3, max = 200, message="creator needs to be at least 3 characters long")
    private String creator;
    
    @NotNull
    @Size(min = 3, max = 200, message="Version needs to be at least 3 characters long")
    private String version;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    

	public Language() {}

	public Language(
			@NotNull @Size(min = 3, max = 200, message = " name needs to be at least 3 characters long") String name,
			@NotNull @Size(min = 3, max = 200, message = "creator needs to be at least 3 characters long") String creator,
			@NotNull @Size(min = 3, max = 200, message = "Version needs to be at least 3 characters long") String version) {
		super();
		this.name = name;
		this.creator = creator;
		this.version = version;
	}

	public Language(Long id,
			@NotNull @Size(min = 3, max = 200, message = " name needs to be at least 3 characters long") String name,
			@NotNull @Size(min = 3, max = 200, message = "creator needs to be at least 3 characters long") String creator,
			@NotNull @Size(min = 3, max = 200, message = "Version needs to be at least 3 characters long") String version) {
		super();
		this.id = id;
		this.name = name;
		this.creator = creator;
		this.version = version;
	}

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
