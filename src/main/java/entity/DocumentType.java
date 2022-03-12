package entity;

import javax.persistence.*;

@Entity
@Table
public class DocumentType {

    @Id
    private String id;

    @Column
    private String documentType;

    @OneToOne( mappedBy = "documentType")
    private Request request;

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

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }


}
