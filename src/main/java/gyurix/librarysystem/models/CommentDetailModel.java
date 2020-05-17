package gyurix.librarysystem.models;

public class CommentDetailModel {
    public static final String MODEL_ATTRIB = "commentDetail";

    protected String adminResponse;

    public CommentDetailModel(String adminResponse) {
        this.adminResponse = adminResponse;
    }

    public String getAdminResponse() {
        return adminResponse;
    }

    public void setAdminResponse(String adminResponse) {
        this.adminResponse = adminResponse;
    }
}
