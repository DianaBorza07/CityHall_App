package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class DocumentType {

    @Id
    private String id;

    @Column
    private String documentType;

    @OneToMany( mappedBy = "documentType")
    private List<Request> requests;

    public DocumentType() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
}
