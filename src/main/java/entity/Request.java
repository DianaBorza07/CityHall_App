package entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class Request {

    @Id
    private String id;

    @Column
    private Date date;

    @Column
    private String description;

    @Column
    private Boolean approved;

    @ManyToOne
    @JoinColumn(name = "document_type_id")
    private DocumentType documentType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User requestUser;

    public Request(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getRequestUser() {
        return requestUser;
    }

    public void setRequestUser(User requestUser) {
        this.requestUser = requestUser;
    }
}
