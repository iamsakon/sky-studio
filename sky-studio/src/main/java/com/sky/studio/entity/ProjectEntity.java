/**
 * 
 */
package com.sky.studio.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Inheritance;
import javax.persistence.Column;

/**
 * @author MrMai
 *
 */
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "SKY_PROJECT")
@SequenceGenerator(name = "SEQ_SKY_PROJECT", sequenceName = "seq_sky_project")
@Entity
public class ProjectEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected Long id;
	
	@Column(name = "code", nullable = false)
    protected String code;

    @Column(name = "name")
    protected String name;

    @Column(name = "group_id", length = 128)
    protected String groupId;

    @Column(name = "artifact_id")
    protected String artifactId;

    @Column(name = "path")
    protected String path;

    @Version
    @Column(name = "VERSION")
    protected Integer version;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
